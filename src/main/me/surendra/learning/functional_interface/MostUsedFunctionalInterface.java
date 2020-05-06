package me.surendra.learning.functional_interface;

import org.apache.commons.lang.RandomStringUtils;

import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class MostUsedFunctionalInterface {

    boolean predicate(final Predicate<String> predicate) {
        return predicate.test("a");
    }

    void consumer(final Consumer<String> consumer) {
        consumer.accept("Consumer : " + RandomStringUtils.random(10));
    }

    void supplier(final Supplier<String> supplier) {
        System.out.println(supplier.get());
    }

    Integer function(final Function<Integer, Integer> function) {
        return function.apply(new Random().nextInt(100));
    }


    Float biFunction(final BiFunction<Integer, Float, Float> function) {
        return function.apply(new Random().nextInt(100), new Random().nextFloat());
    }

    public static void main(String[] args) {
        final SupplierAndConsumer<Integer> somethingLambda = (a, b) -> a + b;
        somethingLambda.consumeAndThenSupply(10, 20);
    }

}
