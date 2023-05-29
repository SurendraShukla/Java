package me.surendra.leetcode.linked_list.doubly;

import org.junit.Test;

public class LRUCacheTest {

    @Test
    public void test() {
        final LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);

        lruCache.get(1);

        lruCache.put(3, 3);

        lruCache.get(2);
    }
}
