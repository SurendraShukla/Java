package me.surendra.leetcode.trees.depth_first_search;

import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class PathSumFinderTest {

    private final PathSumFinder pathSumFinder = new PathSumFinder();

    private boolean callMethod(final Integer[] integers, final int targetSum) {
        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(integers);

        return pathSumFinder.hasPathSumUsingRecursion(treeNode, targetSum);
    }

    @Test
    public void test1() {
        final Integer[] integers = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};

        assertThat(callMethod(integers, 22), equalTo(true));
        assertThat(callMethod(integers, 23), equalTo(false));
    }


    @Test
    public void test2() {
        final Integer[] integers = new Integer[]{1, 2, 3};

        assertThat(callMethod(integers, 3), equalTo(true));
        assertThat(callMethod(integers, 4), equalTo(true));
        assertThat(callMethod(integers, 5), equalTo(false));
    }


    @Test
    public void test3() {
        final Integer[] integers = new Integer[]{1, 2, null};

        assertThat(callMethod(integers, 1), equalTo(false));
        assertThat(callMethod(integers, 2), equalTo(false));
        assertThat(callMethod(integers, 3), equalTo(true));
    }

}
