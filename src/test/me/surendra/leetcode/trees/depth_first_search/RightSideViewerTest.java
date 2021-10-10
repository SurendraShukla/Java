package me.surendra.leetcode.trees.depth_first_search;

import me.surendra.TestUtil;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class RightSideViewerTest {

    private List<Integer> callMethod(final TreeNode treeNode) {
        return new RightSideViewer().rightSideView(treeNode);
    }

    @Test
    public void test1() {
        final TreeNode left = new TreeNode(2, null, new TreeNode(5));
        final TreeNode right= new TreeNode(3, null, new TreeNode(4));
        final TreeNode treeNode = new TreeNode(1, left, right);
        final List<Integer> expectedList = Arrays.asList(1,3,4);

        // execute
        final List<Integer> actual = callMethod(treeNode);

        TestUtil.assertion(actual, expectedList);
    }

    @Test
    public void test2() {
        final TreeNode treeNode = new TreeNode(1, null, new TreeNode(3));
        final List<Integer> expectedList = Arrays.asList(1,3);

        // execute
        final List<Integer> actual = callMethod(treeNode);

        TestUtil.assertion(actual, expectedList);
    }

    @Test
    public void test3() {
        final List<Integer> expectedList = Arrays.asList();

        // execute
        final List<Integer> actual = callMethod(null);

        TestUtil.assertion(actual, expectedList);
    }

    @Test
    public void test4() {
//        [1,2,3,4,null,5,6,7,8,9,null,null,null,11,null,13,null,null,null,null,14]
    }
}
