package me.surendra.leetcode.trees.binary_search_tree.in_order_traversal;

import me.surendra.leetcode.trees.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/inorder-successor-in-bst/">Inorder Successor in BST</a>
 *
 */
public class InorderSuccessor {

    /*
        Time Complexity - O(n)
        Space Complexity - 0(n)
     */
    TreeNode inOrderSuccessor;
    boolean found = false;
    TreeNode nodeP;
    public TreeNode inorderSuccessor(final TreeNode root, final TreeNode p) {
        nodeP = p;
        populateInorderSuccessor(root);
        return inOrderSuccessor;
    }

    public boolean populateInorderSuccessor(final TreeNode root) {
        if (root == null) {
            return found;
        }
        if (root.left != null) {
            populateInorderSuccessor(root.left);
        }
        if (found) {
            if (inOrderSuccessor == null) {
                inOrderSuccessor = root;
            }
            return true;
        }
        if (root.val == nodeP.val) {
            found = true;
        }
        if (root.right != null) {
            populateInorderSuccessor(root.right);
        }
        return found;
    }

}
