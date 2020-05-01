package me.surendra.design_patterns.Factory.FactoryMethod.Computer;

public class ServerFactory extends ComputerFactory {
    @Override
    Computer getComputer(String type, String ram, String hdd, String cpu) {
        return new Server(ram, hdd, cpu);
    }
}
