package me.surendra.leetcode.array;

/**
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/solution/">Remove Duplicates from Sorted Array</a>
 */
public class DuplicateRemover {

    /*
        Time complexity: O(n)
        Space complexity: O(1)
     */
    public int removeDuplicatesFromSortedArrayUsing2Pointers(int[] nums) {
        if (nums.length == 0) return 0;
        int slowPointer = 0;
        for (int fastPointer = 1; fastPointer < nums.length; fastPointer++) {
            if (nums[fastPointer] != nums[slowPointer]) {
                slowPointer++;
            }
            nums[slowPointer] = nums[fastPointer];
        }
        return slowPointer+1;
    }

}
