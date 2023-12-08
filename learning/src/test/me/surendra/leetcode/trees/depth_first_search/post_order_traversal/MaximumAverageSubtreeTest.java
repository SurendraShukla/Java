package me.surendra.leetcode.trees.depth_first_search.post_order_traversal;


import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class MaximumAverageSubtreeTest {

    private double callMethod(final Integer ...numbers) {
        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(numbers);

        return new MaximumAverageSubtree().maximumAverageSubtree(treeNode);
    }

    @Test
    public void test() {
        assertThat(callMethod(5, 6, 1), equalTo(6.00000));
        assertThat(callMethod(0, null, 1), equalTo(1.00000));
        assertThat(callMethod(55, 9, 7), equalTo(23.666666666666668));
    }
}
