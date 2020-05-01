package me.surendra.design_patterns.ChainOfReponsibility.number_processor;

public interface Chain {
    void setNextChain(Chain chain);
    void process(Number request);
}
