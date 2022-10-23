package me.surendra.leetcode.trees.breadth_first_search;

import me.surendra.leetcode.trees.TreeNode;
import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class MaximumDepthFinderTest {

    private int callMethod(final Integer ...numbers) {
        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(numbers);

//        return new MaximumDepthFinder().getMaxDepth(treeNode);
        return new MaximumDepthFinder().maxDepthCalculationAtLeafNode(treeNode);
//        return new MaximumDepthFinder().getMaxDepthUsingIteration(root);
    }

    @Test
    public void test1() {
        assertThat(callMethod(3, 9, 20, null, null, 15, 7), equalTo(3));
        assertThat(callMethod(1, null, 2), equalTo(2));
        assertThat(callMethod(null), equalTo(0));
        assertThat(callMethod(0), equalTo(1));
    }

}
