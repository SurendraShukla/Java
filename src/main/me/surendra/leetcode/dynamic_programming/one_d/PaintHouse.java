package me.surendra.leetcode.dynamic_programming.one_d;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/paint-house/">Paint House</a>
 */
public class PaintHouse {

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    final Map<String, Integer> memo = new HashMap<>();
    int[][] housePaintCosts;
    public int minCost(final int[][] costs) {
        this.housePaintCosts = costs;
        return minCost(0, -1);
    }

    int minCost(final int houseIdx, final int colorUsedIdx) {
        final String key = houseIdx + "_" + colorUsedIdx;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int minCost = Integer.MAX_VALUE;
        final int[] houseColorCost = housePaintCosts[houseIdx];
        for (int i = 0; i < houseColorCost.length; i++) {
            if (i == colorUsedIdx) {
                continue;
            }
            int cost = houseColorCost[i];
            if (houseIdx + 1 < housePaintCosts.length) {
                cost += minCost(houseIdx + 1, i);
            }
            minCost = Math.min(cost, minCost);
        }
        memo.put(key, minCost);
        return minCost;
    }

}
