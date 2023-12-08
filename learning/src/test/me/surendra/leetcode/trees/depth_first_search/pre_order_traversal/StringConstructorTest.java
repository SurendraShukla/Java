package me.surendra.leetcode.trees.depth_first_search.pre_order_traversal;

import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class StringConstructorTest {

    private String callMethod(final Integer ...numbers) {
        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(numbers);

        return new StringConstructor().tree2str(treeNode);
    }

    @Test
    public void test() {
        assertThat(callMethod(1, 2, 3, 4), equalTo("1(2(4))(3)"));
        assertThat(callMethod(1, 2, 3, null, 4), equalTo("1(2()(4))(3)"));
        assertThat(callMethod(1, null, 2, 3, null), equalTo("1()(2(3))"));
    }

}
