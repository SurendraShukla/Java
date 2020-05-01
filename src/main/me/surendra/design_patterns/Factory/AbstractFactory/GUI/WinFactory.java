package me.surendra.design_patterns.Factory.AbstractFactory.GUI;

public class WinFactory implements IGUIFactory {
    @Override
    public IButton createButton() {
        return new WinButton();
    }
}
