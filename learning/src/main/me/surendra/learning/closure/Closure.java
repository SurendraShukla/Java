package me.surendra.learning.closure;


import java.util.function.Function;

public class Closure {

    public Function<Integer, Integer> method() {
        final int a = 10;
        final Function<Integer, Integer> lambdaMethod = (b) -> {
            return a + b;
        };
        return lambdaMethod;
    }

}
