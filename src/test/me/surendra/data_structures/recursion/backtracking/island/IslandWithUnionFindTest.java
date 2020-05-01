package me.surendra.data_structures.recursion.backtracking.island;

import org.junit.Test;

import java.util.List;
import java.util.Map;


public class IslandWithUnionFindTest {

    @Test
    public void shouldReturn0ForIslandWithAll0sInMatrix() {
        int matrix[][] = {
            {1, 0},
            {0, 1}
        };

        printTimeTakenToExecute(matrix);
    }

    @Test
    public void shouldReturn5() {
        int matrix[][] = {
            {1, 1, 0, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 0, 1, 1},
            {0, 1, 0, 1, 1}
        };

        printTimeTakenToExecute(matrix);
    }

    @Test
    public void shouldReturnFor15x15() {
        int matrix[][] = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        printTimeTakenToExecute(matrix);
    }

    private void printTimeTakenToExecute(final int[][] matrix) {
        final long startTime = System.nanoTime();
        final IslandWithUnionFind islandWithUnionFind = new IslandWithUnionFind(matrix);
        int maxConnectedPointsCount = islandWithUnionFind.getMaxConnectedPointsCount();
        final long endTime = System.nanoTime();
        System.out.println(maxConnectedPointsCount);
        System.out.println("===== Time taken in nano seconds: [" + (endTime-startTime) + "] =====");

        final long startTime1 = System.nanoTime();
        final Map<Integer, List<Map<Integer, Integer>>> maxConnectedLandLen = islandWithUnionFind.getAllConnectedLand();
        System.out.println(maxConnectedLandLen);
        final long endTime1 = System.nanoTime();
        System.out.println("===== Time taken in nano seconds: [" + (endTime1-startTime1) + "] =====");

    }

}
