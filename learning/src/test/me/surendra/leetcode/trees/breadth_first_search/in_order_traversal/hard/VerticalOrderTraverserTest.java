package me.surendra.leetcode.trees.breadth_first_search.in_order_traversal.hard;


import com.google.common.collect.Lists;
import me.surendra.leetcode.trees.BinaryTreeNodeCreator;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class VerticalOrderTraverserTest {

    private List<List<Integer>> callMethod(final List<Integer> treeValues) {
        TreeNode treeNode = BinaryTreeNodeCreator.fromPreOrder(treeValues);

        return new VerticalOrderTraverser().verticalTraversalUsingRecursion(treeNode);
    }

    @Test
    public void basicExample() {
        System.out.println("(()".substring(0, 2));
        List<Integer> treeValues = Lists.newArrayList(3,9,20,null,null,15,7);

        final List<List<Integer>> returnList = callMethod(treeValues);

        final String actual = returnList.toString();
        final String expected = "[[9], [3, 15], [20], [7]]";
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void containsInodesValuesShouldBeSortedForOrderedInput() {
        List<Integer> treeValues = Lists.newArrayList(1,2,3,4,5,6,7);

        final List<List<Integer>> returnList = callMethod(treeValues);

        final String actual = returnList.toString();
        final String expected = "[[4], [2], [1, 5, 6], [3], [7]]";
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void nodesValuesShouldBeSortedForNonOrderedInput() {
        List<Integer> treeValues = Lists.newArrayList(1,2,3,4,6,5,7);

        final List<List<Integer>> returnList = callMethod(treeValues);

        final String actual = returnList.toString();
        final String expected = "[[4], [2], [1, 5, 6], [3], [7]]";
        assertThat(actual, equalTo(expected));
    }

//    @Test
    public void nodeValuesAreNotEqualAtColumn() {
        List<Integer> treeValues = Lists.newArrayList(3,1,4,0,2,2);

        final List<List<Integer>> returnList = callMethod(treeValues);
        System.out.println(returnList);

        final String actual = returnList.toString();
        final String expected = "[[4], [2], [1, 5, 6], [3], [7]]";
        assertThat(actual, equalTo(expected));
    }
}

