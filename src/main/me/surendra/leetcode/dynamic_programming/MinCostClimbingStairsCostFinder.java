package me.surendra.leetcode.dynamic_programming;


/**
 * @see <a href="https://leetcode.com/problems/min-cost-climbing-stairs/">Min Cost Climbing Stairs</a>
 */
public class MinCostClimbingStairsCostFinder {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int minCostClimbingStairs(int[] cost) {
        int step1Cost = cost[0];
        int step2Cost = cost[1];
        for (int i=2; i<cost.length; i++) {
            int currentStepCost = Math.min(cost[i] + step1Cost, cost[i] + step2Cost);
            step1Cost = step2Cost;
            step2Cost = currentStepCost;
        }
        return Math.min(step1Cost, step2Cost);
    }

}
