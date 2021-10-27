package me.surendra.leetcode.trees.depth_first_search;

import me.surendra.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * @see <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list/">Flatten Binary Tree to Linked List</a>
 */
public class BinaryTreeFlatter {

    /*
        Time complexity : O(n)
        Space complexity: O(1)
     */
    TreeNode previousNode = null;
    public void flattenUsingDummyNode(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root);
    }

    private void traversal(final TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.right);
        if (root.left != null) {
            traversal(root.left);
        }
        root.left = null;
        root.right= previousNode;
        previousNode = root;
    }

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public void flattenUsingList(TreeNode root) {
        final List<TreeNode> integerList = new ArrayList<>();
        if (root == null) {
            return;
        }

        traversal(root, integerList);

        TreeNode prevNode = integerList.get(0);
        for (int i = 1; i < integerList.size(); i++) {
            TreeNode treeNode = integerList.get(i);
            treeNode.left = null;
            treeNode.right= prevNode;
            prevNode = treeNode;
        }
    }

    private void traversal(final TreeNode root, final List<TreeNode> integerList) {
        if (root == null) {
            return;
        }

        traversal(root.right, integerList);

        if (root.left != null) {
            traversal(root.left, integerList);
        }
        integerList.add(root);
    }

}
