package me.surendra.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.com/problems/cousins-in-binary-tree/">Cousins in Binary Tree</a>
 */
public class CousinsFinder {

    boolean cousinFound = false;
    int xParent;
    int yParent;
    int xLevel = 0;
    int yLevel = 0;
    int x;
    int y;

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        int level = 0;
        this.x = x;
        this.y = y;

        final Queue<TreeNode> integerQueue = new LinkedList<>();
        integerQueue.add(root);

        while(!integerQueue.isEmpty()) {
            level++;
            final int size = integerQueue.size();
            for (int i = 0; i < size; i++) {
                final TreeNode treeNode = integerQueue.poll();

                if (treeNode.left != null) {
                    populate(treeNode.left.val, level, i);
                    integerQueue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    populate(treeNode.right.val, level, i);
                    integerQueue.add(treeNode.right);
                }
            }

            if (cousinFound) {
                if (xParent == yParent) {
                    return false;
                }
                if (xLevel == yLevel) {
                    return true;
                }
                return false;
            }

        }

        return false;
    }

    private void populate(final int val, final int level, final int parent) {
        if (val == x) {
            cousinFound = true;
            xLevel = level;
            xParent = parent;
            return;
        }
        if (val == y) {
            cousinFound = true;
            yLevel = level;
            yParent = parent;
        }
    }

}
