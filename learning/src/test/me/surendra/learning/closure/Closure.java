package me.surendra.learning.closure;


import java.util.function.Function;

public class Closure {
    public Function<Integer, Integer> someMethod() {
        final int a = 10;
        final Function<Integer, Integer> lambdaMethod = (b) -> {
            return a + b;
        };
        return lambdaMethod;
    }

    public static void main(final String[] args) {
        // Add breakpoint at 8, 10, 12 to see execution

        /**
         * SomeMethod will be executed and lambda won't be executed
         * Debugger will stop at 8 and 12 but won't stop on 10
         */
        final Function<Integer, Integer> closure = new Closure().someMethod();
        /**
         * Lambda will be executed and SomeMethod won't be executed
         * Debugger won't stop at 8 and 12 but will stop on 10
         */
        closure.apply(20);
        /**
         * Lambda will be executed and SomeMethod won't be executed
         * Debugger won't stop at 8 and 12 but will stop on 10
         */
        closure.apply(30);
    }

}
