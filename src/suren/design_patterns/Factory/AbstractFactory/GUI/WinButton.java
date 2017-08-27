package suren.design_patterns.Factory.AbstractFactory.GUI;

public class WinButton implements IButton {
    @Override
    public void paint() {
        System.out.println("WinButton");
    }
}
