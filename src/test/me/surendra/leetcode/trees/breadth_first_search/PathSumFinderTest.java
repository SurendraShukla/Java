package me.surendra.leetcode.trees.breadth_first_search;

import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class PathSumFinderTest {

    private boolean callMethod(final TreeNode root, final int targetSum) {
        return new PathSumFinder().hasPathSumUsingRecursion(root, targetSum);
    }

    @Test
    public void test1() {
        final TreeNode left1 = new TreeNode(11, new TreeNode(7), new TreeNode(2));
        final TreeNode left = new TreeNode(4, left1, null);
        final TreeNode right1 = new TreeNode(4, null, new TreeNode(1));
        final TreeNode right = new TreeNode(8, new TreeNode(13), right1);
        final TreeNode root = new TreeNode(5, left, right);

        assertThat(callMethod(root, 22), equalTo(true));
        assertThat(callMethod(root, 23), equalTo(false));
    }


    @Test
    public void test2() {
        final TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        assertThat(callMethod(root, 3), equalTo(true));
        assertThat(callMethod(root, 4), equalTo(true));
        assertThat(callMethod(root, 5), equalTo(false));
    }


    @Test
    public void test3() {
        final TreeNode root = new TreeNode(1, new TreeNode(2), null);

        assertThat(callMethod(root, 1), equalTo(false));
        assertThat(callMethod(root, 2), equalTo(false));
        assertThat(callMethod(root, 3), equalTo(true));
    }

}
