package me.surendra.leetcode.trees.binary;

import me.surendra.leetcode.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">Maximum Depth of Binary Tree</a>
 */
public class MaximumDepth {

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public int getMaxDepth(final TreeNode root) {
        int level = 0;
        if (root == null) {
            return level;
        }
        final Queue<Queue<TreeNode>> treeNodes = new LinkedList<>();
        final Queue<TreeNode> rootNode = new LinkedList<>();
        rootNode.add(root);
        treeNodes.add(rootNode);

        while (!treeNodes.isEmpty()) {
            level++;
            final Queue<TreeNode> currentLevelTreeNodes = treeNodes.remove();
            final Queue<TreeNode> tmpLevelTreeNodes = new LinkedList<>();
            while(!currentLevelTreeNodes.isEmpty()) {
                final TreeNode treeNode = currentLevelTreeNodes.remove();
                if(treeNode.left != null) {
                    tmpLevelTreeNodes.add(treeNode.left);
                }
                if(treeNode.right != null) {
                    tmpLevelTreeNodes.add(treeNode.right);
                }
            }
            if(!tmpLevelTreeNodes.isEmpty()) {
                treeNodes.add(tmpLevelTreeNodes);
            }
        }
        return level;
    }


}
