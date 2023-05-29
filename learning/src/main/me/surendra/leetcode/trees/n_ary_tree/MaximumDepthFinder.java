package me.surendra.leetcode.trees.n_ary_tree;

/**
 * @see <a href="https://leetcode.com/problems/maximum-depth-of-n-ary-tree/">Maximum Depth of N-ary Tree</a>
 */
public class MaximumDepthFinder {

    /*
        Time Complexity - O(n)
        Space Complexity - 0(n)
     */
    int maxDepth = 0;
    public int maxDepth(final Node root) {
        populateMaxDepth(root, 1);
        return maxDepth;
    }

    private void populateMaxDepth(final Node root, final int level) {
        if (root == null) {
            return;
        }
        if (root.children.size() == 0) {
            maxDepth = Math.max(maxDepth, level);
        }
        for (Node children: root.children) {
            populateMaxDepth(children, level + 1);
        }
    }

}
