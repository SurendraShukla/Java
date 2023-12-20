package me.surendra.leetcode.hash_map;

import me.surendra.leetcode.array.DuplicateNumberFinder;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class DuplicateNumberFinderTest {

    final DuplicateNumberFinder duplicateNumberFinder = new DuplicateNumberFinder();

    private int callMethod(final int[] nums) {
        return duplicateNumberFinder.findDuplicateUsingArray(nums);
//        return duplicateNumberFinder.findDuplicateByFloydsAlog_TortoiseAndHare(nums);
//        return duplicateNumberFinder.findDuplicateBySeenAlgorithmUsingNegativeMarking(nums);
//        return duplicateNumberFinder.findDuplicateBySeenAlgorithmUsingSet(nums);
//        return duplicateNumberFinder.findDuplicateUsingSorting(nums);
    }

    @Test
    public void testFindDuplicateBySeenAlgorithmUsingSameArray() {
        assertThat(callMethod(new int[]{1, 3, 4, 2, 2}), equalTo(2));
        assertThat(callMethod(new int[]{3, 1, 3, 4, 2}), equalTo(3));
        assertThat(callMethod(new int[]{1, 1}), equalTo(1));
        assertThat(callMethod(new int[]{1, 1, 2}), equalTo(1));
        assertThat(callMethod(new int[]{2, 2, 2, 2, 2}), equalTo(2));
    }

}
