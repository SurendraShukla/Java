package me.surendra.leetcode.dynamic_programming;


/**
 * @see <a href="https://leetcode.com/problems/unique-paths/">Unique Paths</a>
 */
public class UniquePathsFinder {

    /*
        Time Complexity - O(n*m)
        Space Complexity - O(1)
     */
    public long uniquePaths(int m, int n) {
        long[][] matrix = new long[m][n];
        for(int i=0; i<n; i++) {
            matrix[0][i] = 1;
        }
        for(int j=0; j<m; j++) {
            matrix[j][0] = 1;
        }
        for (int row=1; row<m; row++) {
            for (int col=1; col<n; col++) {
                matrix[row][col] = matrix[row-1][col] + matrix[row][col-1];
            }
        }
        return matrix[m-1][n-1];
    }

}
