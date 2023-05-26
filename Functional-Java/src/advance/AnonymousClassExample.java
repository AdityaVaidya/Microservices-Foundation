package advance;

// A simple interface with a single method
interface Greeting {
    void greet();
}

public class AnonymousClassExample {
    public static void main(String[] args) {

        // Creating an instance of the interface using an anonymous class
        Greeting greeting = new Greeting() {
            @Override
            public void greet() {
                System.out.println("Hello, world!");
            }
        };

        // Calling the greet() method of the interface
        greeting.greet();
    }
}