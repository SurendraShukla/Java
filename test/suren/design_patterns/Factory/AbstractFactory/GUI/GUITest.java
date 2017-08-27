package suren.design_patterns.Factory.AbstractFactory.GUI;

public class GUITest {

    public static void main(String[] args) {
//        GUI guiInstance = new GUI("OSX");
        GUI guiInstance = new GUI("Windows");
        guiInstance.createUI();

        OSXFactory osxInstance = new OSXFactory();
        GUI guiInstance1 = new GUI(osxInstance);
        guiInstance1.createUI();

//        OSXFactory osxInstance =new OSXFactory();
//        final IButton button = osxInstance.createButton();
//        button.paint();
    }

}
