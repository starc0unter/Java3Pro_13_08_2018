package reflection;

import java.lang.reflect.Modifier;

public class Main {

    public static void main(String[] args) {
        String str = "Java";
        Class<?> strType = str.getClass();
        System.out.println(strType);
        System.out.println(strType.getSimpleName());
        System.out.println(strType.getName());

        System.out.println(Integer.class);
        System.out.println(int.class);
        System.out.println(int[].class);
        System.out.println(void.class);

        try {
            Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        int modifiers = strType.getModifiers();
        if (Modifier.isPublic(modifiers)) {
            System.out.println(strType.getSimpleName() + " - is public");
        }
        if (Modifier.isAbstract(modifiers)) {
            System.out.println(strType.getSimpleName() + " - is abstract");
        }
        if (Modifier.isFinal(modifiers)) {
            System.out.println(strType.getSimpleName() + " - is final");
        }

        while (strType != null) {
            System.out.println(strType);
            strType = strType.getSuperclass();
        }
//        strType.getSuperclass();


    }
}
