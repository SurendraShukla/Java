package me.surendra.leetcode.dynamic_programming;


import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/min-cost-climbing-stairs/">Min Cost Climbing Stairs</a>
 */
public class MinCostClimbingStairsCostFinder {


    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int minCostClimbingStairsUsingTabulation(final int[] cost) {
        for (int i = cost.length - 3; i >= 0; i--) {
            cost[i] = cost[i] + Math.min(cost[i + 1], cost[i + 2]);
        }
        return Math.min(cost[0], cost[1]);
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int minCostClimbingStairsUsingConstantSpace(final int[] cost) {
        int step1Cost = cost[0];
        int step2Cost = cost[1];
        for (int i = 2; i < cost.length; i++) {
            final int currentStepCost = Math.min(cost[i] + step1Cost, cost[i] + step2Cost);
            step1Cost = step2Cost;
            step2Cost = currentStepCost;
        }
        return Math.min(step1Cost, step2Cost);
    }


    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    int[] minCost;
    public int minCostClimbingStairsUsingRecursion(final int[] cost) {
        minCost = new int[cost.length];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCostClimbingStairs(cost, 0);
        return Math.min(minCost[0], minCost[1]);
    }

    public int minCostClimbingStairs(final int[] cost, final int i) {
        if (i >= minCost.length) {
            return 0;
        }
        if (minCost[i] != Integer.MAX_VALUE) {
            return minCost[i];
        }
        minCost[i] = cost[i] + Math.min(
            minCostClimbingStairs(cost, i + 1),
            minCostClimbingStairs(cost, i + 2)
        );
        return  minCost[i];
    }

}
