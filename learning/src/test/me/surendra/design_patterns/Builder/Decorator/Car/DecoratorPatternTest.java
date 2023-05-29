package me.surendra.design_patterns.Builder.Decorator.Car;

import me.surendra.design_patterns.Decorator.Car.BasicCar;
import me.surendra.design_patterns.Decorator.Car.Car;
import me.surendra.design_patterns.Decorator.Car.LuxuryCar;
import me.surendra.design_patterns.Decorator.Car.SportsCar;

public class DecoratorPatternTest {
    public static void main(String[] args) {
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();
        System.out.println("\n*****");

        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assemble();
    }
}
