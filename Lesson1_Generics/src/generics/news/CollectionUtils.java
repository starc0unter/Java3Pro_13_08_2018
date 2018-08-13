package generics.news;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtils {

    public static <T, R> List<R> transform(List<T> collection, Transformer<T, R> transformer) {
        List<R> list = new ArrayList<>();
        for (T value : collection) {
            list.add(transformer.transform(value));
        }
        return list;
    }
}
