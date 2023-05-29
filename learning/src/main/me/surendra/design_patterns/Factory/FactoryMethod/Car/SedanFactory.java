package me.surendra.design_patterns.Factory.FactoryMethod.Car;

public class SedanFactory implements CarFactory {
    @Override
    public Car makeCar() {
        return new Sedan();
    }
}
