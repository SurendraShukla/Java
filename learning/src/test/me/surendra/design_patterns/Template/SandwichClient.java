package me.surendra.design_patterns.Template;

import me.surendra.design_patterns.Template.Sandwich.CheeseSandwich;
import me.surendra.design_patterns.Template.Sandwich.Sandwich;

public class SandwichClient {

    public static void main(String[] args) {
//       Sandwich sandwichForCustomer1 = new VegClubSandwich();
//       sandwichForCustomer1.makeSandwich();

       System.out.println("\n");

       Sandwich sandwichForCustomer2 = new CheeseSandwich();
       sandwichForCustomer2.makeSandwich();
    }

}
