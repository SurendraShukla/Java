package me.surendra.leetcode.trees.binary_search_tree.in_order_traversal;

import me.surendra.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * @see <a href="https://leetcode.com/problems/increasing-order-search-tree/">Increasing Order Search Tree</a>
 */
public class IncreasingOrderSearchTree {

    /*
        Time Complexity - O(n) - N is number of nodes in tree
        Space Complexity - O(H) - H is tree height
     */
    TreeNode dummyNode;
    public TreeNode increasingBstTraversalWithRelinking(TreeNode root) {
        final TreeNode returnNode = new TreeNode(0);
        dummyNode = returnNode;
        inOrderTraversalWithRelinking(root);
        return  returnNode.right;
    }

    private void inOrderTraversalWithRelinking(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversalWithRelinking(root.left);
        root.left = null;
        dummyNode.right = root;
        dummyNode = dummyNode.right;
        inOrderTraversalWithRelinking(root.right);
    }

    /*
        Time Complexity - O(n) - N is number of nodes in tree
        Space Complexity - O(H) - H is tree height
     */
    public TreeNode increasingBstTraversalWithIterationWithDummyNode(TreeNode root) {
        final List<Integer> valList = new ArrayList();
        inOrderTraversalWithIteration(root, valList);

        final TreeNode returnNode = new TreeNode(0);
        TreeNode dummyNode = returnNode;
        for (final Integer integer : valList) {
            dummyNode.right = new TreeNode(integer);
            dummyNode = dummyNode.right;
        }
        return  returnNode.right;
    }

    private void inOrderTraversalWithIteration(final TreeNode root, final List<Integer> valList) {
        if (root == null) {
            return;
        }
        inOrderTraversalWithIteration(root.left, valList);
        valList.add(root.val);
        inOrderTraversalWithIteration(root.right, valList);
    }


    /*
        Time Complexity - O(n) - N is number of nodes in tree
        Space Complexity - O(H) - H is tree height
     */
    public TreeNode increasingBstTraversalWithIterationWithoutDummyNode(TreeNode root) {
        final Stack<Integer> integerStack = new Stack<>();
        inOrderTraversalWithIteration(root, integerStack);

        TreeNode returnNode = new TreeNode(integerStack.pop());
        while(!integerStack.isEmpty()) {
            returnNode = new TreeNode(integerStack.pop(), null, returnNode);
        }
        return  returnNode;
    }

    private void inOrderTraversalWithIteration(final TreeNode root, final Stack<Integer> integerStack) {
        if (root == null) {
            return;
        }
        inOrderTraversalWithIteration(root.left, integerStack);
        integerStack.push(root.val);
        inOrderTraversalWithIteration(root.right, integerStack);
    }


}
