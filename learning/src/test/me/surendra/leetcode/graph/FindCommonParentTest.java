package me.surendra.leetcode.graph;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class FindCommonParentTest {

    private boolean callMethod(final int[][] parentChildPair, final int child1, final int child2) {
        return new FindCommonParent().hasCommonAncestor(parentChildPair, child1, child2);
    }

    @Test
    public void test1() {
        /*
                         14  13
                         |   |
                1   2    4   12
                 \ /   / | \ /
                  3   5  8  9
                   \ / \     \
                    6   7     11
         */
        final int[][] parentChildPair = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},{4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9}};

        assertThat(callMethod(parentChildPair, 3, 8), equalTo(false));
        assertThat(callMethod(parentChildPair, 5, 8), equalTo(true));
        assertThat(callMethod(parentChildPair, 6, 8), equalTo(true));
        assertThat(callMethod(parentChildPair, 6, 9), equalTo(true));
        assertThat(callMethod(parentChildPair, 1, 3), equalTo(false));
        assertThat(callMethod(parentChildPair, 3, 1), equalTo(false));
        assertThat(callMethod(parentChildPair, 7, 11), equalTo(true));
        assertThat(callMethod(parentChildPair, 6, 5), equalTo(true));
        assertThat(callMethod(parentChildPair, 5, 6), equalTo(true));
    }

    @Test
    public void test2() {
        /*
                        11
                       /  \
                      10   12
                     /  \
                1   2    5
                 \ /    / \
                  3    6   7
                   \        \
                    4        8
         */
        final int[][] parentChildPair = {{11, 10}, {11, 12}, {2, 3}, {10, 2}, {10, 5}, {1, 3}, {3, 4}, {5, 6}, {5, 7}, {7, 8}};

        assertThat(callMethod(parentChildPair, 4, 12), equalTo(true));
        assertThat(callMethod(parentChildPair, 1, 6), equalTo(false));
        assertThat(callMethod(parentChildPair, 1, 12), equalTo(false));
    }

}
