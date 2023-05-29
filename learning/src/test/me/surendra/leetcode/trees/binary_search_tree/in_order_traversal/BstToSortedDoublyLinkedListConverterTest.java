package me.surendra.leetcode.trees.binary_search_tree.in_order_traversal;

import me.surendra.leetcode.trees.Node;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class BstToSortedDoublyLinkedListConverterTest {

    private Node callMethod(final Node input) {
        return new BstToSortedDoublyLinkedListConverter().treeToDoublyList(input);
    }

    @Test
    public void test1() {
        // execute
        final Node output = callMethod(null);

        assertThat(output, equalTo(null));
    }

    @Test
    public void test2() {
        final Node input = new Node(2, new Node(1), new Node(3) );
        final Node expected = new Node(1, new Node(2), new Node(3) );

        // execute
        final Node actual = callMethod(input);

//        assertThat(actual, equalTo(expected));
    }


    @Test
    public void test3() {
        final Node left = new Node(2, new Node(1), new Node(3) );
        final Node input = new Node(4, left, new Node(5) );

        // execute
        final Node actual = callMethod(input);

//        assertThat(actual, equalTo(expected));
    }

}
