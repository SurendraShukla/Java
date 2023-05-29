package me.surendra.learning.functional_interface;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MostUsedFunctionalInterfaceTest {

    final MostUsedFunctionalInterface mostUsedFunctionalInterface = new MostUsedFunctionalInterface();

    @Test
    public void testConsumer() {
        Consumer<String> stringConsumer = (a) -> System.out.println(a);
        mostUsedFunctionalInterface.consumer(stringConsumer);
    }

    @Test
    public void testSupplier() {
        Supplier<String> stringSupplier = () -> "Supplier : " + RandomStringUtils.random(10);
        mostUsedFunctionalInterface.supplier(stringSupplier);
    }

    @Test
    public void testPredicate() {
        Predicate<String> stringPredicate1 = (a) -> a.equals("a");
        Predicate<String> stringPredicate2 = (a) -> a.equals("b");
        Predicate<String> orPredicate = stringPredicate1.or(stringPredicate2);
        mostUsedFunctionalInterface.predicate(orPredicate);

        Predicate<String> negatePredicate = stringPredicate1.negate();
        mostUsedFunctionalInterface.predicate(negatePredicate);
        System.out.println(stringPredicate1.test("10"));
    }

    @Test
    public void testFunction() {
        Function<Integer, Integer> squareFunction = (a) -> a*a;
        System.out.println(mostUsedFunctionalInterface.function(squareFunction));
    }

    @Test
    public void testBiFunction() {
        BiFunction<Integer, Float, Float> divisionFun = (a, b) -> a / b;
        System.out.println(mostUsedFunctionalInterface.biFunction(divisionFun));
    }
}
