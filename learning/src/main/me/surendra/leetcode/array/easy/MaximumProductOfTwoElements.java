package me.surendra.leetcode.array.easy;


/**
 * @see <a href="https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/">Maximum Product of Two Elements in an Array</a>
 */
public class MaximumProductOfTwoElements {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int maxProduct(final int[] nums) {
        int biggest = 0;
        int secondBiggest = 0;
        for (int num : nums) {
            if (num > biggest) {
                secondBiggest = biggest;
                biggest = num;
            }else if (num > secondBiggest) {
                secondBiggest = num;
            }
        }

        return (biggest - 1) * (secondBiggest - 1);
    }

}
