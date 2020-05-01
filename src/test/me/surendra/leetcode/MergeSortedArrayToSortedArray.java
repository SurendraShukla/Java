package me.surendra.leetcode;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

//
public class MergeSortedArrayToSortedArray {

    @Test
    public void test1() {
        final int[] arr1 = { 1, 3, 4, 5};
        final int[] arr2 = {2, 4, 6, 8};
        final int[] expected = {1, 2, 3, 4, 4, 5, 6, 8};

        // Execute
        final int[] outputArr = getMergedSortedArray(arr1, arr2);

        Assert.assertThat(expected, Matchers.equalTo(outputArr));
        System.out.println(Arrays.toString(outputArr));
//        Arrays.stream(outputArr).forEach(System.out::println);
    }

    @Test
    public void test2() {
        final int[] arr1 = { 5, 8, 9};
        final int[] arr2 = {4, 7, 8};
        final int[] expected = {4, 5, 7, 8, 8, 9} ;

        // Execute
        final int[] outputArr = getMergedSortedArray(arr1, arr2);

        Assert.assertThat(expected, Matchers.equalTo(outputArr));
    }

    private int[] getMergedSortedArray(final int[] arr1, final int[] arr2) {
        int arr1Len = arr1.length;
        int arr2Len = arr2.length;

        final int[] outputArr = new int[arr1Len+arr2Len];
        int arr1Counter = 0;
        int arr2Counter = 0;
        int outputCounter = 0;

        while(arr1Counter<arr1Len && arr2Counter<arr2Len) {
            if (arr1[arr1Counter] < arr2[arr2Counter]) {
                outputArr[outputCounter++] = arr1[arr1Counter++];
            } else {
                outputArr[outputCounter++] = arr2[arr2Counter++];
            }
        }

        while (arr1Counter < arr1Len) {
            outputArr[outputCounter++] = arr1[arr1Counter++];
        }
        while (arr2Counter < arr2Len){
            outputArr[outputCounter++] = arr2[arr2Counter++];
        }
        return outputArr;
    }

}
