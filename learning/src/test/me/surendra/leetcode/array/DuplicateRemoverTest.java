package me.surendra.leetcode.array;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class DuplicateRemoverTest {

    private int callMethod(final int[] input) {
        return new DuplicateRemover().removeDuplicatesFromSortedArrayUsing2Pointers(input);
    }

    @Test
    public void test1() {
        final int[] input = new int[] {1,2,3};

        int result = callMethod(input);
        assertThat(result, equalTo(3));
    }

    @Test
    public void test2() {
        final int[] input = new int[] {1,1,2};

        int result = callMethod(input);
        assertThat(result, equalTo(2));
    }

    @Test
    public void test3() {
        final int[] input = new int[] {0,0,1,1,1,2,2,3,3,4};

        int result = callMethod(input);
        assertThat(result, equalTo(5));
    }


}
