package generics.old;

public class StringStorage implements Storage {

    private Object[] data;
    private int currentSize;

    public StringStorage(int size) {
        this.data =  new String[size];//[null, null, null]
    }

    @Override
    public Object get(int index) {
        return data[index];
    }

    public void add(Object value) {
        add(value, currentSize);
    }

    public void add(Object value, int index) {
        data[index] = value;//["Str", 0, 0]
        currentSize++;
    }

    public void remove(int index) {//[-1, 0, 0]
        data[index] = null;
        currentSize--;
    }

    public boolean find(Object value) {
        for (int i = 0; i < currentSize; i++) {
            if (value.equals(data[i])) {
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
