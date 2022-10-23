package me.surendra.leetcode.trees.breadth_first_search;

import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class SameTreeTest {

    private final SameTree sameTree = new SameTree();

    private boolean callMethod(final TreeNode treeNode1, final TreeNode treeNode2) {
        return sameTree.isSameTree(treeNode1, treeNode2);
    }

    private TreeNode createTreeNodeFrom(final Integer ...integers) {
        return BinaryTreeNodeCreator.fromPreOrder(integers);
    }

    @Test
    public void notSame1() {
        assertThat(callMethod(
            createTreeNodeFrom(null),
            createTreeNodeFrom(1)
        ), equalTo(false));

        assertThat(callMethod(
            createTreeNodeFrom(1),
            null
        ), equalTo(false));
    }

    @Test
    public void notSame2() {
        assertThat(callMethod(
            createTreeNodeFrom(1, 2, null),
            createTreeNodeFrom(1, null, 2)
            ), equalTo(false));
    }


    @Test
    public void same1() {
        assertThat(callMethod(
            createTreeNodeFrom(1),
            createTreeNodeFrom(1)
        ), equalTo(true));
    }

    @Test
    public void same2() {
        assertThat(callMethod(
            createTreeNodeFrom(1, 2, null),
            createTreeNodeFrom(1, 2, null)
        ), equalTo(true));
    }

    @Test
    public void same3() {
        assertThat(callMethod(
            createTreeNodeFrom(1, 2, 3),
            createTreeNodeFrom(1, 2, 3)
        ), equalTo(true));
    }

}
