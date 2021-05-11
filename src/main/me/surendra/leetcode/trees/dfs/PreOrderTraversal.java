package me.surendra.leetcode.trees.dfs;


import me.surendra.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 1. Visit the root first.
 * 2. Traverse the left subtree
 * 3. Traverse the right subtree
 *
 * Top-down
 */
public class PreOrderTraversal {

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        final List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val); // Visit the root
        list.addAll(preorderTraversal(root.left)); // Traverse the left subtree
        list.addAll(preorderTraversal(root.right)); // Traverse the right subtree
        return list;
    }

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public List<Integer> preorderTraversalUsingStack(TreeNode root) {
        final List<Integer> outputList = new ArrayList<>();
        if (root == null) {
            return outputList;
        }

        final Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(root);
        TreeNode current;
        while(!treeNodeStack.empty()) {
            current = treeNodeStack.pop();          // visit the root
            outputList.add(current.val);
            if(current.right != null) {
                treeNodeStack.push(current.right);  // push right child to stack if it is not null
            }
            if(current.left != null) {
                treeNodeStack.push(current.left);  // push left child to stack if it is not null
            }
        }
        return outputList;
    }

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    final List<Integer> integerList = new ArrayList<>();
    public List<Integer> preorderTraversalUsingListAsClassProperty(TreeNode root) {
        if (root == null) return integerList;
        integerList.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return integerList;
    }

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public List<Integer> preorderTraversalUsingListAsMethodArgument(TreeNode root) {
        final List<Integer> integers = new ArrayList<>();
        postorderTraversal(root, integers);
        return integers;
    }

    private boolean postorderTraversal(final TreeNode root, final List<Integer> integers) {
        if (root == null) {
            return true;
        }
        integers.add(root.val);
        integers.addAll(preorderTraversal(root.left));
        integers.addAll(preorderTraversal(root.right));
        return false;
    }

}
