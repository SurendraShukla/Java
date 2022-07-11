package me.surendra.leetcode.trees.depth_first_search;

import me.surendra.TestUtil;
import me.surendra.leetcode.trees.TreeNode;
import me.surendra.leetcode.trees.TreeNodeCreator;
import org.assertj.core.util.Lists;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;


public class RightSideViewerTest {

    private List<Integer> callMethod(final List<Integer> treeValuesList) {
        final TreeNode treeNode = TreeNodeCreator.fromPreOrder(treeValuesList);

        return new RightSideViewer().rightSideView(treeNode);
    }

    @Test
    public void nullNode() {
        // execute
        final List<Integer> actual = callMethod(null);

        assertThat(actual, Matchers.equalTo(Lists.emptyList()));
    }

    @Test
    public void singleNode() {
        final List<Integer> treeValuesList = Lists.newArrayList(1, null, 3);
        final List<Integer> expectedList = Arrays.asList(1, 3);

        // execute
        final List<Integer> actual = callMethod(treeValuesList);

        assertThat(actual, Matchers.equalTo(expectedList));
    }


    @Test
    public void test1() {
        final List<Integer> treeValuesList = Lists.newArrayList(1, 2, 3, null, 5, null, 4);
        final List<Integer> expectedList = Arrays.asList(1, 3, 4);

        // execute
        final List<Integer> actual = callMethod(treeValuesList);

        assertThat(actual, Matchers.equalTo(expectedList));
    }

    @Test
    public void test4() {
        final List<Integer> treeValuesList = Lists.newArrayList(
            1, 2, 3, 4, null, 5, 6, 7, 8, 9, null, null, null, 11, null, 13, null, null, null, null, 14
        );

        // execute
        final List<Integer> actual = callMethod(treeValuesList);

        assertThat(actual, Matchers.equalTo(null));
    }
}
