package me.surendra.leetcode.trees;


import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class GoodNodeCounterTest {

    private int callMethod(final List<Integer> treeValues) {
        final TreeNode root = BinaryTreeNodeCreator.fromPreOrder(treeValues);

//        return new GoodNodeCounter().goodNodesUsingMaxVar(root);
        return new GoodNodeCounter().goodNodesUsingStack(root);
    }

    @Test
    public void test1() {
        final List<Integer> treeValues = Lists.newArrayList(3, 4, 4, 4, 4, 4, 4);

        assertThat(callMethod(treeValues), equalTo(7));
    }

    @Test
    public void test2() {
        final List<Integer> treeValues = Lists.newArrayList(3, 1, 4, 3, null, 1, 5);

        assertThat(callMethod(treeValues), equalTo(4));
    }

    @Test
    public void test3() {
        final List<Integer> treeValues = Lists.newArrayList(3, 3, null, 4, 2);

        assertThat(callMethod(treeValues), equalTo(3));
    }

    @Test
    public void test4() {
        final List<Integer> treeValues = Lists.newArrayList(1);

        assertThat(callMethod(treeValues), equalTo(1));
    }

}
