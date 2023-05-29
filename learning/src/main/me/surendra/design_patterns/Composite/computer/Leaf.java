package me.surendra.design_patterns.Composite.computer;

public class Leaf implements Component{

    private int price;
    private String name;

    public Leaf(final int price, final String name) {
        super();
        this.price = price;
        this.name = name;
    }

    @Override
    public void showPrice() {
        System.out.println(name + " : " + price);
    }
}
