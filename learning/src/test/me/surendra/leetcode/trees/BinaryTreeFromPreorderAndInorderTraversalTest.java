package me.surendra.leetcode.trees;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class BinaryTreeFromPreorderAndInorderTraversalTest {

    private TreeNode callMethod(final int[] preOrder, final int[] inOrder) {
        final BinaryTreeFromPreorderAndInorderTraversal creator = new BinaryTreeFromPreorderAndInorderTraversal();
        return creator.buildTreeUsingHashMap(preOrder, inOrder);
//        return creator.buildTree(preOrder, inOrder);
    }

    @Test
    public void test1() {
        final int[] preOrder = {-1};
        final int[] inOrder = {-1};

        final TreeNode actual = callMethod(preOrder, inOrder);

        final TreeNode expected = BinaryTreeNodeCreator.fromPreOrder(-1);
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test2() {
        final int[] preOrder = {3, 9, 20, 15, 7};
        final int[] inOrder = {9, 3, 15, 20, 7};

        final TreeNode actual = callMethod(preOrder, inOrder);

        final TreeNode expected = BinaryTreeNodeCreator.fromPreOrder(3, 9, 20, null, null, 15, 7);
        assertThat(actual, equalTo(expected));
    }
}
