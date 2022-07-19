package me.surendra.leetcode.trees;

import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeNodeCreator {

    public static TreeNode fromPreOrder(final Integer ...numbers) {
        if (numbers == null) {
            return null;
        }
        return fromPreOrder(Lists.newArrayList(numbers));
    }

    /*
        Time complexity : O(n)
        Space complexity: O(B) - Breadth of Tree
     */
    public static TreeNode fromPreOrder(final List<Integer> integerList) {
        if (integerList == null || integerList.isEmpty()) {
            return null;
        }
        final int size = integerList.size();
        final TreeNode root = new TreeNode(integerList.get(0));
        final Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);

        int idx = 1;
        while (!treeNodeQueue.isEmpty()) {
            final int queueSize = treeNodeQueue.size();
            for (int i = 0; i < queueSize; i++) {
                final TreeNode currentNode = treeNodeQueue.remove();
                if (idx >= size) {
                    break;
                }
                final Integer leftVal = integerList.get(idx++);
                if (leftVal != null) {
                    currentNode.left = new TreeNode(leftVal);
                    treeNodeQueue.add(currentNode.left);
                }
                final Integer rightVal = integerList.get(idx++);
                if (rightVal != null) {
                    currentNode.right = new TreeNode(rightVal);
                    treeNodeQueue.add(currentNode.right);
                }
            }
        }
        return root;
    }

}
