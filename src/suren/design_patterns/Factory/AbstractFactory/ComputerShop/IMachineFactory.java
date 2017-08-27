package suren.design_patterns.Factory.AbstractFactory.ComputerShop;

public interface IMachineFactory {
    IProcessor getRam();
    IHardDisk getHardDisk();
    IMonitor getMonitor();
}
