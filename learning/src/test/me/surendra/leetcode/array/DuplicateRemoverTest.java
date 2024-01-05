package me.surendra.leetcode.array;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class DuplicateRemoverTest {

    private final DuplicateRemover duplicateRemover = new DuplicateRemover();

    private int callMethod(final int[] input) {
        return duplicateRemover.removeDuplicatesFromSortedArrayUsing2Pointers(input);
    }

    @Test
    public void test() {
        assertThat(callMethod(new int[] {1, 2, 3}), equalTo(3));
        assertThat(callMethod(new int[] {1, 1, 2}), equalTo(2));
        assertThat(callMethod(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}), equalTo(5));
    }

}
