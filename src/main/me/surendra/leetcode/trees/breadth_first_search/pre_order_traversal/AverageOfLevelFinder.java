package me.surendra.leetcode.trees.breadth_first_search.pre_order_traversal;

import me.surendra.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/average-of-levels-in-binary-tree/">Average of Levels in Binary Tree</a>
 */
public class AverageOfLevelFinder {

    /*
        Time complexity: O(n) to visit each node
        Space complexity: O(h) to keep the recursion stack, where H is a tree height.
     */
    final List<Integer> count = new ArrayList<>();
    final List<Double> result = new ArrayList<>();
    public List<Double> averageOfLevels(final TreeNode root) {
        populate(root, 0);

        for (int i = 0; i < count.size(); i++) {
            result.set(i, result.get(i) / count.get(i));
        }
        return result;
    }

    private void populate(final TreeNode root, final int level) {
        if (root == null) {
            return;
        }
        if (level < result.size()) {
            count.set(level, count.get(level) + 1);
            result.set(level, result.get(level) + root.val);
        } else {
            count.add(1);
            result.add(root.val * 1.0);
        }
        populate(root.left, level + 1);
        populate(root.right, level + 1);
    }

}
