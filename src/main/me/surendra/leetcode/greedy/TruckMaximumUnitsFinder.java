package me.surendra.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * @see <a href="https://leetcode.com/problems/maximum-units-on-a-truck/">Maximum Units on a Truck</a>
 */
public class TruckMaximumUnitsFinder {
    final Comparator<int[]> comparatorToReverse = (a, b) -> b[1] - a[1];

    /*
        Time Complexity - O(n log n)
        Space Complexity - O(1)
     */
    public int maximumUnitsUsingRemainingTruckSize(final int[][] boxTypes, final int truckSize) {
        //  This comparator can overflow
        Arrays.sort(boxTypes, comparatorToReverse);

        int maximumNumberOfBoxes = 0;
        int remainingTruckSize = truckSize;
        for (int[] boxType: boxTypes) {
            final int numberOfBoxes = Math.min(boxType[0], remainingTruckSize);
            maximumNumberOfBoxes += numberOfBoxes * boxType[1];
            remainingTruckSize -= numberOfBoxes;

            if (remainingTruckSize == 0) {
                break;
            }
        }
        return maximumNumberOfBoxes;
    }

    /*
        Time Complexity - O(n log n)
        Space Complexity - O(1)
     */
    public int maximumUnitsSelfThought(final int[][] boxTypes, final int truckSize) {
        Arrays.sort(boxTypes, comparatorToReverse);

        int maximumNumberOfBoxes = 0;
        int currentTruckSize = 0;
        for (int[] boxType: boxTypes) {
            int numberOfBoxType = boxType[0];
            while (numberOfBoxType != 0) {
                if ( (currentTruckSize + numberOfBoxType) > truckSize) {
                    numberOfBoxType--;
                    continue;
                }
                currentTruckSize += numberOfBoxType;
                maximumNumberOfBoxes += numberOfBoxType * boxType[1];
                numberOfBoxType = 0;

                if (currentTruckSize >= truckSize) {
                    return maximumNumberOfBoxes;
                }
            }
        }
        return maximumNumberOfBoxes;
    }

    /*
        Time Complexity - O(n log n)
        Space Complexity - O(n log n)
     */
    public int maximumUnitsUsingMaximumHeap(final int[][] boxTypes, final int truckSize) {
        final PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(comparatorToReverse);
        priorityQueue.addAll(Arrays.asList(boxTypes));

        int maximumNumberOfBoxes = 0;
        int remainingTruckSize = truckSize;
        while (!priorityQueue.isEmpty()) {
            final int[] box = priorityQueue.remove();
            final int numberOfBoxes = Math.min(box[0], remainingTruckSize);
            maximumNumberOfBoxes += numberOfBoxes * box[1];
            remainingTruckSize -= numberOfBoxes;

            if (remainingTruckSize == 0) {
                break;
            }
        }
        return maximumNumberOfBoxes;
    }

}
