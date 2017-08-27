package suren.design_patterns.Factory.AbstractFactory.ComputerShop;

public class ComputerShopTest {
    public static void main(String[] args) {
//        IMachineFactory factory = new HighBudgetMachine();
//        IMachineFactory factory = new LowBudgetMachine();
        IMachineFactory factory = new AverageBudgetMachine();
        ComputerShop shop = new ComputerShop(factory);
        shop.AssembleMachine();
    }
}
