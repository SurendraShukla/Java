package me.surendra.leetcode.trees.breadth_first_search;

import me.surendra.leetcode.trees.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/univalued-binary-tree/">Univalued Binary Tree</a>
 */
public class UniValTreeValidator {

    /*
        Time complexity: O(n) N is the number of nodes
        Space complexity: O(H) H is the height
     */
    public boolean isUnivalTree(TreeNode root) {
        return isUniValTree(root, root.val);
    }

    private boolean isUniValTree(final TreeNode root, final int val) {
        if (root == null) {
            return true;
        }
        if ((root.left != null && root.left.val != val) ||
            (root.right != null && root.right.val != val)) {
            return false;
        }
        return isUniValTree(root.left, root.val) && isUniValTree(root.right, root.val);
    }

}
