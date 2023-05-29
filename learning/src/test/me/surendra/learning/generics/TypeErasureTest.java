package me.surendra.learning.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TypeErasureTest {

    @Test
    public void arraysLiskovSubstitution() {
        final Integer[] myInts = {1,2,3,4,5};
        final Long[] myLongs = {1L, 2L, 3L, 4L, 5L};
        final Double[] myDoubles = {1.0, 2.0, 3.0, 4.0, 5.0};

        TypeErasure.arraysAreReifiableTypes(myInts);
        TypeErasure.arraysAreReifiableTypes(myLongs);
        TypeErasure.arraysAreReifiableTypes(myDoubles);
    }

    @Test
    public void arraysDoesNotProvidesTypeSafetyAtCompileTime() {
        final Integer[] myInts = {1,2,3,4};

        try {
            TypeErasure.arraysTypeSafetyIssue(myInts);
        }catch (final ArrayStoreException arrayStoreException) {
            System.out.println(arrayStoreException.getMessage());
        }
    }

    @Test
    public void genericLiskovSubstitutionIssue() {
        final Integer[] myInts = {1,2,3,4,5};
        final Long[] myLongs = {1L, 2L, 3L, 4L, 5L};
        final Double[] myDoubles = {1.0, 2.0, 3.0, 4.0, 5.0};

        // Below line won't compile.
        // Need to pass exact type.
//        TypeErasure.genericsAreReifiableTypes(myInts);
//        TypeErasure.genericsAreReifiableTypes(myLongs);
//        TypeErasure.genericsAreReifiableTypes(myDoubles);
    }

    @Test
    public void genericsProvidesTypeSafetyAtCompileTime() {
        final List<Integer> myInts = new ArrayList<Integer>();
        myInts.add(1);
        myInts.add(2);

        TypeErasure.genericsTypeSafety(myInts);
    }


}
