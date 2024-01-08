package me.surendra.leetcode.binary_search;

import org.junit.Test;

import static me.surendra.leetcode.binary_search.Binary.findMaxConsecutiveOnes;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class BinaryTest {

    @Test
    public void test() {
        assertThat(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}), equalTo(3));
        assertThat(findMaxConsecutiveOnes(new int[]{0}), equalTo(0));
        assertThat(findMaxConsecutiveOnes(new int[]{1, 0}), equalTo(1));
        assertThat(findMaxConsecutiveOnes(new int[]{1, 0, 1}), equalTo(1));
        assertThat(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1}), equalTo(2));
        assertThat(findMaxConsecutiveOnes(new int[]{1, 0, 1, 1}), equalTo(2));
    }

}
