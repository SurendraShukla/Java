package me.surendra.leetcode.binary_search;


/**
 * @see <a href="https://leetcode.com/problems/search-a-2d-matrix/">Search a 2D Matrix</a>
 */
public class SearchIn2DMatrix {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public boolean searchMatrix(final int[][] matrix, final int target) {
        final int rowMax = matrix.length;
        final int colMax = matrix[0].length;

        int left = 0;
        int right = rowMax * colMax - 1;

        while (left <= right) {
            final int mid = left + ((right - left) / 2);
            // idx = row * colMax + col
            final int row = mid / colMax;
            final int col = mid % colMax;
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

}
