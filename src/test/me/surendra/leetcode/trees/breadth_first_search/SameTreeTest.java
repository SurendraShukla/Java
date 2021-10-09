package me.surendra.leetcode.trees.breadth_first_search;

import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class SameTreeTest {

    private boolean callMethod(final TreeNode treeNode1, final TreeNode treeNode2) {
        return new SameTree().isSameTree(treeNode1, treeNode2);
    }

    @Test
    public void notSame1() {
        assertThat(callMethod(
            null,
            new TreeNode(1)
        ), equalTo(false));

        assertThat(callMethod(
            new TreeNode(1),
            null
        ), equalTo(false));
    }

    @Test
    public void notSame2() {
        assertThat(callMethod(
            new TreeNode(1, new TreeNode(2), null),
            new TreeNode(1,null, new TreeNode(2))
            ), equalTo(false));
    }


    @Test
    public void same1() {
        assertThat(callMethod(
            new TreeNode(1),
            new TreeNode(1)
        ), equalTo(true));
    }

    @Test
    public void same2() {
        assertThat(callMethod(
            new TreeNode(1, new TreeNode(2),null),
            new TreeNode(1, new TreeNode(2), null)
        ), equalTo(true));
    }

    @Test
    public void same3() {
        assertThat(callMethod(
            new TreeNode(1, new TreeNode(2), new TreeNode(3)),
            new TreeNode(1, new TreeNode(2), new TreeNode(3))
        ), equalTo(true));
    }

}
