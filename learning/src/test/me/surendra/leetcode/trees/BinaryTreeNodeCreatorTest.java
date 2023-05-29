package me.surendra.leetcode.trees;


import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

public class BinaryTreeNodeCreatorTest {

    @Test
    public void fromPreOrder1() {
        final List<Integer> nums = Lists.newArrayList(1);

        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(nums);

        System.out.println(treeNode);
    }

    @Test
    public void fromPreOrder2() {
        final List<Integer> nums = Lists.newArrayList(3, 9, 20, null, null, 15, 7);

        final TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(nums);

        System.out.println(treeNode);
    }
}
