package me.surendra.leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * @see <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/">Binary Tree Zigzag Level Order Traversal</a>
 */
public class ZigzagLevelOrderTraversal {

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        final List<List<Integer>> returnList = new ArrayList<>();
        if (root == null) {
            return returnList;
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);

        while(!treeNodeQueue.isEmpty()) {
            int size = treeNodeQueue.size();
            final List<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                final TreeNode treeNode = treeNodeQueue.poll();
                tmpList.add(treeNode.val);
                if (treeNode.left != null) {
                    treeNodeQueue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodeQueue.add(treeNode.right);
                }
            }
            returnList.add(tmpList);
        }

        boolean shouldSort = false;
        for(int j=0; j<returnList.size(); j++) {
            if (shouldSort) {
                sortList(returnList.get(j));
            }
            shouldSort=!shouldSort;
        }

        return returnList;
    }

    private void sortList(final List<Integer> listToSort) {
        int leftIndex = 0;
        int rightIndex = listToSort.size()-1;
        while(leftIndex < rightIndex) {
            int tmp =  listToSort.get(leftIndex);
            listToSort.set(leftIndex, listToSort.get(rightIndex));
            listToSort.set(rightIndex, tmp);
            leftIndex++;
            rightIndex--;
        }
    }

}
