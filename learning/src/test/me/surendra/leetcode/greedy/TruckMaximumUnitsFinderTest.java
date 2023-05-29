package me.surendra.leetcode.greedy;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class TruckMaximumUnitsFinderTest {

    private final TruckMaximumUnitsFinder truckMaximumUnitsFinder = new TruckMaximumUnitsFinder();

    private int callMethod(final int[][] boxTypes, final int truckSize) {
        return truckMaximumUnitsFinder.maximumUnitsUsingRemainingTruckSize(boxTypes, truckSize);
//        return truckMaximumUnitsFinder.maximumUnitsSelfThought(boxTypes, truckSize);
//        return truckMaximumUnitsFinder.maximumUnitsUsingMaximumHeap(boxTypes, truckSize);
    }

    @Test
    public void test1() {
        final int[][] boxTypes = {{1, 3}, {2, 4}};

        assertThat(callMethod(boxTypes, 1), equalTo(4));
        assertThat(callMethod(boxTypes, 2), equalTo(8));
        assertThat(callMethod(boxTypes, 3), equalTo(11));
        assertThat(callMethod(boxTypes, 4), equalTo(11));
    }


    @Test
    public void test2() {
        assertThat(callMethod(new int[][]{
            {1, 3}, {2, 2}, {3, 1}}, 4), equalTo(8));

        assertThat(callMethod(new int[][]{
            {5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10), equalTo(91));
    }

}
