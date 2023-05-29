package me.surendra.leetcode.trees.breadth_first_search.pre_order_traversal;

import me.surendra.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @see <a href="https://leetcode.com/problems/binary-tree-vertical-order-traversal/">Binary Tree Vertical Order Traversal</a>
 */
public class VerticalOrderTraversal {
    final TreeMap<Integer, TreeMap<Integer, List<Integer>>> verticalLevelTraversal = new TreeMap<>();

    public List<List<Integer>> verticalOrder(final TreeNode root) {
        populate(root, 0, 0);

        final List<List<Integer>> returnList = new ArrayList<>();
        for (TreeMap<Integer, List<Integer>> colLevelInfo : verticalLevelTraversal.values()) {
            final List<Integer> valList = new ArrayList<>();
            for (List<Integer> levelVal: colLevelInfo.values()) {
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
        final int val = treeNode.val;
        if (verticalLevelTraversal.containsKey(col)) {
            final TreeMap<Integer, List<Integer>> colLevelMap = verticalLevelTraversal.get(col);
            if (colLevelMap.containsKey(row)) {
                colLevelMap.get(row).add(val);
            } else {
                final List<Integer> valList = new ArrayList<>();
                valList.add(val);
                colLevelMap.put(row, valList);
            }
        } else {
            final TreeMap<Integer, List<Integer>> colLevelMap = new TreeMap<>();
            final List<Integer> valList = new ArrayList<>();
            valList.add(val);
            colLevelMap.put(row, valList);
            verticalLevelTraversal.put(col, colLevelMap);
        }
        populate(treeNode.left, col - 1, row + 1);
        populate(treeNode.right, col + 1, row + 1);
    }

}
