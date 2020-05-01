package me.surendra.design_patterns.Composite.computer;

import org.junit.Test;

public class Client {

    @Test
    public void test() {
        Component mouse = new Leaf(100, "Mouse");
        Component keyboard = new Leaf(200, "Keyboard");
        Component hd = new Leaf(100, "hdd");
        Component ram = new Leaf(400, "ram");
        Component cpu = new Leaf(500, "cpu");

        Composite ph = new Composite("Peripherals");
        Composite cabinet = new Composite("Cabinet");
        Composite mb = new Composite("mb");
        Composite computer = new Composite("Computer");


        ph.addComponent(mouse);
        ph.addComponent(keyboard);

        mb.addComponent(ram);
        mb.addComponent(cpu);

        cabinet.addComponent(hd);

        computer.addComponent(ph);
        computer.addComponent(cabinet);

        computer.showPrice();

//        mouse.showPrice();
    }

}
