package advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalEmployeeExample {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Adi", 26, 30000, Arrays.asList("Java", "Python")));
        employees.add(new Employee(2, "John", 34, 45000, Arrays.asList("C", "C++")));
        employees.add(new Employee(3, "Rushi", 21, 40000, Arrays.asList("Java", "Javascript")));
        employees.add(new Employee(4, "Nexus", 28, 35000, Arrays.asList("C", "Python")));
        employees.add(new Employee(5, "Shiv", 32, 32000, Arrays.asList("Java", "C++")));

        // Find the employee with the highest salary using Optional and lambda functions
        Optional<Employee> highestPaidEmployee = employees.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));

        highestPaidEmployee.ifPresent(employee -> System.out.println("Highest paid employee: " + employee));

        // Filter employees above a certain age using stream and lambda functions
        List<Employee> filteredEmployees = employees.stream()
                .filter(employee -> employee.getAge() > 30)
                .collect(Collectors.toList());

        System.out.println("Employees above 30 years old:");
        filteredEmployees.forEach(System.out::println);
    }
}
