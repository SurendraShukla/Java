package me.surendra.learning.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://stackoverflow.com/a/13409697">Example Link</a>
 */
public class Variance {

    /**
     * <pre>
     *     CO_VARIANT:
     *     - Use when intend to take generic values out of a structure.
     *     - Read/fetch items from a generic structure, but cannot write anything into it.
     *     - Java cannot guarantee what is the actual type of the object in the generic structure at runtime.
     *     - Allowing write; you can put anything (E and Base of E) in this. Runtime handling will be difficult.
     * </pre>
     */
    public static void coVariant(final List<? extends Number> producer) {
        // Read is allowed, below code will work
        System.out.println(producer.get(0));

        // Write is not allowed, below code won't compile
        /*
        producer.add(10);
        producer.add(45.10);
        producer.add(45L);
        */
    }

    /**
     * <pre>
     *     CONTRA_VARIANT:
     *     - Use when intend to put generic values into a structure.
     *     - Put/write items into a generic structure, but cannot read out from it.
     *     - Java cannot be sure what kind of object you are going to get it.
     *     - Allowing read; you cannot safely read anything from this contravariant structure assuming that you will get a number.
     * </pre>
     */
    public static void contraVariant(final List<? super Number> consumer) {

        // Write is allowed, below code will work
        consumer.add(10);
        consumer.add(3.14);

        // Read is not allowed, below code won't compile
        // Compiler allowed you to write this line, you would get a ClassCastException at runtime.
        /*
        consumer.get(0);
         */
    }

    /**
     * <pre>
     *     IN_VARIANT:
     *     - Both read/write operation needed use the exact generic type.
     * </pre>
     */
    public static <T> void inVariance(List<T> source) {
        source.get(0);
//        source.add("10");
    }

    /**
     * <pre>
     *     INDEPENDENT_OF_T:
     *     - Both read/write operation are not needed use the ?.
     * </pre>
     */
    public static void independentOfT(final List<?> source) {
        source.get(0);
//        source.add("10");
    }

}
