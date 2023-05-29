package me.surendra.design_patterns.Decorator.Car;

public class BasicCar implements Car{
    @Override
    public void assemble() {
        System.out.print("Basic Car.");
    }
}
