package generics.news;

public class StorageGenericImpl<T extends Comparable<? super T>> implements StorageGeneric<T> {

    private T[] data;
    private int currentSize;

    public StorageGenericImpl(T[] data) {
        this.data = data;
    }

    @Override
    public T get(int index) {
        return data[index];
    }

    public void add(T value) {
        add(value, currentSize);
    }

    public void add(T value, int index) {
        data[index] = value;//["Str", 0, 0]
        currentSize++;
    }

    public void remove(int index) {//[-1, 0, 0]
        data[index] = null;
        currentSize--;
    }

    public boolean find(T value) {
        for (int i = 0; i < currentSize; i++) {
            if (value.compareTo(data[i]) == 0) {
                return true;
            }
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
}
