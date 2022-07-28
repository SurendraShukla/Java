package me.surendra.leetcode.array.two_pointers.unmodifying;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class ElementRemovalTest {

    private final ElementRemoval elementRemoval = new ElementRemoval();

    private int callMethod(final int[] nums, final int i) {
        return elementRemoval.removeElementUsingCopyDataOnlyWhenNeeded(nums, i);
//        return elementRemoval.removeElementUsingCopyFromStarting(nums, i);
//        return elementRemoval.removeElementGetBothIndexPositionFirst(nums, i);
//        return elementRemoval.removeElementRightIndexCalculatedWhenNeeded(nums, i);
    }

    @Test
    public void test1() {
        assertThat(callMethod(new int[]{2},  3), equalTo(1));
        assertThat(callMethod(new int[]{3, 2, 2, 3},  3), equalTo(2));
        assertThat(callMethod(new int[]{0, 1, 2, 2, 3, 0, 4, 2},  2), equalTo(5));
    }


}
