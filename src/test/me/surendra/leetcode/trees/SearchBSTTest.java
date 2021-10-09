package me.surendra.leetcode.trees;


import org.junit.Test;

public class SearchBSTTest {

    private TreeNode callMethod(final TreeNode treeNode, final int val) {
        return new SearchBST().searchBST(treeNode, val);
//        return new SearchBST().searchBSTAllNodes(treeNode, val);
    }

    @Test
    public void test1() {
        final TreeNode left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        final TreeNode right = new TreeNode(7);
        final TreeNode treeNode = new TreeNode(4, left, right);

//        final TreeNode actualNode = callMethod(treeNode, 2);
//        final TreeNode actualNode = callMethod(treeNode, 7);
//        final TreeNode actualNode = callMethod(treeNode, 4);
        final TreeNode actualNode = callMethod(treeNode, 5);
        System.out.println(actualNode);
    }

}
