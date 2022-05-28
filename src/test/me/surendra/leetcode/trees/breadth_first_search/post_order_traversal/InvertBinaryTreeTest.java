package me.surendra.leetcode.trees.breadth_first_search.post_order_traversal;

import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;


public class InvertBinaryTreeTest {

    private void callMethod(final TreeNode treeNode) {
        new InvertBinaryTree().invertTree(treeNode);
    }

    /*
        Input: root = [4,2,7,1,3,6,9]
        Output: [4,7,2,9,6,3,1]
     */
    @Test
    public void invertedTree1() {
        final TreeNode left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        final TreeNode right = new TreeNode(7, new TreeNode(6), new TreeNode(9));
        final TreeNode treeNode = new TreeNode(4, left, right);

        callMethod(treeNode);
    }

    /*
        Input: root = [2,1,3]
        Output: [2,3,1]
     */
    @Test
    public void invertedTree2() {
        final TreeNode treeNode = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        callMethod(treeNode);
    }

    /*
        Input: root = []
        Output: []
     */
    @Test
    public void invertedTree3() {
        final TreeNode treeNode = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        callMethod(treeNode);
    }

}
