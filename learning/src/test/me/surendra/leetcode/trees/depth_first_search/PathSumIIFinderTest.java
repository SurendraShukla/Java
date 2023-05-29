package me.surendra.leetcode.trees.depth_first_search;


import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PathSumIIFinderTest {

    private final PathSumIIFinder pathSumIIFinder = new PathSumIIFinder();

    private List<List<Integer>> callMethod(final int targetSum, final Integer[] integers) {
        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(integers);
        return pathSumIIFinder.pathSum(treeNode, targetSum);
    }

    @Test
    public void test() {
        final List<List<Integer>> actual = callMethod(22, new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        final List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(5, 4, 11, 2),
            Arrays.asList(5, 8, 4, 5)
        );

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test1() {
        final List<List<Integer>> actual = callMethod(5, new Integer[]{1, 2, 3});
        final List<List<Integer>> expected = new ArrayList(
            new ArrayList()
        );

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test2() {
        final List<List<Integer>> actual = callMethod(0, new Integer[]{1, 2});
        final List<List<Integer>> expected = new ArrayList(
            new ArrayList()
        );

        assertThat(actual, equalTo(expected));
    }

    @Test
    public void targetSumLessThan0() {
        final List<List<Integer>> actual = callMethod(-1, new Integer[]{1, -2, -3, 1, 3, -2, null, -1});
        final List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(1, -2, 1, -1)
        );

        assertThat(actual, equalTo(expected));
    }

}
