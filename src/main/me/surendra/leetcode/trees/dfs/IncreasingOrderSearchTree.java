package me.surendra.leetcode.trees.dfs;

import me.surendra.leetcode.trees.TreeNode;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/increasing-order-search-tree/">Increasing Order Search Tree</a>
 */
public class IncreasingOrderSearchTree {

    final Stack<Integer> integerStack = new Stack<>();

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public TreeNode increasingBST(TreeNode root) {
        populateStack(root);

        TreeNode treeNode = null;
        while(!integerStack.isEmpty()) {
            final Integer integer = integerStack.pop();
            treeNode = new TreeNode(integer, null, treeNode);
        }

        return treeNode;
    }

    private void populateStack(final TreeNode root) {
        if (root == null) {
            return;
        }
        populateStack(root.left);
        integerStack.push(root.val);
        populateStack(root.right);
    }


    /*
        Sentinel
     */
    TreeNode cur;
    public TreeNode increasingBSTUsingDummyNode(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }


}
