package suren.design_patterns.Strategy.Calculator;

import suren.design_patterns.Strategy.Calculator.behaviour.*;

public class Calculator {

    private int val1;
    private int val2;

    public Calculator(int val1, int val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public int operate(Operator operator) {
        return operator.execute(this.val1, this.val2);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator(20, 10);

        System.out.println(calculator.operate(new SumOperator()));
        System.out.println(calculator.operate(new RestOperator()));
        System.out.println(calculator.operate(new DivideOperator()));
        System.out.println(calculator.operate(new MultiplyOperator()));
    }

}

