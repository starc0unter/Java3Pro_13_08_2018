package objects.stream;

import java.io.*;

public class Person extends Human implements Serializable {
    private static final long serialVersionUID = 2L;


    public String name;
    public Person friend;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", friend=" + friend +
                '}';
    }

//    @Override
//    public void writeExternal(ObjectOutput out) throws IOException {
//        out.writeObject(name);
//        out.writeObject(friend);
//    }
//
//    @Override
//    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//        name = (String) in.readObject();
//        friend = (Person) in.readObject();
//    }
}
