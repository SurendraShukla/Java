package me.surendra.leetcode.array.sorting;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ReductionOperationsToMakeArrayElementsEqualTest {

    private final ReductionOperationsToMakeArrayElementsEqual unit = new ReductionOperationsToMakeArrayElementsEqual();

    @Test
    public void test() {
        assertThat(unit.reductionOperations(new int[]{5, 1, 3}), equalTo(3));
        assertThat(unit.reductionOperations(new int[]{1, 1, 1}), equalTo(0));
        assertThat(unit.reductionOperations(new int[]{1, 1, 2, 2, 3}), equalTo(4));
    }
}
