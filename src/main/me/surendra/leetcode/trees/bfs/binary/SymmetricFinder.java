package me.surendra.leetcode.trees.bfs.binary;

import me.surendra.leetcode.trees.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricFinder {

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);

        while (!treeNodeQueue.isEmpty()) {
            final List<Integer> list = new LinkedList<>();
            int queueSize = treeNodeQueue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode treeNode = treeNodeQueue.remove();
                if (treeNode.left == null) {
                    list.add(null);
                }else{
                    list.add(treeNode.left.val);
                    treeNodeQueue.add(treeNode.left);
                }
                if (treeNode.right == null) {
                    list.add(null);
                }else{
                    list.add(treeNode.right.val);
                    treeNodeQueue.add(treeNode.right);
                }
            }
            if (!isListSymmetric(list)) {
                return false;
            }
        }
        return true;
    }

    private boolean isListSymmetric(final List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return true;
        }
        // if size is odd, return false;
        if ((size%2) != 0) {
            return false;
        }

        int startIndex = 0;
        int lastIndex = size-1;
        // Check whether list is symmetric or not
        while (startIndex < lastIndex) {
            if (list.get(startIndex) != list.get(lastIndex)) {
                return false;
            }
            startIndex++;
            lastIndex--;
        }
        return true;
    }

}
