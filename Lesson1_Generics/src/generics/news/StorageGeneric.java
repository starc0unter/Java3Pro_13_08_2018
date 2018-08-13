package generics.news;

public interface StorageGeneric<Type extends Comparable<? super Type>> {

    void add(Type value);

    void add(Type value, int index);

    void remove(int index);

    Type get(int index);

    boolean find(Type value);

    public void display();
}
