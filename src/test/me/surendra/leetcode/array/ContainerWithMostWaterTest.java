package me.surendra.leetcode.array;

import org.junit.Test;

import static me.surendra.leetcode.array.ContainerWithMostWater.maxAreaUsing2Pointers;
import static me.surendra.leetcode.array.ContainerWithMostWater.maxAreaUsingBruteForce;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ContainerWithMostWaterTest {

    @Test
    public void maxAreaOf1() {
        assertThat(maxAreaUsingBruteForce(new int[]{1, 1}), equalTo(1));
        assertThat(maxAreaUsing2Pointers(new int[]{1, 1}), equalTo(1));
    }

    @Test
    public void maxAreaOf2() {
        assertThat(maxAreaUsingBruteForce(new int[]{1,2,1}), equalTo(2));
        assertThat(maxAreaUsing2Pointers(new int[]{1,2,1}), equalTo(2));
    }

    @Test
    public void maxAreaOf16() {
        assertThat(maxAreaUsingBruteForce(new int[]{4,3,2,1,4}), equalTo(16));
        assertThat(maxAreaUsing2Pointers(new int[]{4,3,2,1,4}), equalTo(16));
    }

    @Test
    public void maxAreaOf49() {
        assertThat(maxAreaUsingBruteForce(new int[]{1,8,6,2,5,4,8,3,7}), equalTo(49));
        assertThat(maxAreaUsing2Pointers(new int[]{1,8,6,2,5,4,8,3,7}), equalTo(49));
    }

    @Test
    public void maxAreaOf17() {
        assertThat(maxAreaUsingBruteForce(new int[]{2,3,4,5,18,17,6}), equalTo(17));
        assertThat(maxAreaUsing2Pointers(new int[]{2,3,4,5,18,17,6}), equalTo(17));
    }

}
