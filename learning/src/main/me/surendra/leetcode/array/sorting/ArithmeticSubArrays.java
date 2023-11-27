package me.surendra.leetcode.array.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/arithmetic-subarrays/">Arithmetic Subarrays</a>
 */
public class ArithmeticSubArrays {

    /*
        Time Complexity - O(m * n) M is queries, N is r[i] - l[i]
        Space Complexity - O(n) New SubArray cost
     */
    public List<Boolean> checkArithmeticSubArrays(final int[] nums, final int[] l, final int[] r) {
        final List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            final int[] newArray = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            result.add(arithmeticSubArray(newArray));
        }

        return result;
    }

    private boolean arithmeticSubArray(final int[] arr) {
        if (arr.length <= 2) {
            return true;
        }
        Arrays.sort(arr);
        final int diff = arr[0] - arr[1];

        for (int i = 2; i < arr.length; i++) {
            if (diff != (arr[i - 1] - arr[i])) {
                return false;
            }
        }
        return true;
    }

}
