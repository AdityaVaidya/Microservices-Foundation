package advance;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeExample {

    public static void main(String[] args) {
        // Creating an employee with initial values
        Employee employee = new Employee("Rushi Shinde", LocalDateTime.of(2022, 1, 1, 9, 0), ZonedDateTime.now());

        // Printing employee details
        System.out.println("Name: " + employee.getName());
        System.out.println("Hire Date and Time: " + employee.getHireDateTime());
        System.out.println("Current Date and Time: " + employee.getCurrentDateTime());

        // Updating employee details
        employee.setName("Aditya Vaidya");
        employee.setHireDateTime(LocalDateTime.of(2021, 5, 10, 14, 30));
        employee.setCurrentDateTime(ZonedDateTime.now(ZoneId.of("America/New_York")));

        // Printing updated employee details
        System.out.println("\nUpdated Details:");
        System.out.println("Name: " + employee.getName());
        System.out.println("Hire Date and Time: " + employee.getHireDateTime());
        System.out.println("Current Date and Time: " + employee.getCurrentDateTime());
    }
}
