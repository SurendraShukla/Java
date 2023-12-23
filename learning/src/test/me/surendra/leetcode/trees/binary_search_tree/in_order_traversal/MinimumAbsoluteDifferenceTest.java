package me.surendra.leetcode.trees.binary_search_tree.in_order_traversal;

import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class MinimumAbsoluteDifferenceTest {

    private static int callMethod(final Integer... integers) {
        final MinimumAbsoluteDifference minimumAbsoluteDifference = new MinimumAbsoluteDifference();

        final TreeNode root = BinaryTreeNodeCreator.fromPreOrder(integers);
        return minimumAbsoluteDifference.getMinimumDifference(root);
    }

    @Test
    public void test() {
        assertThat(callMethod(4, 2, 6, 1, 3), equalTo(1));
        assertThat(callMethod(1, 0, 48, null, null, 12, 49), equalTo(1));
        assertThat(callMethod(236, 104, 701, null, 227, null, 911), equalTo(9));
    }

}
