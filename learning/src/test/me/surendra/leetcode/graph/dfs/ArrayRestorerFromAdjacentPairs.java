package me.surendra.leetcode.graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/">Restore the Array From Adjacent Pairs</a>
 */
public class ArrayRestorerFromAdjacentPairs {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public int[] restoreArray(final int[][] adjacentPairs) {
        final Map<Integer, List<Integer>> elementMap = new HashMap<>();
        for (int[] adjacentPair: adjacentPairs) {
            final int element1 = adjacentPair[0];
            final int element2 = adjacentPair[1];
            elementMap.putIfAbsent(element1, new ArrayList<>());
            elementMap.putIfAbsent(element2, new ArrayList<>());
            elementMap.get(element1).add(element2);
            elementMap.get(element2).add(element1);
        }


        final Queue<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, List<Integer>> map: elementMap.entrySet()) {
            if (map.getValue().size() == 1) {
                q.add(map.getKey());
                break;
            }
        }

        int idx = 0;
        int prev = Integer.MAX_VALUE;
        final int[] result = new int[elementMap.size()];

        while (!q.isEmpty()) {
            final int element = q.remove();
            result[idx++] = element;
            for (Integer nextElement: elementMap.get(element)) {
                if (nextElement != prev) {
                    q.add(nextElement);
                }
            }
            prev = element;
        }
        return result;
    }

}
