package generics.news;

@FunctionalInterface
public interface Transformer<T, R> {

    R transform(T value);
}
