package me.surendra.design_patterns.Factory.FactoryMethod.Car;

public class CarFactoryTest {
    public static void main(String[] args) {
//        CarFactory factory = new SedanFactory();
        CarFactory factory = new HatchbackFactory();
        Car car = factory.makeCar();
        System.out.println(car.getType());
    }
}
