package me.surendra.leetcode.trees.bfs;

import me.surendra.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1. Starts with a root node and visit the node itself first.
 * 2. Then traverse its neighbors.
 * 3. Traverse its second level neighbors,
 * 4. Traverse its third level neighbors, so on and so forth.
 */
public class LevelOrderTraversal {

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        final List<List<Integer>> outputList = new ArrayList<>();
        if(root == null) {
            return outputList;
        }

        final Queue<Queue<TreeNode>> allLevelTreeNodes = new LinkedList<>();
        final Queue<TreeNode> levelOneTreeNode = new LinkedList<>();
        levelOneTreeNode.add(root);
        allLevelTreeNodes.add(levelOneTreeNode);

        while(!allLevelTreeNodes.isEmpty()) {
            final Queue<TreeNode> currentLevelTreeNodes = allLevelTreeNodes.remove();
            final Queue<TreeNode> tmpTreeNodes = new LinkedList<>();
            final List<Integer> tmpList = new ArrayList<>();
            while(!currentLevelTreeNodes.isEmpty()) {
                final TreeNode currentTreeNode = currentLevelTreeNodes.remove();
                tmpList.add(currentTreeNode.val);
                if(currentTreeNode.left != null) {
                    tmpTreeNodes.add(currentTreeNode.left);
                }
                if(currentTreeNode.right != null) {
                    tmpTreeNodes.add(currentTreeNode.right);
                }
            }
            if (!tmpTreeNodes.isEmpty()) {
                allLevelTreeNodes.add(tmpTreeNodes);
            }
            if (!tmpList.isEmpty()) {
                outputList.add(tmpList);
            }
        }
        return outputList;
    }

    private void printVars(final String msg, final Queue<Queue<TreeNode>> allLevelTreeNodes, final List<List<Integer>> outputList,
                           final Queue<TreeNode> currentLevelTreeNodes, Queue<TreeNode> tmpTreeNodes, List<Integer> tmpList
    ) {
        System.out.println(msg);
        System.out.println("allLevelTreeNodes=\t[" + allLevelTreeNodes.size() + "]");
        System.out.println("currentLevelTreeNodes=\t[" + currentLevelTreeNodes.size() + "]");
        System.out.println("tmpTreeNodes=\t[" + tmpTreeNodes.size() + "]");
        System.out.println("tmpList=\t[" + tmpList.size() + "]");
        System.out.println("outputList=\t[" + outputList.size() + "]");
        System.out.println("                                    ");
    }

}
