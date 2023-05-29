package me.surendra.leetcode.trees.n_ary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @see <a href="https://leetcode.com/problems/n-ary-tree-level-order-traversal/">N-ary Tree Level Order Traversal</a>
 */
public class LevelOrderTraversal {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public List<List<Integer>> levelOrderUsingDfs(final Node root) {
        final List<List<Integer>> returnList = new ArrayList<>();
        dfs(root, 0, returnList);
        return returnList;
    }

    public void dfs(final Node root, final int level, final List<List<Integer>> returnList) {
        if (root == null) {
            return;
        }
        if (returnList.size() == level) {
            returnList.add(new ArrayList<>());
        }
        returnList.get(level).add(root.val);
        for (Node children: root.children) {
            dfs(children, level + 1, returnList);
        }
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public List<List<Integer>> levelOrderUsingBfs(final Node root) {
        final List<List<Integer>> levelOrderNodeValues = new ArrayList<>();
        if (root == null) {
            return levelOrderNodeValues;
        }
        final Queue<List<Node>> queue = new LinkedList<>();
        final List<Node> firstLevelNodes = new ArrayList<>();
        firstLevelNodes.add(root);
        queue.add(firstLevelNodes);

        while (!queue.isEmpty()) {
            final List<Node> nodes = queue.remove();
            final List<Node> levelNodes = new ArrayList<>();
            final List<Integer> levelNodeValues = new ArrayList<>();
            for (Node node: nodes) {
                levelNodes.addAll(node.children);
                levelNodeValues.add(node.val);
            }
            if (!levelNodes.isEmpty()) {
                queue.add(levelNodes);
            }
            levelOrderNodeValues.add(levelNodeValues);
        }

        return levelOrderNodeValues;
    }

}
