package suren.coding_dojo.MatrixSpiral;


public class SpiralOrderMatrixTraversal {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4, 5 },
                {14, 15, 16, 17, 6},
                {13, 20, 19, 18, 7},
                {12, 11, 10, 9, 8}
        };
        printSpiralIterative(matrix);
        System.out.println();
        printSpiralRecursive(matrix, 1);
    }

    private static void printSpiralIterative(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while(top < bottom && left < right) {
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;
            for (int i = right; i >= left; i--) {
                System.out.print(matrix[bottom][i] + " ");
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                System.out.print(matrix[i][left] + " ");
            }
            left++;
        }
    }

    private static void printSpiralRecursive(int[][] matrix, int layer) {
        int top = layer - 1;
        int bottom = matrix.length - layer;
        int left = layer - 1;
        int right = matrix[0].length - layer;

        if (top > bottom || left > right) {
            return;
        }
        for (int i = left; i <= right; i++) {
            System.out.print(matrix[top][i] + " ");
        }
        top++;
        for (int i = top; i <= bottom; i++) {
            System.out.print(matrix[i][right] + " ");
        }
        right--;
        for (int i = right; i >= left; i--) {
            System.out.print(matrix[bottom][i] + " ");
        }
        bottom--;
        for (int i = bottom; i >= top; i--) {
            System.out.print(matrix[i][left] + " ");
        }
        left++;
        printSpiralRecursive(matrix, layer + 1);
    }
}