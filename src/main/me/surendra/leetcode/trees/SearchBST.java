package me.surendra.leetcode.trees;

/**
 * @see <a href="https://leetcode.com/problems/search-in-a-binary-search-tree/">Search in a Binary Search Tree</a>
 */
public class SearchBST {

    /*
        Time Complexity - O(H) H is maximum height of the tree
        Space Complexity - O(H) H is maximum height of the tree
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return (val < root.val) ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    TreeNode node = null;
    public TreeNode searchBSTAllNodes(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            node = root;
            return node;
        }else{
            searchBST(root.left, val);
            searchBST(root.right, val);
        }
        return node;
    }

}
