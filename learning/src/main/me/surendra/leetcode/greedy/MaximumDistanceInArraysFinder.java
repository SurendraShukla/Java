package me.surendra.leetcode.greedy;

import java.util.Collections;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/maximum-distance-in-arrays/">Maximum Distance in Arrays</a>
 */
public class MaximumDistanceInArraysFinder {

    /*
        Time Complexity - O(n long n)
        Space Complexity - O(1)
     */
    public int maxDistance(final List<List<Integer>> arrays) {

        Collections.sort(arrays, (a, b) -> a.get(0) - b.get(0));

        final int firstVal = arrays.get(0).get(0);
        int ans = arrays.get(0).get(arrays.get(0).size() - 1) - arrays.get(1).get(0);

        for (int j = 1; j < arrays.size(); j++) {
            final int diff = arrays.get(j).get(arrays.get(j).size() - 1) - firstVal;
            ans = Math.max(ans, diff);
        }
        return ans;
    }

}
