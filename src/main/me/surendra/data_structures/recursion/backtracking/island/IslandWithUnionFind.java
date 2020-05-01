package me.surendra.data_structures.recursion.backtracking.island;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class IslandWithUnionFind {
    final private UnionFind unionFind;
    final private int totalRows;
    final private int totalCols;
    final private int[][] matrix;

    IslandWithUnionFind(final int[][] matrix) {
        this.matrix = matrix;
        totalRows = matrix.length;
        totalCols = matrix[0].length;

        unionFind = new UnionFind(totalRows*totalCols);
    }

    public int getMaxConnectedPointsCount() {
        connectLands();
        return unionFind.getMaxConnectedPointsCount();
    }

    public Map<Integer, List<Map<Integer, Integer>>> getAllConnectedLand() {
        connectLands();
        return getConnectedSites();
    }

    private void connectLands() {
        for(int row=0; row<totalRows; row++) {
            for(int col=0; col<totalCols; col++) {
                if(isWater(matrix[row][col])) {
                    continue;
                }
                int currentSite = getUnionFindIndex(row, col);
                connectNextEastSiteIfItsLand(row, col, currentSite);
                connectNextSouthSiteIfItsLand(row, col, currentSite);
                connectNextSouthEastSiteIfItsLand(row, col, currentSite);
            }
        }
    }

    private Map<Integer, List<Map<Integer, Integer>>> getConnectedSites() {
        final Map<Integer, List<Map<Integer, Integer>>> returnMap = new HashMap<>();

        final Map<Integer, Set<Integer>> connectedPointsOnly = unionFind.getConnectedPointsOnly();
        connectedPointsOnly.forEach((key, val) -> {
            final List<Map<Integer, Integer>> sites = val.parallelStream().map(index -> getMatrixRowAndColIndex(index)).collect(Collectors.toList());
            returnMap.put(key, sites);
        });
        return returnMap;
    }

    private void connectNextSouthEastSiteIfItsLand(final int row, final int col, final int currentSite) {
        if (!isSiteInRange(row, totalRows) || !isSiteInRange(col, totalCols)) return;
        if (isWater(matrix[row+1][col+1])) return;

        int nextSouthEastSite = getUnionFindIndex(row+1, col+1);
        unionFind.connect(currentSite, nextSouthEastSite);
    }

    private void connectNextSouthSiteIfItsLand(final int row, final int col, final int currentSite) {
        if (!isSiteInRange(row, totalRows)) return;
        if (isWater(matrix[row+1][col])) return;

        int nextSouthSite = getUnionFindIndex(row+1, col);
        unionFind.connect(currentSite, nextSouthSite);
    }

    private void connectNextEastSiteIfItsLand(final int row, final int col, final int currentSite) {
        if (!isSiteInRange(col, totalCols)) return;
        if (isWater(matrix[row][col + 1])) return;

        int unionFindIndex = getUnionFindIndex(row, col + 1);
        unionFind.connect(currentSite, unionFindIndex);
    }

    private boolean isSiteInRange(final int siteId, final int maxSiteId) {
        return siteId < maxSiteId-1;
    }

    private boolean isWater(final int site) {
        return site == 0;
    }

    private int getUnionFindIndex(final int row, final int col) {
        return (row*totalCols) + col;
    }

    private Map<Integer, Integer> getMatrixRowAndColIndex(final int unionFindIndex) {
        // Todo: Will fail for n*m matrix
        int row = (int) Math.floor(unionFindIndex / totalRows);
        int col = unionFindIndex % totalRows;
        return new HashMap<Integer, Integer>() {{
            put(row, col);
        }};
    }

}
