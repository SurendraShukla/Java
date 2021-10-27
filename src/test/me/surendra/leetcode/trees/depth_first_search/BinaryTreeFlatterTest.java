package me.surendra.leetcode.trees.depth_first_search;

import com.google.common.collect.Lists;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class BinaryTreeFlatterTest {

    private void callMethod(final TreeNode treeNode) {
//        new BinaryTreeFlatter().flattenUsingList(treeNode);
        new BinaryTreeFlatter().flattenUsingDummyNode(treeNode);
    }

    @Test
    public void test1() {
        callMethod(null);

        assertThat(null, equalTo(null));
    }

    @Test
    public void test2() {
        final TreeNode treeNode = new TreeNode(0);

        callMethod(treeNode);

        assertThat(treeNode, equalTo(treeNode));
    }

    @Test
    public void test3() {
        final TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        callMethod(treeNode);

        final TreeNode expected = from(Lists.newArrayList(1, 2, 3));
        assertThat(treeNode, equalTo(expected));
    }

    @Test
    public void test4() {
        final TreeNode left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        final TreeNode right = new TreeNode(5, null, new TreeNode(6));
        final TreeNode treeNode = new TreeNode(1, left, right);

        callMethod(treeNode);

        final TreeNode expected = from(Lists.newArrayList(1, 2, 3, 4, 5, 6));
        assertThat(treeNode, equalTo(expected));
    }

    private TreeNode from(final List<Integer> integerList) {
        TreeNode previousRightNode = null;
        TreeNode treeNode = null;
        for (int i = integerList.size()-1; i >= 0; i--) {
            treeNode = new TreeNode(integerList.get(i), null, previousRightNode);
            previousRightNode = treeNode;
        }
        return treeNode;
    }

}
