package me.surendra.learning.functional_interface;

import org.apache.commons.lang.RandomStringUtils;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionProgram {

    /*
    Predicate represents an anonymous function that accepts one argument and produces a result.
    Supplier represents an anonymous function that accepts no argument and produces a result.
    Consumer represents an anonymous function that accepts an argument and produces no result.
     */

    public void genericMethod(Class<?> clazz) {
        System.out.println(clazz);
    }

    public <T> void handleObjects(final T obj) {
        System.out.println(obj);
    }


    public <T> void handleFunctions(final Function function) {
        function.apply("Fun");
    }

//    public <T> void handleFunctions(final Function<T, T> function) {
//        function.apply(T);
//    }

    public <T> T handleFunctions(final Supplier<T> supplier){
        return supplier.get();
    }

//
//    public <T> T handleFunctions(final Consumer<T> consumer){
//        return consumer.accept();
//    }
//
}
