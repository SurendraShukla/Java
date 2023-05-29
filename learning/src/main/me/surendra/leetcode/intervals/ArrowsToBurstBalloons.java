package me.surendra.leetcode.intervals;

import java.util.Arrays;
import java.util.LinkedList;


/**
 * @see <a href="https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/">Minimum Number of Arrows to Burst Balloons</a>
 *
 * Merge Interval
 *  If intervals are overlapping
 *  Merge interval with min end date of both overlapping intervals
 */
public class ArrowsToBurstBalloons {

    /*
        Time complexity: O(n log n) Sorting
        Space complexity: O(n) or O(log n) Sorting space
     */
    public int findMinArrowShotsByBalloonStartSort(final int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
            // We can't simply use the o1[1] - o2[1] trick, as this will cause an
            // integer overflow for very large or small values.
            if (o1[0] == o2[0]) return 0;
            if (o1[0] < o2[0]) return -1;
            return 1;
        });

        final LinkedList<int[]> mergedIntervals = new LinkedList<>();
        mergedIntervals.add(points[0]);

        for (int i = 1; i < points.length; i++) {
            final int[] previousInterval = mergedIntervals.getLast();
            final int[] currentInterval = points[i];
            // If previousInterval ends before currentInterval start
            if (previousInterval[1] < currentInterval[0]) {
                mergedIntervals.add(currentInterval);
                // If overlapping intervals
            } else {
                previousInterval[1] = Math.min(previousInterval[1], currentInterval[1]);
            }
        }
        return mergedIntervals.size();
    }


    /*
        Time complexity: O(n log n) Sorting
        Space complexity: O(n) or O(log n) Sorting space
     */
    public int findMinArrowShotsByBalloonEndSort(final int[][] points) {
        // sort by x_end
        Arrays.sort(points, (o1, o2) -> {
            // We can't simply use the o1[1] - o2[1] trick, as this will cause an
            // integer overflow for very large or small values.
            if (o1[1] == o2[1]) return 0;
            if (o1[1] < o2[1]) return -1;
            return 1;
        });

        int arrows = 1;
        int xStart;
        int xEnd;
        int firstEnd = points[0][1];
        for (int[] p: points) {
            xStart = p[0];
            xEnd = p[1];
            // if the current balloon starts after the end of another one,
            // one needs one more arrow
            if (firstEnd < xStart) {
                arrows++;
                firstEnd = xEnd;
            }
        }

        return arrows;
    }

}
