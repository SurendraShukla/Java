package me.surendra.leetcode.prefix_sum;


/**
 * @see <a href="https://leetcode.com/problems/product-of-array-except-self/">Product of Array Except Self</a>
 */
public class ProductOfArrayExceptSelf {

    /*
        Time Complexity - O(n)
        Space Complexity- O(n)
     */
    public int[] productExceptSelf(final int[] nums) {
        final int[] productFromLeft = new int[nums.length];
        final int[] productFromRight = new int[nums.length];
        productFromLeft[0] = 1;
        productFromRight[nums.length - 1] = 1;

        int left = 1;
        int right = nums.length - 2;

        while (left < nums.length) {
            productFromLeft[left] = nums[left - 1] * productFromLeft[left - 1];
            productFromRight[right] = nums[right + 1] * productFromRight[right + 1];
            left++;
            right--;
        }

        final int[] result = new int[nums.length];
        for (int k = 0; k < nums.length; k++) {
            result[k] = productFromLeft[k] * productFromRight[k];
        }

        return result;
    }

}
