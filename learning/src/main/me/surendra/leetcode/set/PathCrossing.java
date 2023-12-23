package me.surendra.leetcode.set;


import me.surendra.learning.generics.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * @see <a href="https://leetcode.com/problems/path-crossing/">Path Crossing</a>
 */
public class PathCrossing {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public boolean isPathCrossing(final String path) {
        final Map<Character, Pair<Integer, Integer>> directionMap = new HashMap<>();
        directionMap.put('N', new Pair(1, 0));
        directionMap.put('S', new Pair(-1, 0));
        directionMap.put('E', new Pair(0, 1));
        directionMap.put('W', new Pair(0, -1));

        Pair<Integer, Integer> position = new Pair(0, 0);
        final Set<Pair<Integer, Integer>> seenPosition = new HashSet<>();
        seenPosition.add(position);

        for (char ch: path.toCharArray()) {
            final Pair<Integer, Integer> direction = directionMap.get(ch);
            position = new Pair(
                position.getKey() + direction.getKey(),
                position.getValue() + direction.getValue()
            );
            if (seenPosition.contains(position)) {
                return true;
            }
            seenPosition.add(position);
        }

        return false;
    }

}
