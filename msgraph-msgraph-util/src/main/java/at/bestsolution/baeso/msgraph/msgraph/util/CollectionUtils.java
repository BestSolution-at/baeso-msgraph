package at.bestsolution.baeso.msgraph.msgraph.util;

import java.util.Spliterators.AbstractSpliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.microsoft.graph.http.BaseCollectionPage;
import com.microsoft.graph.http.BaseRequestBuilder;

public class CollectionUtils {
	static class BaseCollectionPageSpliterator<T, X extends BaseCollectionPage<T, ? extends BaseRequestBuilder<T>>> extends AbstractSpliterator<T> {
		private Function<X, Supplier<X>> nextPage;
		private X collection;
		private int count = 0;
		
		BaseCollectionPageSpliterator(X collection, Function<X, Supplier<X>> nextPage) {
			super(collection.getCount() == null ? Long.MAX_VALUE : collection.getCount(), collection.getCount() == null ? 0 : SIZED);
			this.collection = collection;
		}

		@Override
		public boolean tryAdvance(Consumer<? super T> action) {
			if( count < this.collection.getCurrentPage().size() ) {
				action.accept(this.collection.getCurrentPage().get(count));
				count += 1;
				return count < this.collection.getCurrentPage().size();
			} else {
				var nextPageRequest = nextPage.apply(this.collection);
				if( nextPageRequest != null ) {
					count = 0;
					collection = nextPageRequest.get();
					action.accept(this.collection.getCurrentPage().get(count));
					count += 1;
					return count < this.collection.getCurrentPage().size();
				}
			}
			return false;
		}
	}
	
	public static <T, X extends BaseCollectionPage<T, ? extends BaseRequestBuilder<T>>> Stream<T> toStream(X collection, Function<X, Supplier<X>> nextPage) {
		return StreamSupport.stream(new BaseCollectionPageSpliterator<>(collection, nextPage), false);
	}
}
