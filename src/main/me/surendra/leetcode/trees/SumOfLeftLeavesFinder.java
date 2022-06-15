package me.surendra.leetcode.trees;

/**
 * @see <a href="https://leetcode.com/problems/sum-of-left-leaves/">Sum of Left Leaves</a>
 */
public class SumOfLeftLeavesFinder {

    int leftLeavesSum = 0;

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public int sumOfLeftLeaves(TreeNode root) {
        sumOfLeftLeaves(root, false);
        return leftLeavesSum;
    }

    private void sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root.left == null && root.right == null && isLeft) {
            leftLeavesSum+=root.val;
        }
        if (root.left != null) {
            sumOfLeftLeaves(root.left, true);
        }
        if (root.right != null) {
            sumOfLeftLeaves(root.right, false);
        }
    }

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public int sumOfLeftLeavesWithoutGlobalVariable(TreeNode root) {
        return processSubtree(root, false);
    }
    private int processSubtree(TreeNode subtree, boolean isLeft) {

        // Base case: This is an empty subtree.
        if (subtree == null) {
            return 0;
        }

        // Base case: This is a leaf node.
        if (subtree.left == null && subtree.right == null) {
            return isLeft ? subtree.val : 0;
        }

        // Recursive case: We need to add and return the results of the
        // left and right subtrees.
        return processSubtree(subtree.left, true) + processSubtree(subtree.right, false);
    }

}
