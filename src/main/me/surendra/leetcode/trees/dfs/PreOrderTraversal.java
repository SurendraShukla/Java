package me.surendra.leetcode.trees.dfs;


import me.surendra.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. Visit the root first.
 * 2. Traverse the left subtree
 * 3. Traverse the right subtree
 */
public class PreOrderTraversal {

    final List<Integer> integerList = new ArrayList<>();
    public List<Integer> preorderTraversalUsingClassProperty(TreeNode root) {
        if (root == null) return integerList;
        integerList.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return integerList;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        final List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        list.add(root.val);
        if(root.left != null) {
            preorderTraversal(root.left).forEach(integer -> list.add(integer));
        }
        if(root.right != null) {
            preorderTraversal(root.right).forEach(integer -> list.add(integer));
        }
        return list;
    }

}
