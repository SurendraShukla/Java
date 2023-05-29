package me.surendra.leetcode.trees.breadth_first_search;

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
    public int getMaxDepth(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        final int maxDepthOfLeftTreeNode = getMaxDepth(root.left);
        final int maxDepthOfRightTreeNode = getMaxDepth(root.right);
        return Math.max(maxDepthOfLeftTreeNode, maxDepthOfRightTreeNode) + 1;
    }


    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    int maxCount = 0;
    public int maxDepthCalculationAtLeafNode(final TreeNode root) {
        populateMaxDepth(root, 0);
        return maxCount;
    }

    private void populateMaxDepth(final TreeNode treeNode, final int level) {
        if (treeNode == null) {
            maxCount = Math.max(level, maxCount);
            return;
        }
        populateMaxDepth(treeNode.left, level + 1);
        populateMaxDepth(treeNode.right, level + 1);
    }

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
                if (treeNode.left != null) {
                    treeNodes.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodes.add(treeNode.right);
                }
            }
        }
        return level;
    }

}
