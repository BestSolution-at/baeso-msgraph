package at.bestsolution.baeso.msgraph.base;

@FunctionalInterface
public interface IndexBuilderFunction<T, R> {
    public R apply(int index, T builder);
}
