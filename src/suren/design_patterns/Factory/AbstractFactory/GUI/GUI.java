package suren.design_patterns.Factory.AbstractFactory.GUI;

public class GUI {
    IGUIFactory instance;
    String appearance;

    public GUI(IGUIFactory instance) {
        this.instance = instance;
    }

    public GUI(String appearance) {
        this.appearance = appearance;
    }

    private IGUIFactory getInstanceIfNotCreated() {
        if (this.instance != null) {
            return this.instance;
        }

        if (this.appearance.equals("OSX")) {
            this.instance = new OSXFactory();
        } else if (this.appearance.equals("Windows")) {
            this.instance = new WinFactory();
        }
        return this.instance;
    }

    public void createUI() {
        IGUIFactory factory = getInstanceIfNotCreated();
        final IButton button = factory.createButton();
        button.paint();
    }

}
