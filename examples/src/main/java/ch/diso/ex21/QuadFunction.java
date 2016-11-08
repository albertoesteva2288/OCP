package ch.diso.ex21;

@FunctionalInterface
interface QuadFunction<T, U, V, W, R> {

    R apply(T t, U u, V v, W w);

}