package me.surendra.design_patterns.ChainOfReponsibility.money_dispenser;

public class ATMDispenseChain {

    private DispenseChain c1;

    public ATMDispenseChain() {
        // initialize the chain
        this.c1 = new Dollar50Dispenser();
        DispenseChain c2 = new Dollar20Dispenser();
        DispenseChain c3 = new Dollar10Dispenser();

        // set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }

    public void dispense(final Currency currency) {
        int amount = 100;
        if (amount % 10 != 0) {
            System.out.println("Amount should be in multiple of 10s.");
            return;
        }

        c1.dispense(currency);
    }
}
