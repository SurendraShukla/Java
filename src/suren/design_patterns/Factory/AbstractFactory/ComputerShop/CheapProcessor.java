package suren.design_patterns.Factory.AbstractFactory.ComputerShop;

public class CheapProcessor implements IProcessor{
    @Override
    public void performOperation() {
        System.out.println("Operation will perform Slowly");
    }
}
