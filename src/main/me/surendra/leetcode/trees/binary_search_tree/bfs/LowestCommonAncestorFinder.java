package me.surendra.leetcode.trees.binary_search_tree.bfs;

import me.surendra.leetcode.trees.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">Lowest Common Ancestor of a Binary Search Tree</a>
 */
public class LowestCommonAncestorFinder {

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public TreeNode lowestCommonAncestorComparingEqualValAlso(final TreeNode root, final TreeNode p, final TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode result = null;
        if (root.val >= p.val && root.val >= q.val) {
            result = lowestCommonAncestorComparingEqualValAlso(root.left, p, q);
        } else if (root.val <= p.val && root.val <= q.val) {
            result = lowestCommonAncestorComparingEqualValAlso(root.right, p, q);
        }
        return (result == null) ? root : result;
    }

}
