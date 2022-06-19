package me.surendra.leetcode.binary_search;

import me.surendra.leetcode.binary_search.KthMissingPositiveNumber;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class KthMissingPositiveNumberTest {

    private int callMethod(final int[] arr, final int k) {
        return new KthMissingPositiveNumber().findKthPositiveUsingBinarySearch(arr, k);
//        return new KthMissingPositiveNumber().findKthPositiveIterative(arr, k);
//        return new KthMissingPositiveNumber().findKthPositiveUsingExtraMemory(arr, k);
    }

    @Test
    public void test1() {
        int[] arr = {2, 3, 4, 7, 11};

        assertThat(callMethod(arr, 1), equalTo(1));
        assertThat(callMethod(arr, 2), equalTo(5));
        assertThat(callMethod(arr, 3), equalTo(6));
        assertThat(callMethod(arr, 4), equalTo(8));
        assertThat(callMethod(arr, 5), equalTo(9));
        assertThat(callMethod(arr, 6), equalTo(10));
        assertThat(callMethod(arr, 7), equalTo(12));
        assertThat(callMethod(arr, 20), equalTo(25));
    }

    @Test
    public void test3() {
        int kthPositive = callMethod(new int[]{1,2,3,4}, 2);

        assertThat(kthPositive, equalTo(6));
    }


    @Test
    public void test4() {
        int kthPositive = callMethod(new int[]{1,2,3,4,5,6,7,8,9,10}, 2);

        assertThat(kthPositive, equalTo(12));
    }


}
