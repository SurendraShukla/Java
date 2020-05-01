package me.surendra.design_patterns.Factory.FactoryMethod.Computer;

public class PCFactory extends  ComputerFactory {

    @Override
    Computer getComputer(String type, String ram, String hdd, String cpu) {
        return new PC(ram, hdd, cpu);
    }

}
