package me.surendra.leetcode.trees.depth_first_search;

import me.surendra.leetcode.trees.TreeNode;
import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CountUniValueSubtreesFinderTest {

    private int callMethod(final List<Integer> treeValues) {
        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(treeValues);

        return new CountUniValueSubtreesFinder().countUniValSubtrees(treeNode);
    }

    @Test
    public void singleNode() {
        assertThat(callMethod(null), equalTo(0));

        assertThat(callMethod(newArrayList(1)), equalTo(1));
        assertThat(callMethod(newArrayList(1, 1, null)), equalTo(2));
        assertThat(callMethod(newArrayList(1, null, 1)), equalTo(2));
        assertThat(callMethod(newArrayList(1, 1, 1)), equalTo(3));
        assertThat(callMethod(newArrayList(1, 2, 3)), equalTo(2));
    }

    @Test
    public void multipleNode() {
        assertThat(callMethod(newArrayList(5, 1, 3, 1, 1, 1, null)), equalTo(4));
        assertThat(callMethod(newArrayList(5, 1, 5, 5, 5, null, 5)), equalTo(4));
        assertThat(callMethod(newArrayList(1, 1, 1, 5, 5, null, 5)), equalTo(3));
        assertThat(callMethod(newArrayList(5, 5, 5, 5, 5, null, 5)), equalTo(6));
    }

}
