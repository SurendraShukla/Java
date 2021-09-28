package me.surendra.leetcode.trees;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CousinsFinderTest {

    private boolean callMethod(final TreeNode treeNode, final int x, final int y) {
        return new CousinsFinder().isCousins(treeNode, x, y);
    }

    @Test
    public void test1() {
        final TreeNode left = new TreeNode(2, new TreeNode(4), null);
        final TreeNode right = new TreeNode(3, null, null);
        final TreeNode treeNode = new TreeNode(1, left, right);

        assertThat(callMethod(treeNode, 4, 3), equalTo(false));
        assertThat(callMethod(treeNode, 3, 4), equalTo(false));
    }

    @Test
    public void test2() {
        final TreeNode left = new TreeNode(2, null, new TreeNode(4));
        final TreeNode right = new TreeNode(3, null, new TreeNode(5));
        final TreeNode treeNode = new TreeNode(1, left, right);

        assertThat(callMethod(treeNode, 5, 4), equalTo(true));
        assertThat(callMethod(treeNode, 4, 5), equalTo(true));
    }

    @Test
    public void test3() {
        final TreeNode left = new TreeNode(2, null, new TreeNode(4));
        final TreeNode right = new TreeNode(3, null, new TreeNode(5));
        final TreeNode treeNode = new TreeNode(1, left, right);

        assertThat(callMethod(treeNode, 2, 3), equalTo(false));
        assertThat(callMethod(treeNode, 3, 2), equalTo(false));
    }


}
