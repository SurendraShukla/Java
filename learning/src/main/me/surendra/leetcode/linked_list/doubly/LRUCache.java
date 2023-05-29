package me.surendra.leetcode.linked_list.doubly;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/lru-cache/">LRU Cache</a>
 */
public class LRUCache {

    int cacheSize;
    DoublyLinkList lru = new DoublyLinkList(-1, -1);
    DoublyLinkList mru = new DoublyLinkList(100001, 100001);
    Map<Integer, DoublyLinkList> dllMap = new HashMap<>();

    LRUCache(final int capacity) {
        cacheSize = capacity;
        lru.next = mru;
        mru.prev = lru;
    }

    public int get(final int key) {
        System.out.println("get=[" + key + "]");
        if (dllMap.containsKey(key)) {
            final DoublyLinkList removedDll = dllMap.get(key);
            deLink(removedDll);
            linkToMru(removedDll);
            return removedDll.value;
        }
        return -1;
    }

    private void linkToMru(final DoublyLinkList mruNode) {
        final DoublyLinkList secondMruNode = mru.prev;
        secondMruNode.next = mruNode;

        mruNode.prev = secondMruNode;
        mruNode.next = mru;

        mru.prev = mruNode;
    }

    private void deLink(final DoublyLinkList removedDll) {
        System.out.println("key=[" + removedDll.key + "] val=[" + removedDll.value + "]");
        // Remove from
        final DoublyLinkList prevNode = removedDll.prev;
        final DoublyLinkList nextNode = removedDll.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        removedDll.prev = null;
        removedDll.next = null;
    }

    private void deleteLruNode() {
        final DoublyLinkList nodeToDelete = lru.next;
        final DoublyLinkList nextNode = nodeToDelete.next;

        dllMap.remove(nodeToDelete);

        nodeToDelete.next = null;
        nodeToDelete.prev = null;

        lru.next = nextNode;
        nextNode.prev = lru;
    }

    private void createFirstNode(final DoublyLinkList firstNode) {
        lru.next = firstNode;
        mru.prev = firstNode;

        firstNode.prev = lru;
        firstNode.next = mru;

        System.out.println("FirsNode=[" + firstNode.value + "] " +
            "prev=[" + firstNode.prev.value + "] " +
            "next=[" + firstNode.next.value + "]");
    }

    public void put(final int key, final int value) {
        System.out.println("put=[" + key + "]:[" + value + "]");
        if (dllMap.isEmpty()) {
            final DoublyLinkList doublyLinkList = new DoublyLinkList(key, value);
            dllMap.put(key, doublyLinkList);
            createFirstNode(doublyLinkList);
            return;
        }
        if (dllMap.containsKey(key)) {
            final DoublyLinkList removedDll = dllMap.get(key);
            removedDll.value = value;
            deLink(removedDll);
            linkToMru(removedDll);
        } else {
            final DoublyLinkList doublyLinkList = new DoublyLinkList(key, value);
            dllMap.put(key, doublyLinkList);
            linkToMru(doublyLinkList);
        }
        if (dllMap.size() > cacheSize) {
            deleteLruNode();
        }
    }

}
