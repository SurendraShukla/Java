package me.surendra.leetcode.trees.dfs.binary;

import me.surendra.leetcode.trees.TreeNode;

import java.util.Stack;

public class PathSumFinder {

    public boolean hasPathSum(final TreeNode root, final int targetSum) {
        final Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(root);
        TreeNode treeNode;
        int levelSum = 0;

        while(!treeNodeStack.isEmpty()) {
            treeNode = treeNodeStack.pop();
            levelSum+= treeNode.val;

            if ( (root.right == null) && (root.left == null) ) {
                if (levelSum == targetSum) {
                    return true;
                }else{
                    levelSum-=treeNode.val;
                }
            }
            if(root.right != null) {
                treeNodeStack.push(root.right);
            }

            if(root.left != null) {
                treeNodeStack.push(root.left);
            }
        }
        return false;
    }

}
