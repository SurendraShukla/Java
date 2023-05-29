package me.surendra.design_patterns.Factory.FactoryMethod.Computer;

abstract class ComputerFactory {
    abstract Computer getComputer(String type, String ram, String hdd, String cpu);
}
