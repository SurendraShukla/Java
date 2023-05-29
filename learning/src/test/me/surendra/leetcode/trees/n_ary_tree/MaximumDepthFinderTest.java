package me.surendra.leetcode.trees.n_ary_tree;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class MaximumDepthFinderTest {

    private int callMethod(final Integer ...integers) {
        final Node nAryTreeNode = NaryTreeCreator.from(integers);

        return new MaximumDepthFinder().maxDepth(nAryTreeNode);
    }

    @Test
    public void test() {
        assertThat(callMethod(1, null, 3, 2, 4, null, 5, 6), equalTo(3));
        assertThat(callMethod(1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14), equalTo(5));
    }

}
