package suren.design_patterns.Facade;


import suren.design_patterns.Facade.Computer.ComputerFacade;

public class FacadeTest {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
    }
}
