package me.surendra.leetcode.trees;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/count-good-nodes-in-binary-tree/">Count Good Nodes in Binary Tree</a>
 */
public class GoodNodeCounter {

    int goodNodes = 0;

    public int goodNodesUsingMaxVar(TreeNode root) {
        goodNodes(root, root.val);
        return goodNodes;
    }

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public void goodNodes(TreeNode root, int maxSoFar) {
        if (root.left != null) {
            goodNodes(root.left, Math.max(maxSoFar, root.left.val));
        }

        if (root.right != null) {
            goodNodes(root.right, Math.max(maxSoFar, root.right.val));
        }

        if (root.val >= maxSoFar) {
            goodNodes++;
        }
    }

    public int goodNodesUsingStack(TreeNode root) {
        return goodNodes(root, new Stack<>());
    }

    /*
        Time complexity : O(n)
        Space complexity: O(h) - Height of tree
     */
    public int goodNodes(TreeNode root, Stack<Integer> parents) {
        int goodNodes = 0;
        if (root == null) {
            return goodNodes;
        }
        parents.add(root.val);
        if (root.left != null) {
            goodNodes+=goodNodes(root.left, parents);
        }

        if (root.right != null) {
            goodNodes+=goodNodes(root.right, parents);
        }

        for (final Integer parent : parents) {
            if (parent > root.val) {
                parents.pop();
                return goodNodes;
            }
        }
        goodNodes++;
        parents.pop();
        return goodNodes;
    }

}
