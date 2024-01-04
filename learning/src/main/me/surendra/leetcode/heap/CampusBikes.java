package me.surendra.leetcode.heap;


import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;


/**
 * @see <a href="https://leetcode.com/problems/campus-bikes">Campus Bikes</a>
 */
public class CampusBikes {

    // https://leetcode.com/problems/campus-bikes/discuss/305603/Java-Fully-Explained
    public int[] assignBikes(final int[][] workers, final int[][] bikes) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> {
            if (a1[0] == a2[0]) {
                if(a1[1] == a2[1]) {
                    return a1[2] - a2[2];
                }
                return a1[1] - a2[1];
            }
            return a1[0] - a2[0];
        });

        for (int i = 0; i < workers.length; i++) {
            final int[] workerPosition = workers[i];
            for (int j = 0; j < bikes.length; j++) {
                final int[] bikePosition = bikes[j];
                final int manhattanDistance = Math.abs(workerPosition[0] - bikePosition[0]) + Math.abs(workerPosition[1] - bikePosition[1]);
                pq.add(new int[]{manhattanDistance, i, j});
            }
        }

        // Initialize all values to false, to signify no bikes have been taken
        final Set<Integer> bikeAssigned = new HashSet<>();

        // Initialize all index to -1, to mark all the workers available
        final int[] workerBikeInfoArr = new int[workers.length];
        Arrays.fill(workerBikeInfoArr, -1);

        while (bikeAssigned.size() < workers.length) {
            final int[] bikePosition = pq.remove();
            final int worker = bikePosition[1];
            final int bike = bikePosition[2];

            if (workerBikeInfoArr[worker] == -1 && !bikeAssigned.contains(bike)) {
                // If both worker and bike are free, assign them to each other
                bikeAssigned.add(bike);
                workerBikeInfoArr[worker] = bike;
            }
        }

        return workerBikeInfoArr;
    }

}
