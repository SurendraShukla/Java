package me.surendra.leetcode.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">Construct Binary Tree from Preorder and Inorder Traversal</a>
 */
public class BinaryTreeFromPreorderAndInorderTraversal {

    int preOrderIndex;
    Map<Integer, Integer> inOrderIndexMap;
    public TreeNode buildTreeUsingHashMap(final int[] preorder, final int[] inorder) {
        preOrderIndex = 0;
        // build a hashmap to store value -> its index relations
        inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(final int[] preorder, final int left, final int right) {
        // if there are no elements to construct the tree
        if (left > right) return null;

        // select the preorder_index element as the root and increment it
        final int rootValue = preorder[preOrderIndex++];
        final TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = arrayToTree(preorder, left, inOrderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inOrderIndexMap.get(rootValue) + 1, right);
        return root;
    }

    /*
        Time complexity : O(n ^ 2)
        Space complexity: O(n)
     */
    public TreeNode buildTree(final int[] preorder, final int[] inorder) {
        final List<Integer> preOrderList = new LinkedList<>();
        for (int no : preorder) {
            preOrderList.add(no);
        }

        final List<Integer> inOrderList = new ArrayList<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderList.add(inorder[i]);
        }

        return createTreeFrom(preOrderList, inOrderList);
    }

    private TreeNode createTreeFrom(final List<Integer> preOrderList, final List<Integer> inOrderList) {
        if (preOrderList.isEmpty() || inOrderList.isEmpty()) {
            return null;
        }

        int rootIdx = 0;
        final int rootVal = preOrderList.get(rootIdx);

        final TreeNode root = new TreeNode(rootVal);
        preOrderList.remove(rootIdx);

        final List<Integer> leftList = new ArrayList<>();
        while (inOrderList.get(rootIdx) != rootVal) {
            leftList.add(inOrderList.get(rootIdx));
            rootIdx++;
        }

        rootIdx++;
        final List<Integer> rightList = new ArrayList<>();
        while (rootIdx < inOrderList.size()) {
            rightList.add(inOrderList.get(rootIdx));
            rootIdx++;
        }

        root.left = createTreeFrom(preOrderList, leftList);
        root.right = createTreeFrom(preOrderList, rightList);
        return root;
    }
    
}
