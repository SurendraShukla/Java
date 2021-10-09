package me.surendra.leetcode.trees.binary_search_tree.bfs;

import me.surendra.leetcode.trees.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/balanced-binary-tree/">Balanced Binary Tree</a>
 */
public class BalancedBinaryTree {

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int depthLeft = getDepth(root.left, 1);
        int depthRight = getDepth(root.right, 1);
        return (Math.abs(depthLeft - depthRight) < 2) && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(final TreeNode treeNode, final int level) {
        if (treeNode == null) {
            return level;
        }
        return Math.max(
            getDepth(treeNode.left, level+1),
            getDepth(treeNode.right, level+1)
        );
    }

}
