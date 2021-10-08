package me.surendra.leetcode.trees.bfs.binary;

import me.surendra.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/validate-binary-search-tree/">Validate Binary Search Tree</a>
 */
public class Validator {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(final TreeNode root, final Integer min, final Integer max) {
        // Empty trees are valid BSTs.
        if (root == null) {
            return true;
        }
        // The current node's value must be between low and high.
        if ((min != null && root.val >= min) ||
            (max != null && root.val <= max)
        ) {
            return false;
        }

        // The left and right subtree must also be valid.
        return isValidBST(root.left, root.val, max)
            && isValidBST(root.right, min, root.val);
    }


    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    Integer previousVal = null;
    public boolean isValidBSTUsingInOrderTraversalRecursionApproach(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBSTUsingInOrderTraversalRecursionApproach(root.left)) {
            return false;
        }
        if (previousVal != null && previousVal >= root.val) {
            return false;
        }
        previousVal = root.val;
        if (!isValidBSTUsingInOrderTraversalRecursionApproach(root.right)) {
            return false;
        }
        return true;
    }


    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    final List<Integer> integerList = new ArrayList<>();
    public boolean isValidBSTUsingInOrderTraversalIterativeApproach(TreeNode root) {
        populateQueue(root);
        for (int i = 1; i<integerList.size(); i++) {
            if (integerList.get(i - 1).intValue() >= integerList.get(i).intValue()) {
                return false;
            }
        }
        return true;
    }

    private void populateQueue(final TreeNode root) {
        if (root == null) {
            return;
        }
        populateQueue(root.left);
        integerList.add(root.val);
        populateQueue(root.right);
    }

}
