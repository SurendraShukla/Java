package me.surendra.design_patterns.Strategy.employee_pay.after.behaviour;

public class WebDesignerPayAlgorithm implements PayAlgorithm {
    @Override
    public double getPay(double basicSalary) {
        return basicSalary + (basicSalary * 0.15);
    }
}
