package me.surendra.design_patterns.ChainOfReponsibility.number_processor;

public class NegativeProcessor implements Chain {
    private Chain chain;

    @Override
    public void setNextChain(final Chain chain) {
        this.chain = chain;
    }

    @Override
    public void process(final Number request) {
        if (request.getNumber() < 0) {
            System.out.println("NegativeProcessor : " + request.getNumber());
        } else {
            chain.process(request);
        }
    }
}
