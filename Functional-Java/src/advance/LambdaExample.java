package advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@FunctionalInterface
interface StringConverter {
    String convert(String text);
}

public class LambdaExample {

    public static List<Employee> filterEmployees(List<Employee> employees, Predicate<Employee> predicate) {
        List<Employee> filteredEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (predicate.test(employee)) {
                filteredEmployees.add(employee);
            }
        }
        return filteredEmployees;
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Adi", 26, 30000, Arrays.asList("Java", "Python")));
        employees.add(new Employee(2, "John", 34, 45000, Arrays.asList("C", "C++")));
        employees.add(new Employee(3, "Rushi", 21, 40000, Arrays.asList("Java", "Javascript")));
        employees.add(new Employee(4, "Nexus", 28, 35000, Arrays.asList("C", "Python")));
        employees.add(new Employee(5, "Shiv", 32, 32000, Arrays.asList("Java", "C++")));

        // Example 1: Using lambda expression with Predicate
        Predicate<Employee> salaryPredicate = employee -> employee.getSalary() > 40000;
        List<Employee> highSalaryEmployees = filterEmployees(employees, salaryPredicate);
        System.out.println("High Salary Employees:");
        for (Employee employee : highSalaryEmployees) {
            System.out.println(employee.getName());
        }

        // Example 2: Using lambda expression with Predicate
        Predicate<Employee> agePredicate = employee -> employee.getAge() < 30;
        List<Employee> youngEmployees = filterEmployees(employees, agePredicate);
        System.out.println("\nYoung Employees:");
        for (Employee employee : youngEmployees) {
            System.out.println(employee.getName());
        }

        // Example 3: Using lambda expression with functional interface method
        StringConverter upperCaseConverter = text -> text.toUpperCase();
        String convertedText = upperCaseConverter.convert("hello, world!");
        System.out.println("\nConverted Text: " + convertedText);
    }
}
