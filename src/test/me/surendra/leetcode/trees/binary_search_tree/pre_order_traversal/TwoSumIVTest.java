package me.surendra.leetcode.trees.binary_search_tree.pre_order_traversal;


import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class TwoSumIVTest {

    final TwoSumIV twoSumIV = new TwoSumIV();

    private boolean callMethod(final Integer[] integers, final int k) {
        final TreeNode root = BinaryTreeNodeCreator.fromPreOrder(integers);
        return twoSumIV.findTargetWhileTraversing(root, k);
//        return twoSumIV.findTargetAfterTraversing(root, k);
    }

    @Test
    public void test() {
        final Integer[] integers = {5, 3, 6, 2, 4, null, 7};
        assertThat(
            callMethod(integers, 9),
            equalTo(true)
        );

        assertThat(
            callMethod(integers, 28),
            equalTo(false)
        );
    }

}
