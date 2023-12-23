package me.surendra.leetcode.trees;


/**
 * @see <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/">Lowest Common Ancestor of a Binary Tree II</a>
 */
public class LowestCommonAncestorBinaryTreeII {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q) {
        final TreeNode ans = lca(root, p, q);
        if (ans == p) // check if q is in the subtree of p
            return dfs(p, q) ? p : null;
        else if (ans == q) // check if p is in the subtree of q
            return dfs(q, p) ? q : null;
        return ans;
    }

    private TreeNode lca(final TreeNode node, final TreeNode p, final TreeNode q) {
        if (node == null || node == p || node == q)
            return node;
        final TreeNode left = lca(node.left, p, q);
        final TreeNode right = lca(node.right, p, q);
        if (left != null && right != null)
            return node;
        else if (left != null)
            return left;
        else
            return right;
    }

    private boolean dfs(final TreeNode node, final TreeNode target) {
        if (node == target)
            return true;
        if (node == null)
            return false;
        return dfs(node.left, target) || dfs(node.right, target);
    }

}
