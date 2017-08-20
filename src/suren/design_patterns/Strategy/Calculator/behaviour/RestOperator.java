package suren.design_patterns.Strategy.Calculator.behaviour;

public class RestOperator implements Operator{

    @Override
    public int execute(int val1, int val2) {
        return val1 - val2;
    }
}
