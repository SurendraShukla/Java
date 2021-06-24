package me.surendra.leetcode.array.matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/">Kth Smallest Element in a Sorted Matrix</a>
 */
public class KthSmallestElementFinder {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public int kthSmallestInSortedArray(int[][] matrix, int k) {
        final List<Integer> lists = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                lists.add(matrix[row][col]);
            }
        }
        Collections.sort(lists);

        return lists.get(k-1);
    }

}
