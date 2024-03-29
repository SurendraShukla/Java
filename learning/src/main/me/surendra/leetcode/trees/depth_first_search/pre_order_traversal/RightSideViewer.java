package me.surendra.leetcode.trees.depth_first_search.pre_order_traversal;

import me.surendra.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/binary-tree-right-side-view/">Binary Tree Right Side View</a>
 */
public class RightSideViewer {

    /*
        Time complexity: O(n) Need to visit all nodes
        Space complexity: O(h) Height of the tree
     */
    final List<Integer> rightSideViewNodeValues = new ArrayList<>();
    public List<Integer> rightSideView(final TreeNode root) {
        populateRightSideViewNodeValues(root, 0);
        return rightSideViewNodeValues;
    }

    private void populateRightSideViewNodeValues(final TreeNode root, final int level) {
        if (root == null) {
            return;
        }
        if (rightSideViewNodeValues.size() == level) {
            rightSideViewNodeValues.add(root.val);
        }
        populateRightSideViewNodeValues(root.right, level + 1);
        populateRightSideViewNodeValues(root.left, level + 1);
    }

}
