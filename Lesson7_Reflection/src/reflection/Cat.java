package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Cat {

    private String name;
    public String color;
    int age = 10;

    Cat() {

    }

    private static Cat instance;

    public static Cat getInstance() {
        if (instance == null) {
            instance = new Cat("", "", 5);
        }
        return instance;
    }

    private Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void meow(int db) {
        System.out.println(name + ": meow - " + db + " dB");
    }

    private void jump() {
        System.out.println(name + ": jump");
    }



    @Override
    public String toString() {
        return "reflection.Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}

class MainClass {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class<Cat> catClass = Cat.class;

        //Fields
        Field[] fields = catClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Тип поля - Имя поля : " + field.getType().getName() + " - " + field.getName());
        }

        Cat cat = new Cat();
        Field nameField = cat.getClass().getDeclaredField("name");
        System.out.println("---------------");
        System.out.println(cat);

        nameField.setAccessible(true);
        nameField.set(cat, "Boris");

//        cat.color = "yellow";

        System.out.println(cat);

        Field ageField = cat.getClass().getDeclaredField("age");
        ageField.setAccessible(true);
        System.out.println(cat);
        ageField.set(cat, 5);
        System.out.println(cat);


        //Constructors
        for (Constructor<?> constructor : cat.getClass().getDeclaredConstructors()) {
            System.out.println(constructor);
        }
        System.out.println("--------");

        try {
            System.out.println(cat.getClass().getConstructor(String.class, int.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        cat.getClass().getDeclaredField("age").setAccessible(true);
        for (Field field : cat.getClass().getFields()) {
            System.out.println("Тип поля - Имя поля : " + field.getType().getName() + " - " + field.getName());
        }


        //Methods
        Method[] methods = cat.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getReturnType() + " ||| " + method.getName() + " ||| "
                    + Arrays.toString(method.getParameterTypes()));
        }

        Method jumpMethod = cat.getClass().getDeclaredMethod("jump");
        jumpMethod.setAccessible(true);
        jumpMethod.invoke(cat);
        cat.getClass().getDeclaredMethod("meow", int.class).invoke(cat, 5);


        //New instance
        Constructor<? extends Cat> constructor = cat.getClass().getDeclaredConstructor(String.class, String.class, int.class);
        constructor.setAccessible(true);
        Cat newInstance = constructor.newInstance("Murzik", "Black", 3);
        System.out.println(newInstance);


    }
}
