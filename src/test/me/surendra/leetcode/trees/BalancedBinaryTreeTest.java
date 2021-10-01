package me.surendra.leetcode.trees;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class BalancedBinaryTreeTest {

    private boolean callMethod(final TreeNode treeNode) {
        return new BalancedBinaryTree().isBalanced(treeNode);
    }

    @Test
    public void balanced1() {
        assertThat(callMethod(null), equalTo(true));
    }

    @Test
    public void balanced2() {
        final TreeNode left = new TreeNode(9, null, null);
        final TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        final TreeNode treeNode = new TreeNode(3, left, right);

        assertThat(callMethod(treeNode), equalTo(true));
    }

    @Test
    public void unBalanced1() {
        final TreeNode left = new TreeNode(1, new TreeNode(2), null);
        final TreeNode treeNode = new TreeNode(1, left, null);

        assertThat(callMethod(treeNode), equalTo(false));
    }

    @Test
    public void unBalanced2() {
        final TreeNode left1 = new TreeNode(3, new TreeNode(4), new TreeNode(4));
        final TreeNode left2 = new TreeNode(2, left1, new TreeNode(3));
        final TreeNode treeNode = new TreeNode(1, left2, new TreeNode(2));

        assertThat(callMethod(treeNode), equalTo(false));
    }

    @Test
    public void unBalanced3_FailedOnLeetCode() {
        final TreeNode left1 = new TreeNode(3, new TreeNode(4), null);
        final TreeNode left2 = new TreeNode(2, left1, null);
        final TreeNode right1 = new TreeNode(3, new TreeNode(4), null);
        final TreeNode right2 = new TreeNode(2, right1, null);
        final TreeNode treeNode = new TreeNode(1, left2, right2);

        assertThat(callMethod(treeNode), equalTo(false));
    }

}
