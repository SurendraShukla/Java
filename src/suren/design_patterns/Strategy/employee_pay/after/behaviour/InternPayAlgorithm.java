package suren.design_patterns.Strategy.employee_pay.after.behaviour;

public class InternPayAlgorithm implements PayAlgorithm {
    @Override
    public double getPay(double basicSalary) {
        return basicSalary + (basicSalary * 0.10);
    }
}
