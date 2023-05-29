package me.surendra.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * @see <a href="https://leetcode.com/problems/find-the-duplicate-number/">Find the Duplicate Number</a>
 */
public class DuplicateNumberFinder {

    /*
        Time complexity : O(n)
        Space complexity: O(1)

        // 0 position to store next index for swapping/check
     */
    public int findDuplicateUsingArray(int[] nums) {
        while (nums[0] != nums[nums[0]]) {
            int tmp = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = tmp;
        }
        return nums[0];
    }

    /*
        Time complexity : O(n)
        Space complexity: O(1)
     */
    public int findDuplicateByFloydsAlog_TortoiseAndHare(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        }while (tortoise != hare);

        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return tortoise;
    }

    /*
        Time complexity : O(n)
        Space complexity: O(1)
     */
    public int findDuplicateBySeenAlgorithmUsingNegativeMarking(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if (nums[val] < 0) {
                return val;
            }
            nums[val]*= -1;
        }
        return 0;
    }

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public int findDuplicateBySeenAlgorithmUsingSet(int[] nums) {
        final Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(nums[i])) {
                return nums[i];
            }
            seen.add(nums[i]);
        }
        return 0;
    }

    /*
        Time complexity : O(n log n)
        Space complexity: O(n) - Sorting an array
     */
    public int findDuplicateUsingSorting(int[] nums) {
        Arrays.sort(nums);

        int previousVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == previousVal) {
                return previousVal;
            }
            previousVal=nums[i];
        }
        return 0;
    }

}
