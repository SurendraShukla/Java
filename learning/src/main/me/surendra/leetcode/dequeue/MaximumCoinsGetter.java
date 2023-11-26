package me.surendra.leetcode.dequeue;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/maximum-number-of-coins-you-can-get/">Maximum Number of Coins You Can Get</a>
 */
public class MaximumCoinsGetter {

    /*
        Time Complexity - O(n log n)
        Space Complexity - O(n)
     */
    public int maxCoins(final int[] piles) {
        Arrays.sort(piles);
        final ArrayDeque<Integer> queue = new ArrayDeque();
        for (int num : piles) {
            queue.addLast(num);
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            queue.removeLast(); // alice
            ans += queue.removeLast(); // us
            queue.removeFirst(); // bob
        }

        return ans;
    }

}
