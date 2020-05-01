package me.surendra.design_patterns.Builder.Car;

public interface CarBuilder {
    Car build();

    CarBuilder setColor(final String color);

    CarBuilder setWheels(final int wheels);
}
