package me.surendra.leetcode.backtracking;


/**
 * @see <a href="https://leetcode.com/problems/campus-bikes-ii/">Campus Bikes II</a>
 */
public class CampusBikesII {

    /*
        Time Complexity - O( M! / (M-N)! ) N is the number of workers, and MM is the number of bikes.
        Space Complexity - O( N + M)
     */
    private int[][] bikes;
    private int[][] workers;
    private int shortestDistanceSum;
    private boolean[] visitedBikes;

    public int assignBikes(final int[][] workers, final int[][] bikes) {
        this.bikes = bikes;
        this.workers = workers;
        shortestDistanceSum = Integer.MAX_VALUE;
        visitedBikes = new boolean[bikes.length];

        populate(0, 0);

        return shortestDistanceSum;
    }

    private void populate(final int workerIdx, final int currentDistanceSum) {
        if (workerIdx >= workers.length) {
            shortestDistanceSum = Math.min(shortestDistanceSum, currentDistanceSum);
            return;
        }
        if (currentDistanceSum >= shortestDistanceSum) {
            return;
        }
        for (int bikeIndex = 0; bikeIndex < bikes.length; bikeIndex++) {
            if (visitedBikes[bikeIndex]) {
                continue;
            }
            visitedBikes[bikeIndex] = true;
            populate(workerIdx + 1, currentDistanceSum + findDistance(workers[workerIdx], bikes[bikeIndex]));
            visitedBikes[bikeIndex] = false;
        }
    }

    private int findDistance(final int[] worker, final int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

}
