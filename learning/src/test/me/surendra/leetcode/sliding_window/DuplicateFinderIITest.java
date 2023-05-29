package me.surendra.leetcode.sliding_window;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class DuplicateFinderIITest {

    private boolean callMethod(final int[] mums, final int k) {
        return new DuplicateFinderII().containsNearbyDuplicateUsingHashSetToKeepLastKElements(mums, k);
//        return new DuplicateFinderII().containsNearbyDuplicateUsingTreeSetToKeepLastKElements(mums, k);
//        return new DuplicateFinderII().containsNearUsingSlidingWindowToKeepOnlyLastIndex(mums, k);
//        return new DuplicateFinderII().containsNearbyDuplicateByLinearSearchForPreviousKElements(mums, k);
//        return new DuplicateFinderII().containsNearbyDuplicateUsingPreviousIndexesInHashMap(mums, k);
    }

    @Test
    public void neighbouringElement() {
        assertThat(callMethod(new int[]{1, 0, 1, 1}, 1), equalTo(true));
    }

    @Test
    public void inRangeOfKDiff() {
        assertThat(callMethod(new int[]{1, 2, 3, 1}, 3), equalTo(true));
    }

    @Test
    public void notInRangeOfKDiff() {
        assertThat(callMethod(new int[]{1, 2, 3, 1, 2, 3}, 2), equalTo(false));
    }

}
