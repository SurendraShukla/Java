package me.surendra.leetcode.array;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class FirstMissingPositiveFinderTest {

    private int callMethod(final int[] input) {
        return new FirstMissingPositiveFinder().firstMissingPositive(input);
    }

    @Test
    public void allPositiveWith0() {
         int[] input = new int[]{1,2,0};

        assertThat(callMethod(input), equalTo(3));
    }

    @Test
    public void allPositiveSequentialWithout0() {
        int[] input = new int[]{1,2,3};

        assertThat(callMethod(input), equalTo(4));
    }

    @Test
    public void allPositiveNonSequentialWithout0() {
        int[] input = new int[]{7,8,9,11,12};

        assertThat(callMethod(input), equalTo(1));
    }

    @Test
    public void mixedWithout0() {
        int[] input = new int[]{3,4,-1,1};

        assertThat(callMethod(input), equalTo(2));
    }

}
