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
    public boolean isSymmetricUsingRecursion(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(final TreeNode left, final TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }


    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public boolean isSymmetricUsingIteration(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }


    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public boolean isSymmetricSelfThought(TreeNode root) {
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
