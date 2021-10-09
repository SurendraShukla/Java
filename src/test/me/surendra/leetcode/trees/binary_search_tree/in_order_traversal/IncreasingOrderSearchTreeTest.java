package me.surendra.leetcode.trees.binary_search_tree.in_order_traversal;

import com.google.common.collect.Lists;
import me.surendra.leetcode.trees.TreeNode;
import org.junit.Test;

import java.util.List;


public class IncreasingOrderSearchTreeTest {

    @Test
    public void test1() {
        final List<Integer> arrayList = Lists.newArrayList(5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9);
        final TreeNode node8 = new TreeNode(8, new TreeNode(7), new TreeNode(9));
        final TreeNode node6 = new TreeNode(6, null, node8);

        final TreeNode node2 = new TreeNode(2, new TreeNode(1), null);
        final TreeNode node3 = new TreeNode(3, node2, new TreeNode(4));

        final TreeNode node5 = new TreeNode(5, node3, node6);

        // execute
        final TreeNode treeNode = new IncreasingOrderSearchTree().increasingBST(node5);

        System.out.println(treeNode);

    }
}
