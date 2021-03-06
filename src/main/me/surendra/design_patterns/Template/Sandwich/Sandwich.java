package me.surendra.design_patterns.Template.Sandwich;

public abstract class Sandwich {

    final public void makeSandwich() {
        cutBreadLoaf();

        addSauce();

        if(customerWantsVegetables()) {
            addVeggie();
        }

        if (customerWantsCheese()) {
            addCheese();
        }

        wrapSandwich();
    }

    public void cutBreadLoaf() {
        System.out.println("Cut bread loaf ");
    }

    abstract void addVeggie() ;

    abstract void addCheese() ;

    abstract void addSauce() ;

    public void wrapSandwich() {
        System.out.println("Wrap the Sandwich");
    }

    boolean customerWantsCheese() { return true; }
    boolean customerWantsVegetables() { return true; }

}
