package me.surendra.leetcode.array.easy;


/**
 * @see <a href="https://leetcode.com/problems/image-smoother/">Image Smoother</a>
 */
public class ImageSmoother {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public int[][] findAverageOfItsNeighbourAtIndex(final int[][] img) {
        final int rowMax = img.length;
        final int colMax = img[0].length;

        final int[] rows = {-1, -1, -1, 0, 0, 1, 1, 1};
        final int[] cols = {-1, 0, 1, -1, 1, -1, 0, 1};
        final int[][] result = new int[rowMax][colMax];
        for (int row = 0; row < rowMax; row++) {
            for (int col = 0; col < colMax; col++) {
                int neighbourSum = img[row][col];
                int totalNeighbour = 1;
                for (int d = 0; d < rows.length; d++) {
                    final int nextRow = row + rows[d];
                    final int nextCol = col + cols[d];
                    if (nextRow < 0 || nextRow >= rowMax || nextCol < 0 || nextCol >= colMax) {
                        continue;
                    }
                    neighbourSum += img[nextRow][nextCol];
                    totalNeighbour++;
                }
                result[row][col] = neighbourSum  / totalNeighbour;
            }
        }

        return result;
    }

}
