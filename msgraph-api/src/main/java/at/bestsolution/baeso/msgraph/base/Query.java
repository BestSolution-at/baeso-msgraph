package at.bestsolution.baeso.msgraph.base;

import java.util.stream.Stream;

public interface Query<T> {
	public Stream<T> stream();
	public Stream<T> stream(int pageSize);
}
