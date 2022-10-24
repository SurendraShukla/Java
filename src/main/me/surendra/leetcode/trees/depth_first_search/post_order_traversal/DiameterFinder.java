package me.surendra.leetcode.trees.depth_first_search.post_order_traversal;


import me.surendra.leetcode.trees.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/diameter-of-binary-tree/">Diameter of Binary Tree</a>
 */
public class DiameterFinder {

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    int max = 0;
    public int diameterOfBinaryTree(final TreeNode root) {
        diameterFinder(root);
        return max;
    }

    private int diameterFinder(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        final int leftEdges = diameterFinder(root.left);
        final int rightEdges = diameterFinder(root.right);

        max = Math.max(max, leftEdges + rightEdges);
        return Math.max(rightEdges, leftEdges) + 1;
    }

}
