package me.surendra.leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/discuss/interview-question/786821/indeed-oa-2020-parents-and-children-graph">Parents and Children (Graph)</a>
 */
public class FindCommonParent {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public boolean hasCommonAncestor(final int[][] parentChildPairs, final int child1, final int child2) {

        final Map<Integer, Set<Integer>> childAndItsParents = new HashMap<>();
        for (final int[] parentChildPair : parentChildPairs) {
            final int parent = parentChildPair[0];
            final int child = parentChildPair[1];

            Set<Integer> parents;
            if(childAndItsParents.containsKey(child)) {
                parents = childAndItsParents.get(child);
            }else{
                parents = new HashSet<>();
            }
            parents.add(parent);
            childAndItsParents.put(child, parents);
        }

        final Queue<Integer> integerQueueForChild1 = new LinkedList<>();
        integerQueueForChild1.add(child1);
        final Set<Integer> parentHierarchy = new HashSet<>();
        while (!integerQueueForChild1.isEmpty()) {
            int queueSize = integerQueueForChild1.size();
            for (int i = 0; i < queueSize; i++) {
                final Integer child = integerQueueForChild1.poll();
                final Set<Integer> parents = childAndItsParents.getOrDefault(child, new HashSet<>());
                for (final Integer parent : parents) {
                    parentHierarchy.add(parent);
                    integerQueueForChild1.add(parent);
                }
            }
        }

        final Queue<Integer> integerQueueForChild2 = new LinkedList<>();
        integerQueueForChild2.add(child2);
        while (!integerQueueForChild2.isEmpty()) {
            int queueSize = integerQueueForChild2.size();
            for (int i = 0; i < queueSize; i++) {
                final Integer child = integerQueueForChild2.poll();
                final Set<Integer> parents = childAndItsParents.getOrDefault(child, new HashSet<>());
                for (final Integer parent : parents) {
                    if (parentHierarchy.contains(parent)) {
                        return true;
                    }
                    integerQueueForChild2.add(parent);
                }
            }
        }
        return false;
    }

}
