package me.surendra.design_patterns.Template.Sandwich;

public class VegClubSandwich extends Sandwich {

    void addVeggie() {
        System.out.println("Add veggies");
    }

    void addCheese() {
      System.out.println("Add Cheese");
    }

    void addSauce() {
      System.out.println("Add Sauce");
    }

}
