package me.surendra.leetcode.trees.breadth_first_search;

import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class MaximumDepthFinderTest {

    private int callMethod(final TreeNode root) {
        return new MaximumDepthFinder().getMaxDepthUsingRecursion(root);
//        return new MaximumDepthFinder().getMaxDepthUsingIteration(root);
    }

    @Test
    public void test1() {
        final TreeNode left = new TreeNode(9);
        final TreeNode right= new TreeNode(20, new TreeNode(15), new TreeNode(7));
        final TreeNode root= new TreeNode(3, left, right);

        assertThat(callMethod(root), equalTo(3));
    }

    @Test
    public void test2() {
        final TreeNode root= new TreeNode(1, null, new TreeNode(2));

        assertThat(callMethod(root), equalTo(2));
    }

    @Test
    public void test3() {
        assertThat(callMethod(null), equalTo(0));
    }

    @Test
    public void test4() {
        assertThat(callMethod(new TreeNode(0)), equalTo(1));
    }

}
