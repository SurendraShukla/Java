package me.surendra.leetcode.trees.breadth_first_search.pre_order_traversal;


import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class AverageOfLevelFinderTest {

    private TreeNode callMethod(final Integer ...integers) {
        return BinaryTreeNodeCreator.fromPreOrder(integers);
    }

    @Test
    public void test1() {
        final TreeNode treeNode = callMethod(3, 9, 20, null, null, 15, 7);

        // execute
        final List<Double> actual = new AverageOfLevelFinder().averageOfLevels(treeNode);

        final List<Double> expected = Lists.newArrayList(3.00000, 14.50000, 11.00000);
        assertThat(actual, equalTo(expected));
    }


    @Test
    public void test2() {
        final TreeNode treeNode = callMethod(3, 9, 20, 15, 7);

        // execute
        final List<Double> actual = new AverageOfLevelFinder().averageOfLevels(treeNode);

        final List<Double> expected = Lists.newArrayList(3.00000, 14.50000, 11.00000);
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test3() {
        final TreeNode treeNode = callMethod(2147483647, 2147483647, 2147483647);

        // execute
        final List<Double> actual = new AverageOfLevelFinder().averageOfLevels(treeNode);

        final List<Double> expected = Lists.newArrayList(2147483647.00000, 2147483647.00000);
        assertThat(actual, equalTo(expected));
    }

}
