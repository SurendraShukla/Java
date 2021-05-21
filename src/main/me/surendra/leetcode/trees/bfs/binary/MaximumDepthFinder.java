package me.surendra.leetcode.trees.bfs.binary;

import me.surendra.leetcode.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">Maximum Depth of Binary Tree</a>
 */
public class MaximumDepthFinder {

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public int getMaxDepthUsingIteration(final TreeNode root) {
        int level = 0;
        if (root == null) {
            return level;
        }
        final Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);

        while (!treeNodes.isEmpty()) {
            level++;
            final int queueSize = treeNodes.size();
            for (int i = 0; i < queueSize; i++) {
                final TreeNode treeNode = treeNodes.remove();
                if(treeNode.left != null) {
                    treeNodes.add(treeNode.left);
                }
                if(treeNode.right != null) {
                    treeNodes.add(treeNode.right);
                }
            }
        }
        return level;
    }

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public int getMaxDepthUsingRecursion(final TreeNode root) {
        return getMaxDepth(root, 0);
    }

    private int getMaxDepth(final TreeNode treeNode, final int level) {
        if(treeNode == null) {
            return level;
        }
        int maxDepthOfLeftTreeNode = getMaxDepth(treeNode.left, level + 1);
        int maxDepthOfRightTreeNode = getMaxDepth(treeNode.right, level+1);
        return Math.max(maxDepthOfLeftTreeNode, maxDepthOfRightTreeNode);
    }
}
