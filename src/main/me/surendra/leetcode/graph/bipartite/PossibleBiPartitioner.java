package me.surendra.leetcode.graph.bipartite;

import me.surendra.leetcode.graph.union_find.UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.com/problems/">Possible Bipartition</a>
 */
public class PossibleBiPartitioner {

    /*
        Time Complexity - O(N + E) N is Node/People, E is Edge/Dislikes
        Space Complexity - O(N + E) N is Node/People, E is Edge/Dislikes
     */
    public boolean possibleBiPartitionUsingBFS(final int n, final int[][] dislikes) {
        final Map<Integer, List<Integer>> graph = createGraph(n, dislikes);

        final Boolean[] colored = new Boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (colored[i] == null) {
                if (isInSameGroupUsingBfs(i, graph, colored)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isInSameGroupUsingBfs(final int i, final Map<Integer, List<Integer>> graph, final Boolean[] colored) {
        final Queue<Integer> q = new LinkedList<>();
        q.add(i);
        colored[i] = true;

        while (!q.isEmpty()) {
            final int currentNode = q.remove();
            for (int disLikeNode: graph.get(currentNode)) {
                if (colored[disLikeNode] == null) {
                    q.add(disLikeNode);
                    colored[disLikeNode] = !colored[currentNode];
                } else if (colored[disLikeNode] == colored[currentNode]) {
                    return true;
                }
            }
        }
        return false;
    }

    private Map<Integer, List<Integer>> createGraph(final int n, final int[][] dislikes) {
        final Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] nodeConnection: dislikes) {
            final int node1 = nodeConnection[0];
            final int node2 = nodeConnection[1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        return graph;
    }


    /*
        Time Complexity - O(N + E) N is Node/People, E is Edge/Dislikes
        Space Complexity - O(N + E) N is Node/People, E is Edge/Dislikes
     */
    public boolean possibleBiPartitionUsingUf(final int n, final int[][] dislikes) {
        final Map<Integer, List<Integer>> graph = createGraph(n, dislikes);

        final UnionFind uf = new UnionFind(n + 1);
        for (int currentNode = 1; currentNode <= n; currentNode++) {
            if (!graph.containsKey(currentNode)) {
                continue;
            }
            final List<Integer> disLikeList = graph.get(currentNode);
            if (disLikeList.isEmpty()) {
                continue;
            }
            final int disLikeNode = disLikeList.get(0);
            for (int nextNode: disLikeList) {
                if (uf.find(currentNode) == uf.find(nextNode)) {
                    return false;
                }
                uf.union(disLikeNode, nextNode);
            }
        }

        return true;
    }

}
