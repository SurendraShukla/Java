package me.surendra.leetcode.trees.depth_first_search;


import me.surendra.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * @see <a href="https://leetcode.com/problems/path-sum-ii/">Path Sum II</a>
 */
public class PathSumIIFinder {

    /*
        Time complexity : O(n ^ 2) Copying pathNodes to result in case all leaf nodes have path sum
        Space complexity: O(n) 2n copying pathNodes to result in case all leaf nodes have path sum
     */
    final List<List<Integer>> returnList = new ArrayList<>();
    public List<List<Integer>> pathSum(final TreeNode root, final int targetSum) {
        if (root == null) {
            return returnList;
        }
        final List<Integer> list = new ArrayList<>();
        list.add(root.val);
        populate(root, targetSum - root.val, list);
        return returnList;
    }

    private void populate(final TreeNode root, final int targetSum, final List<Integer> list) {
        System.out.println(root.val + ":" + targetSum + ":" + list.size());
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                returnList.add(new ArrayList<>(list));
            }
            return;
        }
        if (root.left != null) {
            list.add(root.left.val);
            populate(root.left, targetSum - root.left.val, list);
            list.remove(list.size() - 1);
        }

        if (root.right != null) {
            list.add(root.right.val);
            populate(root.right, targetSum - root.right.val, list);
            list.remove(list.size() - 1);
        }
    }

}
