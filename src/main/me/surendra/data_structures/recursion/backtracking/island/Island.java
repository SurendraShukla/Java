package me.surendra.data_structures.recursion.backtracking.island;

public class Island {

    public static int getMaxConnectedLandLen(final int[][] globe) {
        int rowLen = globe.length;
        int colLen = globe[0].length;
        int maxConnectedLandLen = 0;

        for(int row=0; row<rowLen; row++) {
            for(int col=0; col<colLen; col++) {
                int connectedLandLen =  getConnectedLand(row, col, globe);
                if ( connectedLandLen > maxConnectedLandLen ) {
                    maxConnectedLandLen = connectedLandLen;
                }
            }
        }
        return maxConnectedLandLen;
    }

    private static int getConnectedLand(final int row, final int col, final int[][] globe) {
        if (isOutOfRange(row, col, globe) || globe[row][col] == 0) {
            return 0;
        }
        globe[row][col] = 0; // So its Neighbour doesn't count it
        int size = 1
            + getConnectedLand(row, col+1, globe)   // E
            + getConnectedLand(row, col-1, globe)   // W
            + getConnectedLand(row-1, col, globe)   // N
            + getConnectedLand(row+1, col, globe)   // S
            + getConnectedLand(row-1, col-1, globe) // NW
            + getConnectedLand(row-1, col+1, globe) // NE
            + getConnectedLand(row+1, col-1, globe) // SW
            + getConnectedLand(row+1, col+1, globe);// SE
        return size;
    }

    private static boolean isOutOfRange(final int row, final int col, final int[][] globe) {
        return (row < 0)
            || (col < 0)
            || (row >= globe.length)
            || (col >= globe[0].length)
            ;

    }

}
