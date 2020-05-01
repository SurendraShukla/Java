package me.surendra.tdd;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class NumericStringSort {

//    @Test
//    public void printNothingForEmptyArray() {
//        final String[] strArray = {};
//        Assert.assertEquals(strArray, Matchers.equalTo(getSortedElements(strArray)));
//    }

    @Test
    public void ableToConvertStringAndReturn() {
        final String[] strArray = {"1"};
        final int[] outputArray = {1};

        Assert.assertThat(outputArray, Matchers.equalTo(getSortedElements(strArray)));
    }

    @Test
    public void shouldReturnSortedArray() {
        final String[] strArray = {"2, 3, 1"};
        final int[] outputArray = {1, 2, 3};

        Assert.assertThat(outputArray, Matchers.equalTo(getSortedElements(strArray)));
    }

    private int[] getSortedElements(final String[] strArray) {
        final int[] returnArray = new int[strArray.length];
        for(int counter=0; counter<strArray.length; counter++) {
            final int intVal = Integer.valueOf(strArray[counter]);

            returnArray[counter] = intVal;
        }
        return returnArray;
    }
}
