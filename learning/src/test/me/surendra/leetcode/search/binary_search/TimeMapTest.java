package me.surendra.leetcode.search.binary_search;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class TimeMapTest {

    private TimeMap timeMap;

    @Before
    public void setUp() throws Exception {
//        timeMap = new TimeMapImplementationUsingBinarySearch();
        timeMap = new TimeMapImplementationUsingTreeMap();
    }

    @Test
    public void test1() {
        timeMap.set("foo", "bar", 1);
        assertThat(timeMap.get("foo", 1), equalTo("bar"));
        assertThat(timeMap.get("foo", 3), equalTo("bar"));

        timeMap.set("foo", "bar2", 4);
        assertThat(timeMap.get("foo", 4), equalTo("bar2"));
        assertThat(timeMap.get("foo", 5), equalTo("bar2"));
    }

    @Test
    public void test2() {
        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);

        assertThat(timeMap.get("love", 5), equalTo(""));
        assertThat(timeMap.get("love", 10), equalTo("high"));
        assertThat(timeMap.get("love", 15), equalTo("high"));
        assertThat(timeMap.get("love", 25), equalTo("low"));
        assertThat(timeMap.get("love", 5), equalTo(""));
    }

    @Test
    public void test3() {
        timeMap.set("a", "bar", 1);
        timeMap.set("x", "b", 3);
        assertThat(timeMap.get("b", 3), equalTo(""));

        timeMap.set("foo", "bar2", 4);
        assertThat(timeMap.get("foo", 4), equalTo("bar2"));
        assertThat(timeMap.get("foo", 5), equalTo("bar2"));
    }
}
