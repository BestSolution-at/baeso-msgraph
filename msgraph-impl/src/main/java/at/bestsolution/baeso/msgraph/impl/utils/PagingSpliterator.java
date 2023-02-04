package at.bestsolution.baeso.msgraph.impl.utils;

import java.util.Spliterators.AbstractSpliterator;
import java.util.function.Consumer;
import java.util.function.Function;

import at.bestsolution.baeso.msgraph.impl.GraphClientImpl;
import jakarta.json.JsonObject;

public class PagingSpliterator<T> extends AbstractSpliterator<T> {
		private final GraphClientImpl client;
		private final Function<JsonObject, T> elementCreator;
		private JsonObject currentResult;
		private int index = 0;
		
		public PagingSpliterator(GraphClientImpl client, JsonObject currentResult, Function<JsonObject, T> elementCreator) {
			super(Long.MAX_VALUE, 0);
			this.client = client;
			this.elementCreator = elementCreator;
			this.currentResult = currentResult;
		}
		
		@Override
		public boolean tryAdvance(Consumer<? super T> action) {
			var array = this.currentResult.getJsonArray("value");
			if( index < array.size() ) {
				action.accept(elementCreator.apply(array.getJsonObject(index)));
				index += 1;
				return true;
			} else if( currentResult.containsKey("@odata.nextLink") ) {
				currentResult = client.GET(currentResult.getString("@odata.nextLink"));
				index = 0;
				if( currentResult != null ) {
					array = currentResult.getJsonArray("value");
					if( index < array.size() ) {
						action.accept(elementCreator.apply(array.getJsonObject(index)));
						index += 1;	
						return true;
					}	
				}
			}
			return false;
		}
		
	}