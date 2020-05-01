package me.surendra.design_patterns.ChainOfReponsibility.money_dispenser;

import org.junit.Test;

public class ATMDispenseChainTest {

    @Test
    public void test() {
        // https://www.journaldev.com/1617/chain-of-responsibility-design-pattern-in-java
        ATMDispenseChain atmDispenser = new ATMDispenseChain();

        // process the request
        atmDispenser.dispense(new Currency(110));
    }

}
