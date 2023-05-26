package advance;

import java.util.ArrayList;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        // Create a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,"Adi", 26, 30000));
        employees.add(new Employee(2,"John", 34, 45000));
        employees.add(new Employee(3, "Rushi", 21, 40000));
        employees.add(new Employee(4, "Nexus", 28, 35000));
        employees.add(new Employee(5, "Shiv", 32, 32000));

        // Example using Java Streams
        double averageSalary = employees.stream()
                .filter(e -> e.getAge() > 25)
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        System.out.println("Average salary of employees above 25 years: " + averageSalary);

        // Example using Parallel Streams
        double totalSalary = employees.parallelStream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Total salary of all employees: " + totalSalary);
    }
}
