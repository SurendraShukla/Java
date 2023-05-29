package me.surendra.design_patterns.ChainOfReponsibility.money_dispenser;

public class Currency {
    private int amount;

    public Currency(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
