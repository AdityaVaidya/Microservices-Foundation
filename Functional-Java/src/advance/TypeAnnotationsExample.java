package advance;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE_PARAMETER, ElementType.TYPE_USE })
@interface MyTypeAnnotation {
}

class MyClass<@MyTypeAnnotation T> {
    public void process(@MyTypeAnnotation T data) {
        System.out.println("Processing data: " + data);
    }
}

public class TypeAnnotationsExample {
    public static void main(String[] args) {
        MyClass<String> myObject = new MyClass<>();
        myObject.process("Hello, World!");
    }
}
