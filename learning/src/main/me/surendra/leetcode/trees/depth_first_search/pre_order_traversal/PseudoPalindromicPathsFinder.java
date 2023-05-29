package me.surendra.leetcode.trees.depth_first_search.pre_order_traversal;

import me.surendra.leetcode.trees.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/">Pseudo-Palindromic Paths in a Binary Tree</a>
 */
public class PseudoPalindromicPathsFinder {

    /*
        Time complexity: O(n) to visit each node
        Space complexity: O(h) to keep the recursion stack, where H is a tree height.
     */
    int totalPseudoPalindromicPaths = 0;
    public int pseudoPalindromicPaths(final TreeNode root) {
        final int[] list = new int[10];
        list[root.val]++;
        pseudoPalindromicPaths(root, list);
        return totalPseudoPalindromicPaths;
    }

    private void pseudoPalindromicPaths(final TreeNode root, final int[] list) {
        if (root.left == null && root.right == null) {
            if (canPalindromicBeMade(list)) {
                totalPseudoPalindromicPaths++;
            }
        }
        if (root.left != null) {
            list[root.left.val]++;
            pseudoPalindromicPaths(root.left, list);
            list[root.left.val]--;
        }
        if (root.right != null) {
            list[root.right.val]++;
            pseudoPalindromicPaths(root.right, list);
            list[root.right.val]--;
        }
    }

    private boolean canPalindromicBeMade(final int[] list) {
        int oddNumber = 0;
        for (int i = 1; i < list.length; i++) {
            if (list[i] % 2 != 0) {
                oddNumber++;
                if (oddNumber > 1) {
                    return false;
                }
            }
        }
        return true;
    }



    /*
        Time complexity: O(n) to visit each node
        Space complexity: O(h) to keep the recursion stack, where H is a tree height.
     */
    int count = 0;
    public int pseudoPalindromicPathsUsingBitWiseOperator(final TreeNode root) {
        preorder(root, 0);
        return count;
    }

    public void preorder(final TreeNode node, int path) {
        if (node != null) {
            // compute occurrences of each digit
            // in the corresponding register
            path = path ^ (1 << node.val);
            // if it's a leaf check if the path is pseudo-palindromic
            if (node.left == null && node.right == null) {
                // check if at most one digit has an odd frequency
                if ((path & (path - 1)) == 0) {
                    ++count;
                }
            }
            preorder(node.left, path);
            preorder(node.right, path);
        }
    }


}
