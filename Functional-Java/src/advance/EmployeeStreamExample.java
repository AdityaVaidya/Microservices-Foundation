package advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeStreamExample {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Adi", 26, 30000, Arrays.asList("Java", "Python")));
        employees.add(new Employee(2, "John", 34, 45000, Arrays.asList("C", "C++")));
        employees.add(new Employee(3, "Rushi", 21, 40000, Arrays.asList("Java", "Javascript")));
        employees.add(new Employee(4, "Nexus", 28, 35000, Arrays.asList("C", "Python")));
        employees.add(new Employee(5, "Shiv", 32, 32000, Arrays.asList("Java", "C++")));

        // Filtering employees older than 30
        List<Employee> filteredEmployees = employees.stream()
                .filter(e -> e.getAge() > 30)
                .collect(Collectors.toList());

        System.out.println("Filtered employees:");
        filteredEmployees.forEach(e -> System.out.println(e.getName()));

        // Mapping employees to their skills
        List<List<String>> employeeSkills = employees.stream()
                .map(Employee::getSkills)
                .collect(Collectors.toList());

        System.out.println("\nEmployee skills:");
        employeeSkills.forEach(System.out::println);

        // Flat-mapping employee skills
        List<String> allSkills = employees.stream()
                .flatMap(e -> e.getSkills().stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("\nAll skills:");
        allSkills.forEach(System.out::println);

        // Finding the first employee with a specific skill
        Optional<Employee> firstJavaEmployee = employees.stream()
                .filter(e -> e.getSkills().contains("Java"))
                .findFirst();

        firstJavaEmployee.ifPresent(employee -> System.out.println("\nFirst Java employee: " + employee.getName()));
    }
}