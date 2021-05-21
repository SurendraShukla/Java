package me.surendra.leetcode.trees.bfs.binary;

import me.surendra.leetcode.trees.TreeNode;

public class Validator {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Integer rootVal = root.val;
        Integer leftVal = (root.left == null) ? null : root.left.val;
        Integer rightVal = (root.right == null) ? null : root.right.val;
        System.out.println("RootVal=[" + rootVal + "] leftVal=[" + leftVal + "] rightVal=[" + rightVal +
            "] isLeftNodeValid=[" + isLeftNodeValid(rootVal, root.left) +
            "] isRightNodeValid=[" + isRightNodeValid(rootVal, root.right) + "]");
        if (isLeftNodeValid(rootVal, root.left) && isRightNodeValid(rootVal, root.right)) {
            return isValidBST(root.left) && isValidBST(root.right);
        }
        return false;
    }

    boolean isLeftNodeValid(int nodeVal, TreeNode leftNode) {
        if (leftNode == null) {
            return true;
        }
        if (leftNode.val < nodeVal) {
            return true;
        }
        return false;
    }

    boolean isRightNodeValid(int nodeVal, TreeNode rightNode) {
        if (rightNode == null) {
            return true;
        }
        if (rightNode.val > nodeVal) {
            return true;
        }
        return false;
    }

}
