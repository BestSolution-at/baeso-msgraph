package at.bestsolution.baeso.msgraph.base;

public class ID<T> {
	public final String id;
	
	ID(String id) {
		this.id = id;
	}
	
	public static final <T> ID<T> of(String id) {
		return new ID<>(id);
	}

	@Override
	public String toString() {
		return this.id;
	}
}
