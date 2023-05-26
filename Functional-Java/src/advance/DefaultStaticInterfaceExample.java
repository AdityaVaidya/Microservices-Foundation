package advance;

interface Printable {
    // Default method
    default void print() {
        System.out.println("Printing Employee Details");
    }

    // Static method
    static void showVersion() {
        System.out.println("Interface Version 1.0");
    }
}

public class DefaultStaticInterfaceExample implements Printable {
    public static void main(String[] args) {
        DefaultStaticInterfaceExample obj = new DefaultStaticInterfaceExample();
        obj.print();

        Printable.showVersion();
    }
}
