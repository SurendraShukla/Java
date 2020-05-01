package me.surendra.design_patterns.Composite.computer;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component  {

    private String name;
    List<Component> components = new ArrayList<>();

    public Composite(final String name) {
        super();
        this.name = name;
    }

    public void addComponent(Component com) {
        components.add(com);
    }


    public void removeComponent(Component com) {
        components.remove(com);
    }

    @Override
    public void showPrice() {
        System.out.println(name);
        for(Component c: components) {
            c.showPrice();
        }
    }
}
