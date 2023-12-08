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
    final StringBuilder sb = new StringBuilder();
    public String tree2str(final TreeNode root) {
        populate(root);
        return sb.toString();
    }

    void populate(final TreeNode root) {
        if (root == null) {
            return;
        }

        sb.append(root.val);
        if (root.left != null) {
            sb.append("(");
            populate(root.left);
            sb.append(")");
        }

        if (root.right != null) {
            if (root.left == null) {
                sb.append("()");
            }
            sb.append("(");
            populate(root.right);
            sb.append(")");
        }
    }

}
