package me.surendra.leetcode.design;

import me.surendra.leetcode.linked_list.doubly.DoublyLinkList;

import java.util.HashMap;
import java.util.Map;


/**
 * @see <a href="https://leetcode.com/problems/lru-cache/">LRU Cache</a>
 */
class LRUCache {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    int capacity;
    DoublyLinkList head;
    DoublyLinkList tail;
    Map<Integer, DoublyLinkList> cache;
    LRUCache(final int capacity) {

        this.capacity = capacity;
        cache = new HashMap<>();

        head = new DoublyLinkList(-1, -1);
        tail = new DoublyLinkList(-2, -2);

        head.next = tail;
        tail.prev = head;
    }

    void remove(final DoublyLinkList currentNode) {
        final DoublyLinkList prevNode = currentNode.prev;
        final DoublyLinkList nextNode = currentNode.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    void add(final DoublyLinkList currentNode) {
        final DoublyLinkList prevNode = tail.prev;

        currentNode.prev = prevNode;
        prevNode.next = currentNode;

        currentNode.next = tail;
        tail.prev = currentNode;
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int get(final int key) {
        if (cache.containsKey(key)) {
            final DoublyLinkList currentNode = cache.get(key);
            remove(currentNode);
            add(currentNode);
            return currentNode.val;
        }
        return -1;
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public void put(final int key, final int value) {
        if (cache.containsKey(key)) {
            final DoublyLinkList currentNode = cache.get(key);
            currentNode.val = value;
            remove(currentNode);
            add(currentNode);
        } else {
            final DoublyLinkList currentNode = new DoublyLinkList(key, value);
            cache.put(key, currentNode);
            add(currentNode);
        }

        if (cache.size() > capacity) {
            final DoublyLinkList removeNode = head.next;
            remove(removeNode);
            cache.remove(removeNode.key);
        }
    }

}

