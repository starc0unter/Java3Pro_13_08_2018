package generics.old;

public class MainLesson1 {

    public static void main(String[] args) {
        Storage strStorage = new StorageImpl(5);
        strStorage.add("1");
        strStorage.add("2");
        strStorage.add("3");
        strStorage.add("4");

        String strValue = (String) strStorage.get(0);
        System.out.println("StrValue = " + strValue);

        Storage intStorage = new StorageImpl(5);
        intStorage.add(1);
        intStorage.add(2);
        intStorage.add("3");
        intStorage.add(4);

        int intValue = (int) intStorage.get(2);
        System.out.println("intValue = " + intValue);

        strStorage = intStorage;

        String strValue2 = (String) strStorage.get(1);

//        storage.remove(1);//Removing 2
//
//        System.out.println("Find 3 = " + storage.find("3"));
//        storage.display();
    }
}
