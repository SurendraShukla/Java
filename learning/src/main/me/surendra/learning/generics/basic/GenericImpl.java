package me.surendra.learning.generics.basic;

public class GenericImpl {

    public <T> void accept(final GenericI<T> generic) {
        generic.shouldHave();
        generic.shouldHaveThisAlso(10);
    }

}
