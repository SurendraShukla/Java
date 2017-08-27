package suren.design_patterns.Factory.AbstractFactory.ComputerShop;

public class ExpensiveHDD implements IHardDisk{
    @Override
    public void storeData() {
        System.out.println("Data will take less time to store");
    }
}
