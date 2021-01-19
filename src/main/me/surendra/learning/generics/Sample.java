package me.surendra.learning.generics;

import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

class T { }
class Fruit { }
class Banana extends Fruit { }
class Orange extends Fruit { }


public class Sample {

    /**
     * @param fruit Raw/Regular Fruit Class
     * @return void
     */
    public static void useFruit(Fruit fruit) {
        System.out.println("useFruit: " + fruit.toString());
    }

    /**
     * @param fruits List of Raw/Regular Fruit Class
     * @return void
     */
    public static void useFruitBasket(List<Fruit> fruits) {
        System.out.println("useFruitBasket: " + fruits);
        fruits.add(new Orange());
    }

    /**
     * @param source List of T (Raw/Regular) Class
     * @return void
     */
    public static void nonGenericMethod(List<T> source) {
        System.out.println("nonGenericMethod: "+ source.getClass());
    }

    /**
     * @param source List of T (Generic/Any) Class
     * @param target List of T (Generic/Any) Class
     * @return void
     *
     * <pre>
     *     &lt;T&gt; before Return type tells compiler that T is Parameterized type of method argument instead of Regular class.
     * </pre>
     */
    public static <T> void copyFruits(List<T> source, List<T> target) {
        for (final T t : source) {
            System.out.println(t.getClass());
            target.add(t);
        }
    }

    /**
     * @param source List of T (Generic/Any) Class or List of SubClass of T
     * @param target List of T (Generic/Any) Class
     * @return void
     *
     * <pre>
     *     PECS (Producer Extends Consumer Super) Rule. PECS rule should be applied to argument not to return.
     *     - Source is Producer (Producer Extends)
     *     - Source is producing Ts
     *     - Source is used fetch
     *
     *      - Defines upper bound
     *      - CO_VARIANT
     *
     *      Here extends does not mean that class is going extend a class.
     *      Passed/provided Class can extend, implement or have a method of T Class
     * </pre>
     */
    public static <T> void copyFruitsUsingUpperBound(List<? extends T> source, List<T> target) {
        for (final T t : source) {
            System.out.println("copyFruitsUsingUpperBound:" + t.getClass());
            target.add(t);
        }
    }

    /**
     * @param source List of T (Generic/Any) Class
     * @param target List of T (Generic/Any) Class or List of SuperClass of T
     * @return void
     *
     * <pre>
     *     PECS (Producer Extends Consumer Super) Rule. PECS rule should be applied to argument not to return.
     *     - Target is Consumer (Consumer Super)
     *     - Target is consuming Ts
     *     - Target is used for insertion
     *
     *     - Defines lower bound
     *     - CONTRA_VARIANT
     * </pre>
     */
    public static <T> void copyFruitsUsingLowerBound(List<T> source, List<? super T> target) {
        for (final T t : source) {
            System.out.println("copyFruitsUsingLowerBound:" + t.getClass());
            target.add(t);
        }
    }

    /**
     * @param source List of T (Generic/Any) Class
     * @param target List of T (Generic/Any) Class
     * @return boolean
     *
     * <pre>
     *     Lower/upper bound is defined (Type Parameterized) before method return type
     * </pre>
     */
    public static <T extends Comparable<T>> boolean isFirstElementSame(List<T> source, List<T> target) {
        if(target.get(0).compareTo(source.get(0)) == 0) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param s1 Generic Type which is producer
     * @param s2 Generic Type which is producer
     * @return Set of E
     */
    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        return Sets.newHashSet();
    }

}

