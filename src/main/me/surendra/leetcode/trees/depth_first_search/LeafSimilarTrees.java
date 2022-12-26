package me.surendra.leetcode.trees.depth_first_search;

import me.surendra.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/leaf-similar-trees/">Leaf-Similar Trees</a>
 */
public class LeafSimilarTrees {

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public boolean leafSimilar(final TreeNode root1, final TreeNode root2) {
        final List<Integer> list1 = new ArrayList<>();
        final List<Integer> list2 = new ArrayList<>();

        leafSimilar(root1, list1);
        leafSimilar(root2, list2);

        return list1.equals(list2);
    }

    private void leafSimilar(final TreeNode root, final List<Integer> list) {
        if (root == null) {
            return;
        }
        leafSimilar(root.left, list);
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        leafSimilar(root.right, list);
    }

}
