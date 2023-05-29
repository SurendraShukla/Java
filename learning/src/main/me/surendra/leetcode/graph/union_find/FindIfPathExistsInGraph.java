package me.surendra.leetcode.graph.union_find;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/**
 * @see <a href="https://leetcode.com/problems/find-if-path-exists-in-graph/">Find if Path Exists in Graph</a>
 */
public class FindIfPathExistsInGraph {

    /*
        Time Complexity - O(N + E) N is Node, E is Edge
        Space Complexity - O(N + E) N is Node, E is Edge
     */
    public boolean validPathUsingBfs(final int n, final int[][] edges,
                                     final int source, final int destination
    ) {
        final Map<Integer, List<Integer>> graph = createGraph(n, edges);
        if (!graph.containsKey(source) || !graph.containsKey(destination)) {
            return false;
        }
        final boolean[] visited = new boolean[n];
        return bfs(source, destination, graph, visited);
    }

    private Map<Integer, List<Integer>> createGraph(final int n, final int[][] edges) {
        final Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge: edges) {
            final int node1 = edge[0];
            final int node2 = edge[1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        return graph;
    }

    private boolean bfs(final int source, final int destination, final Map<Integer, List<Integer>> graph, final boolean[] visited) {
        final Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            final int currentNode = q.remove();
            if (currentNode == destination) {
                return true;
            }
            for (int nextNode: graph.get(currentNode)) {
                if (!visited[nextNode]) {
                    q.add(nextNode);
                    visited[nextNode] = true;
                }
            }
        }

        return false;
    }

    /*
        Time Complexity - O(N + E) N is Node, E is Edge
        Space Complexity - O(N + E) N is Node, E is Edge
     */
    public boolean validPathUsingUf(final int n, final int[][] edges,
                                    final int source, final int destination
    ) {
        final UnionFind uf = new UnionFind(n);
        for (int[] edge: edges) {
            uf.union(edge[0], edge[1]);
        }

        return uf.find(source) == uf.find(destination);
    }


}
