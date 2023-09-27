package at.bestsolution.baeso.msgraph.impl.utils;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import at.bestsolution.baeso.msgraph.base.IndexBuilderFunction;

public class BuilderUtils {
    public static <B, R> List<R> createList(int count, Supplier<B> builderFactory, IndexBuilderFunction<B, R> creator ) {
        return IntStream.of(count).mapToObj( v -> creator.apply(v, builderFactory.get()) ).collect(Collectors.toList());
    }
}
