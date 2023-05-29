package me.surendra.design_patterns.ChainOfReponsibility.money_dispenser;

public class Dollar50Dispenser extends DispenseChain {
    @Override
    int getDispenseAmount() {
        return 50;
    }
}
