package me.surendra.leetcode.array;


/**
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/solution/">Remove Duplicates from Sorted Array</a>
 */
public class DuplicateRemover {

    /*
        Time complexity: O(n)
        Space complexity: O(1)
     */
    public int removeDuplicatesFromSortedArrayUsing2Pointers(final int[] nums) {
        int insertIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        return insertIndex;
    }

}
