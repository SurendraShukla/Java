package me.surendra.leetcode.design;

import org.junit.Test;

public class ArrayShufflerTest {

    @Test
    public void test1() {
        ArrayShuffler arrayShuffler = new ArrayShuffler(new int[]{1, 2, 3});
        arrayShuffler.shuffleByBruteForce();
        arrayShuffler.reset();
    }

    @Test
    public void test2() {
        ArrayShuffler arrayShuffler = new ArrayShuffler(new int[]{1, 2, 3});
        arrayShuffler.shuffleByFisherYates();
        arrayShuffler.reset();
    }
}
