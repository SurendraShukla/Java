package me.surendra.leetcode.trees.depth_first_search.pre_order_traversal;


import me.surendra.leetcode.trees.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/construct-string-from-binary-tree/">Construct String from Binary Tree</a>
 */
public class StringConstructor {

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    final StringBuilder stringBuilder = new StringBuilder();
    public String tree2str(TreeNode root) {
        populateString(root);
        return stringBuilder.toString();
    }

    private void populateString(final TreeNode root) {
        if (root == null) {
            return;
        }
        stringBuilder.append(root.val);
        if (root.left == null && root.right ==null) {
            return;
        }
        stringBuilder.append("(");
        populateString(root.left);
        stringBuilder.append(")");
        if (root.right != null) {
            stringBuilder.append("(");
            populateString(root.right);
            stringBuilder.append(")");
        }
    }

}
