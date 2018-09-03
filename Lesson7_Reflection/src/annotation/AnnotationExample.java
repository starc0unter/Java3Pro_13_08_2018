package annotation;

import java.lang.reflect.Method;

@MarkingAnnotation(value = 2.0f)
public class AnnotationExample {

    @MarkingAnnotation(1.5f)
    private String name;

    @MarkingAnnotation(2.2f)
    public void markedMethod() {
        System.out.println("Java");
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method markedMethod = AnnotationExample.class.getMethod("markedMethod");
        MarkingAnnotation annotation = markedMethod.getAnnotation(MarkingAnnotation.class);
        if (annotation != null) {
            System.out.println("Annotation value = " + annotation.value());
        }
    }
}
