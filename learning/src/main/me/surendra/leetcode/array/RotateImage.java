package me.surendra.leetcode.array;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int matrixLength = matrix.length;
        int totalElement = matrixLength * matrixLength;
        int innerLoopTerminator = matrixLength-1;
        int outerLoopTerminator = totalElement;

        int rowMin = 0;
        int colMin = 0;
        int rowMax = innerLoopTerminator;
        int colMax = innerLoopTerminator;

        while(outerLoopTerminator>=4) {
            int tmpRowMin = rowMin;
            int tmpColMin = colMin;
            int tmpRowMax = rowMax;
            int tmpColMax = colMax;
            int tmpLoopTerminator = innerLoopTerminator;
            while(tmpLoopTerminator>0) {
                int tmpVal = matrix[tmpRowMin][tmpColMin];
                // TMP Val - First Row, Last Col
                tmpVal = getTmpValAndReplaceVal(matrix, tmpVal, tmpRowMin, tmpColMax); // Top Row Right Column
                tmpVal = getTmpValAndReplaceVal(matrix, tmpVal, tmpRowMax, tmpColMax); // Bottom Row Right Column
                tmpVal = getTmpValAndReplaceVal(matrix, tmpVal, tmpRowMax, tmpColMin); // Bottom Row Left Column
                getTmpValAndReplaceVal(matrix, tmpVal, tmpRowMin, tmpColMin); // Top Row Left Column
                outerLoopTerminator-=4;
                tmpLoopTerminator--;
                tmpRowMin++;
                tmpColMin++;
                tmpRowMax--;
                tmpColMax--;
            }
            innerLoopTerminator-=2;
            rowMin++;
            colMin++;
            rowMax--;
            colMax--;
        }
    }

    private int getTmpValAndReplaceVal(final int[][] matrix, final int val, final int row, final int col) {
        int returnVal = matrix[row][col];
        matrix[row][col] = val;
        return returnVal;
    }

}
