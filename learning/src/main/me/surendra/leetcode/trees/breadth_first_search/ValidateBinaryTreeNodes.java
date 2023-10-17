package me.surendra.leetcode.trees.breadth_first_search;


import java.util.LinkedList;
import java.util.Queue;


/**
 * @see <a href="https://leetcode.com/problems/validate-binary-tree-nodes/">Validate Binary Tree Nodes</a>
 */
public class ValidateBinaryTreeNodes {

    /*
        Time Complexity - O(n)
        Space Complexity- O(n)
     */
    public boolean validateBinaryTreeNodes(final int n, final int[] leftChild, final int[] rightChild) {
        final int[] inwards = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                inwards[leftChild[i]]++;
            }
            if (rightChild[i] != -1) {
                inwards[rightChild[i]]++;
            }
        }

        boolean rootFound = false;
        int rootNode = 0;
        for (int i = 0; i < n; i++) {
            if (inwards[i] == 0) {
                if (rootFound) {
                    return false;
                }
                rootNode = i;
                rootFound = true;
            }
        }

        final boolean[] visited = new boolean[n];
        visited[rootNode] = true;

        final Queue<Integer> q = new LinkedList<>();
        q.add(rootNode);

        while (!q.isEmpty()) {
            final int size = q.size();
            for (int i = 0; i < size; i++) {
                final int node = q.remove();

                final int leftNode = leftChild[node];
                if (leftNode != -1) {
                    if (visited[leftNode]) {
                        return false;
                    }
                    q.add(leftNode);
                    visited[leftNode] = true;
                }

                final int rightNode = rightChild[node];
                if (rightNode != -1) {
                    if (visited[rightNode]) {
                        return false;
                    }
                    q.add(rightNode);
                    visited[rightNode] = true;
                }
            }
        }

        for (boolean nodeVisited: visited) {
            if (!nodeVisited) {
                return false;
            }
        }

        return true;
    }

}
