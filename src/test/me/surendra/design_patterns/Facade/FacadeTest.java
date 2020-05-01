package me.surendra.design_patterns.Facade;


import me.surendra.design_patterns.Facade.Computer.ComputerFacade;

public class FacadeTest {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
    }
}
