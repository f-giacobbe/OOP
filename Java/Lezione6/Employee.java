package Lezione6;

import java.time.LocalDate;

public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDate;


    public Employee(String name, double salary, int y, int m, int d) {
        this.name = name;
        this.salary = salary;
        this.hireDate = LocalDate.of(y, m, d);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }


    public void raiseSalary(double percentage) {
        double r = salary * percentage / 100;
        salary += r;
    }
}
