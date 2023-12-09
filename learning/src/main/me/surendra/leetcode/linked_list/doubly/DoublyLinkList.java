package me.surendra.leetcode.linked_list.doubly;


public class DoublyLinkList {

    public int key;
    public int val;
    public DoublyLinkList prev;
    public DoublyLinkList next;

    public DoublyLinkList(final int key, final int val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public String toString() {
        return "key=[" + key + "] val=[" + val + "] \n next=[" + next + "]";
    }

}
