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
        Space complexity: O(log n) - space because the tree is height-balanced.
     */
    public TreeNode fromSortedArray(final int[] nums) {
        return fromSortedArray(nums, 0, nums.length - 1);
    }

    private TreeNode fromSortedArray(final int[] nums, final int left, final int right) {
        if (left > right) return null;
        final int mid = (right + left) / 2;
        final TreeNode root = new TreeNode(nums[mid]);
        root.left = fromSortedArray(nums, left, mid - 1);
        root.right = fromSortedArray(nums, mid + 1, right);
        return root;
    }

    /*
        Time complexity : O(n)
        Space complexity: O(b) - Breadth of Tree
     */
    public static TreeNode fromPreOrder(final List<Integer> integerList) {
        if (integerList == null || integerList.isEmpty()) {
            return null;
        }
        final TreeNode root = new TreeNode(integerList.get(0));
        final Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);

        int idx = 1;
        while (!treeNodeQueue.isEmpty()) {
            final int queueSize = treeNodeQueue.size();
            for (int i = 0; i < queueSize; i++) {
                final TreeNode currentNode = treeNodeQueue.remove();
                final Integer leftVal = getVal(idx++, integerList);
                if (leftVal != null) {
                    currentNode.left = new TreeNode(leftVal);
                    treeNodeQueue.add(currentNode.left);
                }
                final Integer rightVal = getVal(idx++, integerList);
                if (rightVal != null) {
                    currentNode.right = new TreeNode(rightVal);
                    treeNodeQueue.add(currentNode.right);
                }
            }
        }
        return root;
    }

    private static Integer getVal(final int idx, final List<Integer> integerList) {
        if (idx >= integerList.size()) {
            return null;
        }
        return integerList.get(idx);
    }

}
