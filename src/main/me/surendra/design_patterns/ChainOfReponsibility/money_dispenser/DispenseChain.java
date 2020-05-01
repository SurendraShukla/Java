package me.surendra.design_patterns.ChainOfReponsibility.money_dispenser;

public abstract class DispenseChain {

    private DispenseChain dispenseChain;

    public void setNextChain(final DispenseChain dispenseChain) {
        this.dispenseChain = dispenseChain;
    }

    abstract int getDispenseAmount();

    public void dispense(final Currency cur) {
        int amount = cur.getAmount();
        if (amount >= getDispenseAmount()) {
            int num = amount / getDispenseAmount();
            int remainder = amount % getDispenseAmount();
            System.out.println("Dispensing " + num + " "+getDispenseAmount()+"$ note");
            if (remainder != 0) this.dispenseChain.dispense(new Currency(remainder));
        } else {
            this.dispenseChain.dispense(cur);
        }
    }
}
