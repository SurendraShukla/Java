package me.surendra.leetcode.array.two_pointers;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class ContainerWithMostWaterTest {

    private final ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

    private int callMethod(final int[] height) {
        return containerWithMostWater.maxAreaUsing2Pointers(height);
//        return containerWithMostWater.maxAreaUsingBruteForce(height);
    }

    @Test
    public void maxAreaOf1() {
        assertThat(callMethod(new int[]{1, 1}), equalTo(1));
    }

    @Test
    public void maxAreaOf2() {
        assertThat(callMethod(new int[]{1, 2, 1}), equalTo(2));
    }

    @Test
    public void maxAreaOf16() {
        assertThat(callMethod(new int[]{4, 3, 2, 1, 4}), equalTo(16));
    }

    @Test
    public void maxAreaOf49() {
        assertThat(callMethod(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}), equalTo(49));
    }

    @Test
    public void maxAreaOf17() {
        assertThat(callMethod(new int[]{2, 3, 4, 5, 18, 17, 6}), equalTo(17));
    }

}
