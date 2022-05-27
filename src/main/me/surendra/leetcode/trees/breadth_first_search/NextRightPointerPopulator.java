package me.surendra.leetcode.trees.breadth_first_search;

import me.surendra.leetcode.trees.Node;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @see <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/">Populating Next Right Pointers in Each Node</a>
 */
public class NextRightPointerPopulator {

    /*
        Time complexity : O(n)
        Space complexity: O(1)
     */
    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null) root.left.next = root.right;
        if (root.right != null && root.next != null) root.right.next = root.next;
        connect(root.left);
        connect(root.right);
        return root;
    }

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public Node connectUsingQueue(Node root) {
        if (root == null) {
            return null;
        }
        final Queue<Node> stack = new LinkedList<>();
        root.next = null;
        stack.add(root);

        while (!stack.isEmpty()) {
            int stackSize = stack.size();
            Node rightNode = null;

            for(int i=0; i<stackSize; i++) {
                Node currentNode = stack.poll();
                currentNode.next = rightNode;
                rightNode = currentNode;

                if (currentNode.right != null) {
                    stack.add(currentNode.right);
                }
                if (currentNode.left != null) {
                    stack.add(currentNode.left);
                }
            }
        }
        return root;
    }

}
