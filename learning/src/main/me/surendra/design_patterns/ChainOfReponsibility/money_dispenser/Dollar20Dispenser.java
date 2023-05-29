package me.surendra.design_patterns.ChainOfReponsibility.money_dispenser;

public class Dollar20Dispenser extends DispenseChain {
    @Override
    int getDispenseAmount() {
        return 20;
    }
}
