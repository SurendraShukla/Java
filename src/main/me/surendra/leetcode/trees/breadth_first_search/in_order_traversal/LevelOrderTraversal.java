package me.surendra.leetcode.trees.breadth_first_search.in_order_traversal;

import me.surendra.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">Binary Tree Level Order Traversal</a>
 *
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
    public List<List<Integer>> levelOrderUsingIterationUsingRecursion(final TreeNode root) {
        final List<List<Integer>> outputList = new ArrayList<>();
        populateLevelOrder(root, 0, outputList);
        return outputList;
    }

    private void populateLevelOrder(final TreeNode root, final int level, final List<List<Integer>> outputList) {
        if (root == null) {
            return;
        }

        if (outputList.size() == level) {
            outputList.add(level, new ArrayList<>());
        }
        outputList.get(level).add(root.val);
        populateLevelOrder(root.left, level + 1, outputList);
        populateLevelOrder(root.right, level + 1, outputList);
    }


    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public List<List<Integer>> levelOrderUsingIterationUsingSingleQueue(final TreeNode root) {
        final List<List<Integer>> returnList = new ArrayList<>();
        if (root == null) {
            return returnList;
        }
        final Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        int level = 0;

        while (!treeNodeQueue.isEmpty()) {
            returnList.add(new ArrayList<>());
            final int queueSize = treeNodeQueue.size();
            for (int i = 0; i < queueSize; i++) {
                final TreeNode treeNode = treeNodeQueue.remove();
                returnList.get(level).add(treeNode.val);
                if (treeNode.left != null) treeNodeQueue.add(treeNode.left);
                if (treeNode.right != null) treeNodeQueue.add(treeNode.right);
            }
            level++;
        }
        return returnList;
    }


    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public List<List<Integer>> levelOrderUsingIterationUsingMultipleQueues(final TreeNode root) {
        final List<List<Integer>> returnList = new ArrayList<>();
        if (root == null) {
            return returnList;
        }

        final Queue<Queue<TreeNode>> allLevelTreeNodes = new LinkedList<>();
        final Queue<TreeNode> levelOneTreeNode = new LinkedList<>();
        levelOneTreeNode.add(root);
        allLevelTreeNodes.add(levelOneTreeNode);

        while (!allLevelTreeNodes.isEmpty()) {
            final Queue<TreeNode> currentLevelTreeNodes = allLevelTreeNodes.remove();
            final Queue<TreeNode> tmpTreeNodes = new LinkedList<>();
            final List<Integer> tmpList = new ArrayList<>();
            while (!currentLevelTreeNodes.isEmpty()) {
                final TreeNode currentTreeNode = currentLevelTreeNodes.remove();
                tmpList.add(currentTreeNode.val);
                if (currentTreeNode.left != null) {
                    tmpTreeNodes.add(currentTreeNode.left);
                }
                if (currentTreeNode.right != null) {
                    tmpTreeNodes.add(currentTreeNode.right);
                }
            }
            if (!tmpTreeNodes.isEmpty()) {
                allLevelTreeNodes.add(tmpTreeNodes);
            }
            if (!tmpList.isEmpty()) {
                returnList.add(tmpList);
            }
        }
        return returnList;
    }

}
