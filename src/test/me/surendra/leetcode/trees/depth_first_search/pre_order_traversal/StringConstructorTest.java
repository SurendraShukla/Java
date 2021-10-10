package me.surendra.leetcode.trees.depth_first_search.pre_order_traversal;

import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class StringConstructorTest {

    private String callMethod(final TreeNode treeNode) {
        return new StringConstructor().tree2str(treeNode);
    }

    @Test
    public void test1() {
        final TreeNode left = new TreeNode(2, new TreeNode(4), null);
        final TreeNode right = new TreeNode(3);
        final TreeNode treeNode = new TreeNode(1, left, right);

        assertThat(callMethod(treeNode), equalTo("1(2(4))(3)"));
    }

    @Test
    public void test2() {
        final TreeNode left = new TreeNode(2, null, new TreeNode(4));
        final TreeNode right = new TreeNode(3);
        final TreeNode treeNode = new TreeNode(1, left, right);

        assertThat(callMethod(treeNode), equalTo("1(2()(4))(3)"));
    }

    @Test
    public void test3() {
        final TreeNode right = new TreeNode(2, new TreeNode(3), null);
        final TreeNode treeNode = new TreeNode(1, null, right);

        assertThat(callMethod(treeNode), equalTo("1()(2(3))"));
    }

}
