package me.surendra.leetcode.array.easy;


/**
 * @see <a href="https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/">Element Appearing More Than 25% In Sorted Array</a>
 */
public class ElementAppearingMoreThan25Percentage {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int findSpecialInteger(final int[] arr) {
        final int maxCount = arr.length / 4;
        for (int i = 0; i < arr.length - maxCount; i++) {
            if (arr[i] == arr[i + maxCount]) {
                return arr[i];
            }
        }
        return -1;
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int findSpecialIntegerWithCountVariable(final int[] arr) {
        final int len = arr.length;
        if (len == 1) {
            return arr[0];
        }
        final int maxCount = len / 4;
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (arr[i - 1] == arr[i]) {
                count++;
                if (count > maxCount) {
                    return arr[i];
                }
            } else {
                count = 1;
            }
        }
        return -1;
    }

}
