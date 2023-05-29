package me.surendra.leetcode.trees;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class SortedArrayToBstConvertorTest {

    private final SortedArrayToBstConvertor sortedArrayToBstConvertor = new SortedArrayToBstConvertor();

    private TreeNode callMethod(final int[] nums) {
        return sortedArrayToBstConvertor.sortedArrayToBST(nums);
    }

    @Test
    public void test1() {
        final int[] nums = {-10, -3, 0, 5, 9};

        final TreeNode actual = callMethod(nums);

//        final TreeNode expected1 = BinaryTreeNodeCreator.fromPreOrder(0, -3, 9, -10, null, 5);
        final TreeNode expected2 = BinaryTreeNodeCreator.fromPreOrder(0, -10, 5, null, -3, null, 9);
        assertThat(actual, equalTo(expected2));
    }

    @Test
    public void test2() {
        final int[] nums = {1, 3};

        final TreeNode actual = callMethod(nums);

//        final TreeNode expected1 = BinaryTreeNodeCreator.fromPreOrder(3, 1);
        final TreeNode expected2 = BinaryTreeNodeCreator.fromPreOrder(1, null, 3);
        assertThat(actual, equalTo(expected2));
    }

}
