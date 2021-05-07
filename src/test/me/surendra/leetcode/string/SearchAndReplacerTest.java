package me.surendra.leetcode.string;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class SearchAndReplacerTest {

    SearchAndReplacer searchAndReplacer;

    @Before
    public void setUp() {
        searchAndReplacer = new SearchAndReplacer();
    }

    @Test
    public void test1() {
        final String expected = "cbaa acbaa bcbaba cba acbab bba";
        final String mainStr = "aba aaba babba ab aabb bba";

        final String result = searchAndReplacer.searchAndReplace(mainStr, "ab", "cba");

        assertThat(result, equalTo(expected));
    }

    @Test
    public void test2() {
        final String mainStr = "this is a test test";
        final String expected = "this is a wow wow";

        final String result = searchAndReplacer.searchAndReplace(mainStr, "test", "wow");

        assertThat(result, equalTo(expected));
    }

    @Test
    public void test3() {
        final String mainStr = "rtest is a test test";
        final String expected = "rwow is a wow wow";

        final String result = searchAndReplacer.searchAndReplace(mainStr, "test", "wow");

        assertThat(result, equalTo(expected));
    }

    @Test
    public void test4() {
        final String mainStr = "rt";
        final String expected = "rt";

        final String result = searchAndReplacer.searchAndReplace(mainStr, "test", "wow");

        assertThat(result, equalTo(expected));
    }

    @Test
    public void test5() {
        final String mainStr = "aaaaaaaaaa";
        final String expected = "bbbbbbbbbbbbbbbbbbbb";

        final String result = searchAndReplacer.searchAndReplace(mainStr, "a", "bb");

        assertThat(result, equalTo(expected));
    }

}
