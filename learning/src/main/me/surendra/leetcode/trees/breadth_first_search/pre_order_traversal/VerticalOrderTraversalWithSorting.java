package me.surendra.leetcode.trees.breadth_first_search.pre_order_traversal;

import me.surendra.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;


/**
 * @see <a href="https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/">Vertical Order Traversal of a Binary Tree</a>
 */
public class VerticalOrderTraversalWithSorting {
    final TreeMap<Integer, TreeMap<Integer, List<Integer>>> verticalLevelTraversal = new TreeMap<>();

    public List<List<Integer>> verticalOrder(final TreeNode root) {
        populate(root, 0, 0);

        final List<List<Integer>> returnList = new ArrayList<>();
        for (TreeMap<Integer, List<Integer>> colLevelInfo : verticalLevelTraversal.values()) {
            final List<Integer> valList = new ArrayList<>();
            for (List<Integer> levelVal: colLevelInfo.values()) {
                Collections.sort(levelVal);
                valList.addAll(levelVal);
            }
            returnList.add(valList);
        }
        return returnList;
    }

    public void populate(final TreeNode treeNode, final int col, final int row) {
        if (treeNode == null) {
            return;
        }
        final TreeMap<Integer, List<Integer>> colLevelMap = verticalLevelTraversal.getOrDefault(col, new TreeMap<>());
        final List<Integer> valList = colLevelMap.getOrDefault(row, new ArrayList<>());
        valList.add(treeNode.val);
        colLevelMap.put(row, valList);
        verticalLevelTraversal.put(col, colLevelMap);

        populate(treeNode.left, col - 1, row + 1);
        populate(treeNode.right, col + 1, row + 1);
    }

}
