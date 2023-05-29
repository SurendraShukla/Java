package me.surendra.learning.generics;

import java.util.List;

/**
 * <pre>
 *     Generics provides Type Safety at compile.
 *     Type information is removed at run time.
 *
 *     <i>javap</i> - Java Disassembler to get the information of any class or interface.
 *     <code>javap class_name</code>
 * </pre>
 *
 * <a href="https://stackoverflow.com/a/13409697">Example Link</a>
 */
public class TypeErasure {

    /**
     * @param numbers
     * @return
     * <pre>
     *     Arrays are reifiable types.
     *     Caller can pass any of its subtype.
     * </pre>
     */
    public static long arraysAreReifiableTypes(final Number[] numbers) {
        long summation = 0;
        for(Number number : numbers) {
            summation += number.longValue();
        }
        return summation;
    }

    /**
     * @param array
     * @return void
     * @throws ArrayStoreException
     *
     * <pre>
     *     Type information is preserved at runtime for array.
     *
     *     Adding double value to an array is possible.
     *     However its intended behaviour for caller if it calls method with integer array.
     *
     *     Compiler won't be able to catch it.
     *     Runtime type system will be able to catch it and will throw ArrayStoreException.
     *
     *     Runtime Java knows that this array was actually instantiated as an array of integers which simply happens to be accessed through a reference of type Number[].
     * </pre>
     */
    public static void arraysTypeSafetyIssue(final Number[] array) {
        // Attempt of heap pollution.
        // Below line will compile however it will give ArrayStoreException at runtime.
        array[0] = 3.14;
    }


    /**
     * @param numbers
     * @return
     * <pre>
     *     Generic are non reifiable types.
     *     Caller can't pass any of its subtype.
     *
     *     To resolve this issue, use wildcard.
     * </pre>
     */
    public static long genericsAreReifiableTypes(final List<Number> numbers) {
        long summation = 0;
        for(Number number : numbers) {
            summation += number.longValue();
        }
        return summation;
    }


    /**
     * <pre>
     *     Type information is discarded by the compiler and it is not available at run time.
     *
     *     As type information is discarded/removed at runtime.
     *     Java compiler make sure that incorrect types does not get added to generics so that no issue happens at runtime.
     *     As it happens with Array.
     * </pre>
     */
    public static void genericsTypeSafety(final List<? extends Number> generics) {
        // Attempt of heap pollution
        // Below line won't compile
//        generics.add(3.14);
    }

    public static long genericsTypeAreNonReifiable(final Number[] numbers) {
        long summation = 0;
        for(Number number : numbers) {
            summation += number.longValue();
        }
        return summation;

    }

}
