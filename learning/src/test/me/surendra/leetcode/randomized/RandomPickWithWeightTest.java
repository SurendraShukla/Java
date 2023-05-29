package me.surendra.leetcode.randomized;

import org.junit.Test;

public class RandomPickWithWeightTest {

    @Test
    public void test1() {
        int[] input = {1, 3};
        final RandomPickWithWeight randomPickWithWeight = new RandomPickWithWeight(input);

        for (int i = 0; i < 5; i++) {
            System.out.println(randomPickWithWeight.pickIndex());
        }
    }

}
