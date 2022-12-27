package me.surendra.leetcode.trees.depth_first_search.pre_order_traversal;

import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class MaximumDifferenceBetweenNodeAndAncestorTest {

    private final MaximumDifferenceBetweenNodeAndAncestor unit = new MaximumDifferenceBetweenNodeAndAncestor();

    private int callMethod(final Integer[] numbers) {
        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(numbers);

        return unit.maxAncestorDiff(treeNode);
    }

    @Test
    public void test1() {
        assertThat(callMethod(
            new Integer[]{8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13}),
            equalTo(7)
        );

        assertThat(callMethod(
                new Integer[]{1, null, 2, null, 0, 3}),
            equalTo(7)
        );
    }

}
