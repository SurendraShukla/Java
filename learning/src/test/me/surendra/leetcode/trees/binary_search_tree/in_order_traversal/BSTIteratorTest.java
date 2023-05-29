package me.surendra.leetcode.trees.binary_search_tree.in_order_traversal;

import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class BSTIteratorTest {

    private TreeNode getTreeNode() {
        final TreeNode right = new TreeNode(15, new TreeNode(9), new TreeNode(20));
        return new TreeNode(7, new TreeNode(3), right);
    }

    @Test
    public void bSTIteratorUsingRecursion() {
        final BSTIterator bstIterator = new BSTIteratorUsingRecursion(getTreeNode());

        callAndAssert(bstIterator);
    }

    @Test
    public void bSTIteratorUsingIteration() {
        final BSTIterator bstIterator = new BSTIteratorUsingIteration(getTreeNode());

        callAndAssert(bstIterator);
    }


    private void callAndAssert(final BSTIterator bstIterator) {
        final List<String> methodsWithReturnVal = Arrays.asList(
            "next_" + 3, "next_" + 7, "hasNext_" + 1, "next_" + 9,
            "hasNext_" + 1, "next_" + 15, "hasNext_" + 1, "next_" + 20, "hasNext_" + 0
        );
        for (final String methodWithReturnVal : methodsWithReturnVal) {
            final String[] methodAndReturnVal = methodWithReturnVal.split("_");
            if (methodAndReturnVal[0].equals("next")) {
                assertThat(bstIterator.next(), equalTo(Integer.valueOf(methodAndReturnVal[1])));
            }else{
                assertThat(bstIterator.hasNext(), equalTo(methodAndReturnVal[1].equals("1")));
            }
        }
    }

}
