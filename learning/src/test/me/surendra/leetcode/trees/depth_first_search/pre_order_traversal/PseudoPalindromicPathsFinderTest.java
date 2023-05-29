package me.surendra.leetcode.trees.depth_first_search.pre_order_traversal;

import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PseudoPalindromicPathsFinderTest {

    private int callMethod(final Integer ...integers) {
        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(integers);

        return new PseudoPalindromicPathsFinder().pseudoPalindromicPaths(treeNode);
//        return new PseudoPalindromicPathsFinder().pseudoPalindromicPathsUsingBitWiseOperator(treeNode);
    }

    @Test
    public void test() {
        assertThat(callMethod(9), equalTo(1));

        assertThat(
            callMethod(2, 3, 1, 3, 1, null, 1),
            equalTo(2)
        );

        assertThat(
            callMethod(2, 3, 1, 3, 2, null, 1),
            equalTo(3)
        );

        assertThat(
            callMethod(2, 3, 1, 3, 3, null, 1),
            equalTo(3)
        );

        assertThat(
            callMethod(2, 1, 1, 1, 3, null, null, null, null, null, 1),
            equalTo(1)
        );
    }

}
