package me.surendra.leetcode.trees.breadth_first_search.in_order_traversal.hard;

import me.surendra.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @see <a href="https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/">Vertical Order Traversal of a Binary Tree</a>
 */
public class VerticalOrderTraverser {

    /*
        Time complexity : O(N)
        Space complexity: O(1)
     */
    public List<List<Integer>> verticalTraversalUsingIteration(TreeNode root) {
        LinkedHashMap<Integer, List<Integer>> verticalLevelTraversal = new LinkedHashMap<>();

        return null;
    }

    /*
        Time complexity : O(N)
        Space complexity: O(1)
     */
    private LinkedHashMap<Integer, List<Integer>> verticalLevelTraversal = new LinkedHashMap<>();
    public List<List<Integer>> verticalTraversalUsingRecursion(TreeNode root) {
        populate(root, 0, 0);

        final List<List<Integer>> returnList = new ArrayList<>();
        returnList.addAll(verticalLevelTraversal.values());
        return returnList;
    }

    private void populate(TreeNode root, int level, int column) {
        if (root == null) {
            return;
        }
        List<Integer> columnLevelValues = verticalLevelTraversal.getOrDefault(column, new ArrayList<>());
        columnLevelValues.add(root.val);
        verticalLevelTraversal.put(column, columnLevelValues);
        populate(root.left, level+1, column-1);
        populate(root.right, level+1, column+1);
    }

}
