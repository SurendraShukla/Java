package me.surendra.design_patterns.Factory.AbstractFactory.ComputerShop;

public class LowResolutionMonitor implements IMonitor {
    @Override
    public void displayPicture() {
        System.out.println("Picture quality is Average");
    }
}
