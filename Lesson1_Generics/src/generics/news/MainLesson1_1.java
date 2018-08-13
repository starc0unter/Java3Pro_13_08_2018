package generics.news;

import generics.old.Storage;
import generics.old.StorageImpl;

import java.time.LocalDate;
import java.util.List;

public class MainLesson1_1 {

    public static void main(String[] args) {
        StorageGeneric<String> strStorage = new StorageGenericImpl<>(new String[5]);
        strStorage.add("1");
        strStorage.add("2");
        strStorage.add("3");
        strStorage.add("4");

        String strValue = strStorage.get(0);
        strStorage.display();

        StorageGeneric<Integer> intStorage = new StorageGenericImpl<>(new Integer[5]);
        intStorage.add(1);
        intStorage.add(2);
        intStorage.add(3);
        intStorage.add(4);

        Transformer<Integer, String> transformer = new Transformer<>() {
            @Override
            public String transform(Integer value) {
                return String.valueOf(value);
            }
        };

        System.out.println(transformer.transform(5));

        System.out.println("---------- int collection----");
        List<Integer> intCollection = List.of(1, 2 , 3);

        // lambda(Object x) { System.out.println(x) }
        // x -> System.out.println(x)
        intCollection.forEach(System.out::println);

//        for (Integer integer : intCollection) {
//            System.out.println(integer);
//        }



        List<String> newCollection = CollectionUtils.transform(intCollection, String::valueOf);
        System.out.println("---------- string collection----");
        newCollection.forEach(System.out::println);

        StorageGeneric<LocalDate> dateStorage = new StorageGenericImpl<>(new LocalDate[10]);

        //strStorage = intStorage;
    }
}
