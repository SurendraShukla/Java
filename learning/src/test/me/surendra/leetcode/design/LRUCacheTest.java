package me.surendra.leetcode.design;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class LRUCacheTest {

    @Test
    public void test1() {
        final LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);

        assertThat(lruCache.get(1), equalTo(1));
        lruCache.put(3, 3);

        assertThat(lruCache.get(2), equalTo(-1));
        lruCache.put(4, 4);

        assertThat(lruCache.get(1), equalTo(-1));
        assertThat(lruCache.get(3), equalTo(3));
        assertThat(lruCache.get(4), equalTo(4));
    }


    @Test
    public void test2() {
        final LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(2, 2);

        assertThat(lruCache.get(2), equalTo(2));
        lruCache.put(1, 1);
        lruCache.put(4, 1);

        assertThat(lruCache.get(2), equalTo(-1));
    }


    @Test
    public void test3() {
        final LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);

        assertThat(lruCache.get(1), equalTo(-1));
        assertThat(lruCache.get(2), equalTo(3));
    }

}
