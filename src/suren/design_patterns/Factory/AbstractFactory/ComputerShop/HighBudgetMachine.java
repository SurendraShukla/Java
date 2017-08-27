package suren.design_patterns.Factory.AbstractFactory.ComputerShop;

public class HighBudgetMachine implements IMachineFactory{
    @Override
    public IProcessor getRam() {
        return new ExpensiveProcessor();
    }

    @Override
    public IHardDisk getHardDisk() {
        return new ExpensiveHDD();
    }

    @Override
    public IMonitor getMonitor() {
        return new HighResolutionMonitor();
    }
}
