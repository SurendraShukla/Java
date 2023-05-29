package me.surendra.design_patterns.ChainOfReponsibility.money_dispenser;

public class Dollar10Dispenser extends DispenseChain {
    @Override
    public int getDispenseAmount() {
        return 10;
    }
}

