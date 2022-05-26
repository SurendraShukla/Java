package me.surendra.leetcode.trees.binary_search_tree.in_order_traversal;


/**
 * @see <a href="https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/">Convert Binary Search Tree to Sorted Doubly Linked List</a>
 */
public class BstToSortedDoublyLinkedListConverter {

    Node firstNode = null;
    Node lastNode = null;

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public Node treeToDoublyList(final Node root) {
        if (root == null) {
            return null;
        }
        preOrderTraversal(root);
        firstNode.left = lastNode;
        lastNode.right = firstNode;
        return firstNode;
    }

    public void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        preOrderTraversal(node.left);
        if (firstNode == null) {
            firstNode = node;
        }else{
            lastNode.right = node;
            node.left = lastNode;
        }
        lastNode = node;
        preOrderTraversal(node.right);
    }

}


class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
