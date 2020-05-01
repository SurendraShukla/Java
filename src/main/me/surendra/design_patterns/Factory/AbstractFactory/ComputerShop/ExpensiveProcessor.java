package me.surendra.design_patterns.Factory.AbstractFactory.ComputerShop;

public class ExpensiveProcessor implements IProcessor {
    @Override
    public void performOperation() {
        System.out.println("Operation will perform quickly");
    }
}
