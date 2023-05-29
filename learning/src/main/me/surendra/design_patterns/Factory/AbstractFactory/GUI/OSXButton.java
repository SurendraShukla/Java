package me.surendra.design_patterns.Factory.AbstractFactory.GUI;

public class OSXButton implements IButton {
    @Override
    public void paint() {
        System.out.println("OSXButton");
    }
}
