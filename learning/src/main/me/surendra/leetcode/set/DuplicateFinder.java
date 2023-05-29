package me.surendra.leetcode.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * @see <a href="https://leetcode.com/problems/contains-duplicate/">Contains Duplicate</a>
 */
public class DuplicateFinder {

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public boolean containsDuplicateUsingSet(int[] nums) {
        final Set<Integer> seenValues = new HashSet<>();
        for(int num: nums) {
            if (seenValues.contains(num)) {
                return true;
            }
            seenValues.add(num);
        }
        return false;
    }

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public boolean containsDuplicateBySortingAndThenSearch(int[] nums) {
        if (nums.length == 1)  {
            return false;
        }
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) {
                return true;
            }
        }
        return false;
    }

}
