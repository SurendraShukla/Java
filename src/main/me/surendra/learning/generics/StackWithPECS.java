package me.surendra.learning.generics;

import java.util.Collection;
import java.util.List;
import java.util.Stack;

/**
 * <H1>PECS (Producer Extends, Consumer Super)</H1>
 */
public class StackWithPECS {

    private Stack<Number> numberStack = new Stack<>();

    /**
     * @param source List of T (Generic/Any) Class
     * @return void
     *
     * <pre>
     *     - Producer Extends
     *     - Use producer to FETCH
     *     - Defines upper bound
     *
     *     CO_VARIANT:
     *     - Use when intend to take generic values out of a structure.
     *     - Read/fetch items from a generic structure, but cannot write anything into it.
     *     - Java cannot guarantee what is the actual type of the object in the generic structure at runtime.
     *     - Allowing write; you can put anything (E and Base of E) in this. Runtime handling will be difficult.
     * </pre>
     */
    <E> void pushAll(Collection<? extends E> source) {
        for (final E ele : source) {
            numberStack.push((Number) ele);
        }
    }

    /**
     * @param target List of T (Generic/Any) Class
     * @return void
     *
     * <pre>
     *     - Consumer Super
     *     - Use consumer to INSERT
     *     - Defines lower bound
     *
     *     CONTRA_VARIANT:
     *     - Use when intend to put generic values into a structure.
     *     - Put/write items into a generic structure, but cannot read out from it.
     *     - Java cannot be sure what kind of object you are going to get it.
     *     - Allowing read; you cannot safely read anything from this contravariant structure assuming that you will get a number.
     * </pre>
     */
    <E> void popAll(Collection<? super E> target) {
        for (final Number ele : numberStack) {
            target.add((E) ele);
        }
    }

    /**
     * @param source List of T (Generic/Any) Class
     * @param target List of T (Generic/Any) Class
     * @return void
     *
     * <pre>
     *     Uses both producer and consumer.
     * </pre>
     */
    public static void copy(List<? extends Number> source, List<? super Number> target) {
        for(Number number : source) {
            target.add(number);
        }
    }

}
