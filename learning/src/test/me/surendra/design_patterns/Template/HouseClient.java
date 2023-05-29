package me.surendra.design_patterns.Template;

import me.surendra.design_patterns.Template.House.GlassHouse;
import me.surendra.design_patterns.Template.House.HouseTemplate;
import me.surendra.design_patterns.Template.House.WoodenHouse;

public class HouseClient {

    public static void main(String[] args) {

        HouseTemplate houseType = new WoodenHouse();

        //using template method
        houseType.buildHouse();
        System.out.println("************");

        houseType = new GlassHouse();

        houseType.buildHouse();
    }

}
