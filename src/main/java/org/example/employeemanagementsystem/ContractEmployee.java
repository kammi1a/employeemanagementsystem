package org.example.employeemanagementsystem;

public class ContractEmployee extends Employee {
    private double hourlyRate;
    private int maxHours;

    public ContractEmployee(String name, double hourlyRate, int maxHours) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.maxHours = maxHours;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * maxHours;
    }
}
