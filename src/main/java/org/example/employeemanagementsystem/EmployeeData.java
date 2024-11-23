package org.example.employeemanagementsystem;

public class EmployeeData {
    private String name;
    private String type;
    private double salary;

    public EmployeeData(String name, String type, double salary) {
        this.name = name;
        this.type = type;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getSalary() {
        return salary;
    }
}

