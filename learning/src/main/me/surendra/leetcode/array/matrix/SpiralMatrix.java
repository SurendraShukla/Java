package me.surendra.leetcode.array.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a hrf="https://leetcode.com/problems/spiral-matrix/">Spiral Matrix</a>
 */
public class SpiralMatrix {

    /*
        Time complexity : O(m * n)
        Space complexity: O(1)
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowMin = 0;
        int rowMax = matrix.length - 1;
        int colMin = 0;
        int colMax = matrix[0].length -1;

        List<Integer> returnList = new ArrayList<>();
        while (rowMin <= rowMax && colMin <= colMax) {

            // Traverse Right
            for(int colRight=colMin; colRight<=colMax; colRight++) {
                returnList.add(matrix[rowMin][colRight]);
            }
            rowMin++;

            // Traverse Down
            for(int rowBottom=rowMin; rowBottom<=rowMax; rowBottom++) {
                returnList.add(matrix[rowBottom][colMax]);
            }
            colMax--;

            if (rowMin <= rowMax) {
                // Traverse Left
                for (int colLeft = colMax; colLeft >= colMin; colLeft--) {
                    returnList.add(matrix[rowMax][colLeft]);
                }
            }
            rowMax--;

            if (colMin <= colMax) {
                // Traverse Up
                for (int rowUp = rowMax; rowUp >= rowMin; rowUp--) {
                    returnList.add(matrix[rowUp][colMin]);
                }
            }
            colMin++;
        }
        return returnList;
    }

}
