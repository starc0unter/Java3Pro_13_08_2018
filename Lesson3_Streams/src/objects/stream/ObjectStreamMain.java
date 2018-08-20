package objects.stream;

import java.io.*;

public class ObjectStreamMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person p1 = new Person("p1");
        Person p2 = new Person("p2");
        Person p3 = new Person("p3");

        p1.friend = p3;
        p2.friend = p3;
        System.out.println(p1);
        System.out.println(p2);
//
        writeObject(p1, "object1.txt");
        writeObject(p2, "object2.txt");

        Person p4 = readObject("object1.txt");
        Person p5 = readObject("object2.txt");

        System.out.println(p4);
        System.out.println(p5);
        return;
    }

    private static Person readObject(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        Person p4 = (Person) in.readObject();
        in.close();
        return  p4;
    }

    private static void writeObject(Person p1, String fileName) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        out.writeObject(p1);
        out.close();
    }

}
