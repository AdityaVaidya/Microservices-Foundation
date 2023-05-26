package advance;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;
    private List<String> skills;
    private LocalDateTime hireDateTime;
    private ZonedDateTime currentDateTime;

    public Employee(int id, String name, int age, double salary, List<String> skills) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.skills = skills;
    }

    public Employee(String name, LocalDateTime hireDateTime, ZonedDateTime currentDateTime) {
        this.name = name;
        this.hireDateTime = hireDateTime;
        this.currentDateTime = currentDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public LocalDateTime getHireDateTime() {
        return hireDateTime;
    }

    public void setHireDateTime(LocalDateTime hireDateTime) {
        this.hireDateTime = hireDateTime;
    }

    public ZonedDateTime getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(ZonedDateTime currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", skills=" + skills
                + "]";
    }
}
