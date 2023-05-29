package me.surendra.learning.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class VarianceTest {

    @Test
    public void coVariance() {
        final List<Integer> integers = new ArrayList<>();
        integers.add(10);
        Variance.coVariant(integers);

        final List<Float> floats = new ArrayList<>();
        floats.add(10.0F);
        Variance.coVariant(floats);

        final List<Double> doubles = new ArrayList<>();
        doubles.add(10.10);
        Variance.coVariant(doubles);

        // Below line won't compile. As Object is not sub type of Number
//        Variance.coVariance(new ArrayList<Object>());
    }

    @Test
    public void contraVariance() {
        Variance.contraVariant(new ArrayList<Number>());
        Variance.contraVariant(new ArrayList<Object>());

        // Below line won't compile. As Integer is not super type of Number
//        Variance.contraVariance(new ArrayList<Integer>());
    }

    @Test
    public void inVariance() {
        final List<Integer> integers = new ArrayList<>();
        integers.add(10);
        Variance.coVariant(integers);

        final List<Object> objects = new ArrayList<>();
        objects.add(10);
        objects.add("String");
        Variance.inVariance(objects);
    }

    @Test
    public void independentOfT() {
        final List<Integer> integers = new ArrayList<>();
        integers.add(10);
        Variance.independentOfT(integers);

        final List<Object> objects = new ArrayList<>();
        objects.add(10);
        objects.add("String");
        Variance.independentOfT(objects);
    }

}
