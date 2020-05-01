package me.surendra.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/
public class SpiralMatrix {

    public List<Integer> spiralOrder(final int[][] matrix) {
        final List<Integer> returnArray = new ArrayList<>();
        if (matrix.length == 0) {
            return returnArray;
        }

        int rowStart = 0;
        int colStart = 0;
        int rowEnd = matrix.length -1;
        int colEnd = matrix[0].length -1;

        while(rowStart <= rowEnd && colStart <= colEnd) {

            // Traverse Right
            for(int counter=colStart; counter<=colEnd; counter++) {
                returnArray.add(matrix[rowStart][counter]);
            }
            rowStart++;

            // Traverse Down
            for(int counter=rowStart; counter<=rowEnd; counter++) {
                returnArray.add(matrix[counter][colEnd]);
            }
            colEnd--;

            if (rowStart <= rowEnd) {
                // Traverse Left
                for (int counter = colEnd; counter >= colStart; counter--) {
                    returnArray.add(matrix[rowEnd][counter]);
                }
            }
            rowEnd--;

            if (colStart <= colEnd) {
                // Traverse Up
                for (int counter = rowEnd; counter >= rowStart; counter--) {
                    returnArray.add(matrix[counter][colStart]);
                }
            }
            colStart++;

        }
        return returnArray;
    }

}
