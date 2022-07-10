package me.surendra.leetcode.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/target-sum/">Target Sum</a>
 *
 * <a href="https://www.youtube.com/watch?v=g0npyaQtAQM">Video Link</a>
 */
public class TargetSumFinder {

    /*
        Time Complexity - O(2 ^ n) 2 decision branch ^ N Recursion depth
        Space Complexity - O(n) Recursion depth/stack
     */
    int count = 0;
    public int findTargetSumWaysUsingRecursionWithoutSpace(final int[] nums, final int target) {
        populateTargetSumWays(nums, target, 0);
        return count;
    }

    private void populateTargetSumWays(final int[] nums, final int target, final int i) {
        if (i == nums.length) {
            if (target == 0) {
                count++;
            }
        } else {
            populateTargetSumWays(nums, target + nums[i], i + 1);
            populateTargetSumWays(nums, target - nums[i], i + 1);
        }
    }

    /*
        Time Complexity - O(2 ^ n)
        Space Complexity - O(2 ^ n)
     */
    public int findTargetSumWaysUsingRecursionWithSpace(final int[] nums, final int target) {
        final List<Integer> integerList = populateTargetSumWays(nums, 0);
        return integerList.stream().filter((no) -> no == target).toArray().length;
    }

    private List<Integer> populateTargetSumWays(final int[] nums, final int i) {
        if (i == nums.length - 1) {
            return Arrays.asList(nums[i], nums[i] * -1);
        }
        final List<Integer> positiveIntegers = populateTargetSumWays(nums, i + 1);
        final List<Integer> returnList = new ArrayList<>();
        for (final Integer positiveInteger : positiveIntegers) {
            returnList.add(positiveInteger + nums[i]);
            returnList.add((positiveInteger + nums[i]) * -1);
        }
        return returnList;
    }


    /*
        Time Complexity - O(2 ^ n)
        Space Complexity - O(2 ^ n)
     */
    public int findTargetSumWaysSelfThought(final int[] nums, final int target) {
        List<Integer> previousIntegerList = new ArrayList<>();
        previousIntegerList.add(nums[0]);
        previousIntegerList.add(-1 * nums[0]);

        for (int i = 1; i < nums.length; i++) {
            final int currentNo = nums[i];
            final List<Integer> currentIntegerList = new ArrayList<>();
            for (int previousNo: previousIntegerList) {
                final int tmpNo = previousNo + currentNo;
                currentIntegerList.add(tmpNo);
                currentIntegerList.add(tmpNo * -1);
            }
            previousIntegerList = currentIntegerList;
        }

        int numberOfExpressions = 0;
        for (int no: previousIntegerList) {
            if (target == no) {
                numberOfExpressions++;
            }
        }
        return numberOfExpressions;
    }

}
