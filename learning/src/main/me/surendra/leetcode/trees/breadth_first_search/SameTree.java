package me.surendra.leetcode.trees.breadth_first_search;

import me.surendra.leetcode.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.com/problems/same-tree/">Same Tree</a>
 */
public class SameTree {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public boolean isSameTree(final TreeNode left, final TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSameTree(left.left, right.left) && isSameTree(left.right, right.right);
    }

    class Solution {
        public int minKnightMoves(final int x, final  int y) {
            int level = 0;
            final int[] initalCordinates = {0, 0};

            final Queue<int[]> q = new LinkedList<>();
            q.add(initalCordinates);

            final boolean[][] visited = new boolean[607][607];
            // visited.add(initalCordinates);

            final int[] xAxies = {2, 2, -2, -2, 1, -1, 1, -2};
            final int[] yAxies = {1, -1, 1, -1, 2, 2, -2, -2};

            while (!q.isEmpty()) {
                final int size = q.size();
                for (int i = 0; i < size; i++) {
                    final int[] cordinate = q.remove();
                    final int currentX = cordinate[0];
                    final int currentY = cordinate[1];

                    if (x == currentX && y == currentY) {
                        return level;
                    }
                    for (int d = 0; d < xAxies.length; d++) {
                        final int nextX = currentX + xAxies[d];
                        final int nextY = currentY + yAxies[d];
                        final int[] nextCordinates = {nextX, nextY};
                        // align the coordinate to the bitmap
                        if (visited[nextX + 302][nextY + 302]) {
                            continue;
                        }
                        visited[nextX + 302][nextY + 302] = true;
                        q.add(nextCordinates);
                    }
                }
                level++;
            }

            return -1;
        }
    }

}

