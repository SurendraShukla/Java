package suren.design_patterns.Factory.AbstractFactory.ComputerShop;

public class LowBudgetMachine implements IMachineFactory{
    @Override
    public IProcessor getRam() {
        return new CheapProcessor();
    }

    @Override
    public IHardDisk getHardDisk() {
        return new CheapHDD();
    }

    @Override
    public IMonitor getMonitor() {
        return new LowResolutionMonitor();
    }
}
