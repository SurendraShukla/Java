package me.surendra.design_patterns.Factory.FactoryMethod.Car;

public class HatchbackFactory implements CarFactory{
    @Override
    public Car makeCar() {
        return new Hatchback();
    }
}
