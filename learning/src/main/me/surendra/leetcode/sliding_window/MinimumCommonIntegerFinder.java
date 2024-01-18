package me.surendra.leetcode.sliding_window;

/**
 * @see <a href="https://leetcode.com/discuss/interview-question/4250155/how-to-solve-this-tiktok-problem">Find the minimum common integer</a>
 */

/*
    Given an array data of size n,
    where the value of the i**^(th)** integer is represented by the array ***data[i]***,
    the algorithm will run on data as:
    For every integer k, where 1 ≤ k ≤ n.
    The algorithm will return the minimum common integer that occurs in all of the subarrays of the array data having length K.
    If there is no common integer occurring in any subarray of length K, then the algorithm will return -1.
    Here is an example,
        n=5, data=[4,3,3,4,2]
        k SubArrays                         Minimum Common Integer
        1   [4] [3] [3] [4] [2]                 -1
        2   [4, 3], [3, 3]. [3, 4], [4, 2]      -1
        3   [4, 3, 3], [3, 3, 4], [3, 4, 2]     3
        4   [4, 3, 3, 4], [3, 3, 4, 2]          3
        5   [4, 3, 3, 4, 2]                     2
    Finally, return [-1, -1, 3, 3, 2]
*/
public class MinimumCommonIntegerFinder {

    int getMinimumCommonInteger(final int[] data, final int k) {
        for (int len = 1; len < data.length; len++) {
            System.out.println(len);
        }
        return 0;
    }

}

