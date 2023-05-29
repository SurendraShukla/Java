package me.surendra.leetcode.array.two_pointers;


/**
 * @see <a href="https://leetcode.com/problems/rotate-array/">Rotate Array</a>
 */
public class RotateArrayByKSteps {

    /*
        Time complexity : O(n)
        Space complexity: O(h) - Height of tree
     */
    public void rotateByReversingIn3Steps(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        k = k % nums.length;
        // Reverse before k
        reverse(nums, 0, nums.length-k-1);
        // Reverse after k
        reverse(nums, nums.length-k, nums.length-1);
        // Reverse whole reversed array
        reverse(nums, 0, nums.length-1);
    }

    private void reverse(int[] nums, int leftPointer, int rightPointer) {
        while (leftPointer < rightPointer) {
            int tmp = nums[leftPointer];
            nums[leftPointer] = nums[rightPointer];
            nums[rightPointer] = tmp;
            rightPointer--;
            leftPointer++;
        }
    }

}
