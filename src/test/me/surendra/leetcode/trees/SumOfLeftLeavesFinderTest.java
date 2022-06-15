package me.surendra.leetcode.trees;


import com.google.common.collect.Lists;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class SumOfLeftLeavesFinderTest {

    private int constructTreeAndCallMethod(final List<Integer> nums) {
        final TreeNode treeNode = TreeCreator.fromPreOrder(nums);

//        return new SumOfLeftLeavesFinder().sumOfLeftLeaves(treeNode);
        return new SumOfLeftLeavesFinder().sumOfLeftLeavesWithoutGlobalVariable(treeNode);
    }

    @Test
    public void sumOfLeftTreeIs24() {
        final List<Integer> nums = Lists.newArrayList(3, 9, 20, null, null, 15, 7);

        assertThat(constructTreeAndCallMethod(nums), equalTo(24));
    }

    @Test
    public void sumOfLeftTreeIsForRootOnlyNode() {
        final List<Integer> nums = Lists.newArrayList(1);

        assertThat(constructTreeAndCallMethod(nums), equalTo(0));
    }

}
