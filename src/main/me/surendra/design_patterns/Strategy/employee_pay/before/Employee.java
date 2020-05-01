package me.surendra.design_patterns.Strategy.employee_pay.before;

public class Employee {
    private String name;
    private EmployeeType employeeType;
    private double basicSalary;

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

    public double getPay() {
        double pay = 0.0;

        if(employeeType.equals(EmployeeType.INTERN)) {
            pay = basicSalary + (basicSalary * 0.10);
        } else if (employeeType.equals(EmployeeType.TRAINEE)) {
            pay = basicSalary + (basicSalary * 0.12);
        } else if (employeeType.equals(EmployeeType.WEB_DESIGNER)) {
            pay = basicSalary + (basicSalary * 0.15);
        } else if (employeeType.equals(EmployeeType.WEB_DEVELOPER)) {
            pay = basicSalary + (basicSalary * 0.20);
        }
        return pay;
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Surendra", EmployeeType.INTERN, 10000);
        System.out.println(employee.getPay());
    }
}
