package advance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.Iterator;
import java.util.Spliterator;

public class CollectionAPIExample {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Adi", 26, 30000));
        employees.add(new Employee(2, "John", 34, 45000));
        employees.add(new Employee(3, "Rushi", 21, 40000));
        employees.add(new Employee(4, "Nexus", 28, 35000));
        employees.add(new Employee(5, "Shiv", 32, 32000));

        // forEach - iterate over each element using a consumer
        System.out.println("Iterating over employees using forEach:");
        employees.forEach(employee -> System.out.println(employee));

        // forEachRemaining - iterate over remaining elements of an iterator using a
        // consumer
        Iterator<Employee> iterator = employees.iterator();
        System.out.println("\nIterating over remaining employees using forEachRemaining:");
        iterator.next(); // Skip the first element
        iterator.forEachRemaining(employee -> System.out.println(employee));

        // removeIf - remove elements based on a condition
        Predicate<Employee> salaryPredicate = employee -> employee.getSalary() < 6000;
        employees.removeIf(salaryPredicate);
        System.out.println("\nEmployees after removing those with salary < 6000:");
        employees.forEach(employee -> System.out.println(employee));

        // spliterator - split a collection into multiple parts for parallel processing
        Spliterator<Employee> spliterator = employees.spliterator();
        Spliterator<Employee> secondHalf = spliterator.trySplit();
        System.out.println("\nSecond half of employees:");
        secondHalf.forEachRemaining(employee -> System.out.println(employee));

        // replaceAll - replace all elements with the result of applying a unary
        // operator
        UnaryOperator<Employee> salaryIncrease = employee -> {
            employee.setSalary(employee.getSalary() + 1000);
            return employee;
        };
        employees.replaceAll(salaryIncrease);
        System.out.println("\nEmployees after salary increase of 1000:");
        employees.forEach(employee -> System.out.println(employee));

        // compute - compute a new value for a given key
        Map<Integer, Employee> employeeMap = new HashMap<>();
        employees.forEach(employee -> employeeMap.put(employee.getId(), employee));
        employeeMap.compute(1, (key, value) -> {
            value.setSalary(value.getSalary() + 2000);
            return value;
        });
        System.out.println("\nEmployee with ID 1 after salary increase of 2000:");
        System.out.println(employeeMap.get(1));

        // merge - merge two values for a given key
        BiFunction<Employee, Employee, Employee> salaryMerger = (oldValue, newValue) -> {
            oldValue.setSalary(oldValue.getSalary() + newValue.getSalary());
            return oldValue;
        };
        Employee newEmployee = new Employee(5, "Appu", 32, 32000);
        employeeMap.merge(newEmployee.getId(), newEmployee, salaryMerger);
        System.out.println("\nEmployees after merging new employee with ID 4:");
        employeeMap.forEach((key, value) -> System.out.println(value));
    }
}
