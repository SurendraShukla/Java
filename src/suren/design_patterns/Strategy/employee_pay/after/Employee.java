package suren.design_patterns.Strategy.employee_pay.after;

import suren.design_patterns.Strategy.employee_pay.after.behaviour.InternPayAlgorithm;
import suren.design_patterns.Strategy.employee_pay.after.behaviour.PayAlgorithm;
import suren.design_patterns.Strategy.employee_pay.after.behaviour.WebDeveloperPayAlgorithm;
import suren.design_patterns.Strategy.employee_pay.before.EmployeeType;

public class Employee {
    private String name;
    private EmployeeType employeeType;
    private double basicSalary;
    private PayAlgorithm payAlgorithm;

    public Employee(String name, EmployeeType employeeType, double basicSalary) {
        this.name = name;
        this.employeeType = employeeType;
        this.basicSalary = basicSalary;
    }

    public String getName() {
        return name;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setPayAlgorithm(PayAlgorithm payAlgorithm) {
        this.payAlgorithm = payAlgorithm;
    }

    public double getPay() {
        return payAlgorithm.getPay(this.basicSalary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "basicSalary=" + basicSalary +
                ", name='" + name + '\'' +
                ", employeeType=" + employeeType +
                '}';
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Surendra", EmployeeType.INTERN, 10000);
        employee.setPayAlgorithm(new InternPayAlgorithm());
        System.out.println(employee.getPay());

        employee.setPayAlgorithm(new WebDeveloperPayAlgorithm());
        System.out.println(employee.getPay());
    }
}
