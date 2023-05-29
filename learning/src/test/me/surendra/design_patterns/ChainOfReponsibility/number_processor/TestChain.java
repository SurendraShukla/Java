package me.surendra.design_patterns.ChainOfReponsibility.number_processor;

import org.junit.Test;

public class TestChain {

    @Test
    public void shouldTest() {
        //configure Chain of Responsibility
        Chain c1 = new NegativeProcessor();
        Chain c2 = new ZeroProcessor();
        Chain c3 = new PositiveProcessor();
        c1.setNextChain(c2);
        c2.setNextChain(c3);

        //calling chain of responsibility
        c1.process(new Number(90));
        c1.process(new Number(-50));
        c1.process(new Number(0));
        c1.process(new Number(91));
    }

}
