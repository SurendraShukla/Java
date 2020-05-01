package me.surendra.design_patterns.Factory.AbstractFactory.ComputerShop;

public class CheapHDD implements IHardDisk {
    @Override
    public void storeData() {
        System.out.println("Data will take more time to store");
    }
}
