package me.surendra.design_patterns.Factory.AbstractFactory.ComputerShop;

public class AverageBudgetMachine extends LowBudgetMachine {
    @Override
    public IProcessor getRam() {
        return new ExpensiveProcessor();
    }
}
