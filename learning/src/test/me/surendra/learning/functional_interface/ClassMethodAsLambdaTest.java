package me.surendra.learning.functional_interface;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ClassMethodAsLambdaTest {

    @Test
    public void test() {

        final ClassMethodAsLambda classMethodAsLambda = new ClassMethodAsLambda();
        final Function<Integer, Integer> squareFun = classMethodAsLambda::square;
        final BiFunction<Integer, Integer, Integer> sumFun = classMethodAsLambda::sum;

        System.out.println(classMethodAsLambda.square(10) + "\t" +  classMethodAsLambda.getClass().getName());
        System.out.println(squareFun.apply(10) + "\t" + squareFun.getClass().getName());
        System.out.println(sumFun.apply(10, 20) + "\t" + sumFun.getClass().getName());

    }

}
