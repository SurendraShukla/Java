package me.surendra.leetcode.trees.bfs.binary;

import me.surendra.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/validate-binary-search-tree/">Validate Binary Search Tree</a>
 */
public class Validator {
    final List<Integer> integerList = new ArrayList<>();

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public boolean isValidBST(TreeNode root) {
        populateQueue(root);
        for (int i = 1; i<integerList.size(); i++) {
            if (integerList.get(i - 1).intValue() >= integerList.get(i).intValue()) {
                return false;
            }
        }
        return true;
    }

    private void populateQueue(final TreeNode root) {
        if (root == null) {
            return;
        }
        populateQueue(root.left);
        integerList.add(root.val);
        populateQueue(root.right);
    }

}
