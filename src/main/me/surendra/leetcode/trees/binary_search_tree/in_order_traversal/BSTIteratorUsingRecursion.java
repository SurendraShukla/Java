package me.surendra.leetcode.trees.binary_search_tree.in_order_traversal;

import me.surendra.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


interface BSTIterator {
    int next();
    boolean hasNext();
}

/**
 * @see <a href="https://leetcode.com/problems/binary-search-tree-iterator/">Binary Search Tree Iterator</a>
 */
public class BSTIteratorUsingRecursion implements BSTIterator {

    /*
            Time complexity : O(n) N is nodes in the tree
            Space complexity: O(n) N is nodes in the tree
         */
    private final List<Integer> list = new ArrayList<>();
    int i=0;
    int size;
    public BSTIteratorUsingRecursion(TreeNode root) {
        populate(root);
        size = list.size();
    }

    void populate(TreeNode root) {
        if (root == null) {
            return;
        }
        populate(root.left);
        list.add(root.val);
        populate(root.right);
    }

    @Override
    public int next() {
        return list.get(i++);
    }

    @Override
    public boolean hasNext() {
        return i < size;
    }

}

class BSTIteratorUsingIteration implements BSTIterator {

    /*
            Time complexity : O(h) H is height of the tree
            Space complexity: O(n) N is nodes in the tree
         */
    private final Stack<TreeNode> stack = new Stack<>();
    public BSTIteratorUsingIteration(TreeNode root) {
        populateLeftNodes(root);
    }

    void populateLeftNodes(TreeNode root) {
        if (root == null) {
            return;
        }
        stack.push(root);
        populateLeftNodes(root.left);
    }

    @Override
    public int next() {
        TreeNode treeNode = stack.pop();
        if (treeNode.right != null) {
            populateLeftNodes(treeNode.right);
        }
        return treeNode.val;
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

}
