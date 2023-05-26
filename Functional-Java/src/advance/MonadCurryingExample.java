package advance;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;

public class MonadCurryingExample {

    public static void main(String[] args) {
        Employee employee = new Employee(1, "Adi", 26, 30000, Arrays.asList("Java", "Python"));

        // Example of using the Maybe monad
        Optional<Employee> maybeEmployee = Optional.ofNullable(employee);

        // Applying currying to get specific employee details
        Function<Employee, Function<Integer, String>> getEmployeeDetails = emp -> age -> "Name: " + emp.getName()
                + ", Age: " + emp.getAge() + ", Salary: " + emp.getSalary() + ", Input Age: " + age;

        // Using monadic operations and currying together
        String result = maybeEmployee
                .map(getEmployeeDetails)
                .map(details -> details.apply(25)) // Partial application of curried function
                .orElse("No employee found");

        System.out.println(result);
    }
}
