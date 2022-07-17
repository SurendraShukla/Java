package me.surendra.leetcode.trees.n_ary_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


/**
 * @see <a href="https://leetcode.com/problems/n-ary-tree-preorder-traversal/">N-ary Tree Preorder Traversal</a>
 */
public class PreorderTraverser {

    /*
        Time Complexity - O(n)
        Space Complexity - 0(n)
     */
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(final Node root) {
        if (root == null) return list;
        list.add(root.val);
        for (Node node : root.children) {
            preorder(node);
        }
        return list;
    }

    /*
        Time Complexity - O(n)
        Space Complexity - 0(n)
     */
    public List<Integer> preorderUsingIterative(final Node root) {
        final List<Integer> returnList = new ArrayList<>();
        if (root == null) {
            return returnList;
        }

        final Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            final Node currentNode = stack.pop();
            returnList.add(currentNode.val);
            Collections.reverse(currentNode.children);
            stack.addAll(currentNode.children);
        }
        return returnList;
    }

    /*
        Time Complexity - O(n)
        Space Complexity - 0(n)
     */
    public List<Integer> preorderUsingIterativeSelfThought(final Node root) {
        final List<Integer> returnList = new ArrayList<>();
        if (root == null) {
            return returnList;
        }

        final Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            final Node currentNode = stack.pop();
            returnList.add(currentNode.val);
            final List<Node> children = currentNode.children;
            if (children != null) {
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.add(children.get(i));
                }
            }
        }
        return returnList;
    }

    /*
        Time Complexity - O(n)
        Space Complexity - 0(n)
     */
    public List<Integer> preorderSelfThought(final Node root) {
        final List<Integer> returnList = new ArrayList<>();
        populate(root, returnList);
        return returnList;
    }

    public void populate(final Node root, final List<Integer> returnList) {
        if (root == null) {
            return;
        }
        returnList.add(root.val);
        if (root.children != null) {
            for (Node childNode: root.children) {
                populate(childNode, returnList);
            }
        }
    }

}
