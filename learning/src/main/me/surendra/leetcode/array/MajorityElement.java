package me.surendra.leetcode.array;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/majority-element/">Majority Element</a>
 */
public class MajorityElement {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int majorityElementUsingBoyerMooreVotingAlgorithm(int[] nums) {
        int count = 0;
        int majorityNo = nums[0];
        for (int i=0; i<nums.length; i++) {
            if (count == 0) {
                majorityNo = nums[i];
            }
            count = (nums[i] == majorityNo) ? count+1 : count-1;
        }
        return majorityNo;
    }

    /*
        Time Complexity - O(n log n)
        Space Complexity - O(1)
     */
    public int majorityElementUsingArraySort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

}
