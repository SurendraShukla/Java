package me.surendra.leetcode.linked_list.doubly;


public class DoublyLinkList {
    int key;
    int value;
    DoublyLinkList prev;
    DoublyLinkList next;

    // Constructor to create a new node
    // next and prev is by default initialized as null
    DoublyLinkList(final int key, final int value) {
        this.key = key;
        this.value = value;
    }
}
