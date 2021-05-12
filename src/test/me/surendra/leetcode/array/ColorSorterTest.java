package me.surendra.leetcode.array;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ColorSorterTest {

    private void callMethod(final int[] input) {
        ColorSorter.sortColorsUsingExtraArray(input);
        ColorSorter.sortColorsUsing3Pointers(input);
    }

    @Test
    public void test1() {
        int[] input = {0};

        callMethod(input);

        assertThat(input, equalTo(new int[]{0}));
    }


    @Test
    public void test2() {
        int[] input = {1};

        callMethod(input);

        assertThat(input, equalTo(new int[]{1}));
    }

    @Test
    public void test3() {
        int[] input = {2,0,1};

        callMethod(input);

        assertThat(input, equalTo(new int[]{0,1,2}));
    }

    @Test
    public void test4() {
        int[] input = {2, 1, 1};

        callMethod(input);

        assertThat(input, equalTo(new int[]{1,1,2}));
    }

    @Test
    public void test5() {
        int[] input = {2, 0, 2, 1, 1, 0};

        callMethod(input);

        assertThat(input, equalTo(new int[]{0,0,1,1,2,2}));
    }

}
