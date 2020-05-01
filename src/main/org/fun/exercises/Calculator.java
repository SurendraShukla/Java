package org.fun.exercises;

import java.util.function.BinaryOperator;

public class Calculator {

    private int op1;
    private int op2;

    public Calculator(int op1, int op2) {
        this.op1 = op1;
        this.op2 = op2;
    }

//    int calculate(Operation op) {
//        return op.operate(this.op1, this.op2);
//    }

    int calculate(BinaryOperator<Integer> op) {
        return op.apply(this.op1, this.op2);
    }

    public static void main(String[] args) {

//        Operation add = (x,y) -> x+y;

        Calculator cal = new Calculator(20, 10);
//        Operation add = new Addition();
//        System.out.println(cal.calculate(add));
        System.out.println(cal.calculate((x, y) -> x + y));
        System.out.println(cal.calculate((x, y) -> x - y));
        System.out.println(cal.calculate((x, y) -> x * y));
        System.out.println(cal.calculate((x, y) -> x / y));
    }
}
