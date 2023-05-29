package me.surendra.leetcode.trees.breadth_first_search;

import me.surendra.leetcode.trees.Node;
import org.junit.Test;

public class NextRightPointerPopulatorTest {

    private Node callMethod(final Node root) {
        return new NextRightPointerPopulator().connectUsingQueue(root);
    }

    @Test
    public void test1() {
        final Node left = new Node(2, new Node(4), new Node(5));
        final Node right = new Node(3, new Node(6), new Node(7));
        final Node root = new Node(1, left, right);

        callMethod(root);
    }

}
