package me.surendra.leetcode.trees.breadth_first_search.pre_order_traversal;

import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class VerticalOrderTraversalWithSortingTest {

    private List<List<Integer>> callMethod(final Integer ...integers) {
        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(integers);

        return new VerticalOrderTraversalWithSorting().verticalOrder(treeNode);
    }

    @Test
    public void test1() {
        final List<List<Integer>> actual = callMethod(3, 9, 20, null, null, 15, 7);

        final List<List<Integer>> expected = asList(
            asList(9), asList(3, 15), asList(20), asList(7)
        );
        assertThat(actual, equalTo(expected));
    }


    @Test
    public void test2() {
        final List<List<Integer>> actual = callMethod(1, 2, 3, 4, 5, 6, 7);

        final List<List<Integer>> expected = asList(
            asList(4), asList(2), asList(1, 5, 6), asList(3), asList(7)
        );
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test3() {
        final List<List<Integer>> actual = callMethod(1, 2, 3, 4, 6, 5, 7);

        final List<List<Integer>> expected = asList(
            asList(4), asList(2), asList(1, 5, 6), asList(3), asList(7)
        );
        assertThat(actual, equalTo(expected));
    }

}
