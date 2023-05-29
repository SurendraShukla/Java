package me.surendra.design_patterns.Factory.AbstractFactory.ComputerShop;

public class ComputerShop {

    IMachineFactory category;

    public ComputerShop(IMachineFactory category)
    {
        this.category = category;
    }

    public void AssembleMachine()
    {
        IProcessor processor = category.getRam();
        IHardDisk hdd = category.getHardDisk();
        IMonitor monitor = category.getMonitor();
        //use all three and create machine

        processor.performOperation();
        hdd.storeData();
        monitor.displayPicture();
    }

}
