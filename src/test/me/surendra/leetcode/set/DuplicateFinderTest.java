package me.surendra.leetcode.set;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class DuplicateFinderTest {

    private boolean callMethod(final int[] mums) {
//        return new DuplicateFinder().containsDuplicateUsingSet(mums);
        return new DuplicateFinder().containsDuplicateBySortingAndThenSearch(mums);
    }

    @Test
    public void test1() {
        assertThat(callMethod(new int[]{1,2,3,1}), equalTo(true));
        assertThat(callMethod(new int[]{1,2,3,4}), equalTo(false));
        assertThat(callMethod(new int[]{1,1,1,3,3,4,3,2,4,2}), equalTo(true));
    }

}
