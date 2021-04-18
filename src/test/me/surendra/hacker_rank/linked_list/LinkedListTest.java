package me.surendra.hacker_rank.linked_list;

import org.junit.Test;

import static me.surendra.hacker_rank.linked_list.LinkedList.removeDuplicates;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class LinkedListTest {

    @Test
    public void shouldRemoveDuplicateValuesFromLinkedList() {
        final int[] intArray = {1, 2, 2, 3, 3, 4};
        final Node linkedLists = LinkedList.from(intArray);

        // execute
        final Node actual = removeDuplicates(linkedLists);

        final int[] expectedList = {1, 2, 3, 4};
        final Node expectedLinkedList = LinkedList.from(expectedList);
        LinkedList.display(expectedLinkedList);
        assertThat(actual, equalTo(expectedLinkedList));
    }

    @Test
    public void noRemoveOfValuesFromLinkedList() {
        final int[] intArray = {1, 2, 3, 4};
        final Node linkedLists = LinkedList.from(intArray);

        // execute
        final Node actual = removeDuplicates(linkedLists);

        final int[] expectedList = {1, 2, 3, 4};
        final Node expectedLinkedList = LinkedList.from(expectedList);
        LinkedList.display(expectedLinkedList);
        assertThat(actual, equalTo(expectedLinkedList));
    }

}
