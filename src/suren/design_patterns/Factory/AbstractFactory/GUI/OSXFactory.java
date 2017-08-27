package suren.design_patterns.Factory.AbstractFactory.GUI;

public class OSXFactory implements IGUIFactory {
    @Override
    public IButton createButton() {
        return new OSXButton();
    }
}
