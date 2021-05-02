package me.surendra.leetcode.string;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class SearchAndReplaceTest {

    @Test
    public void test() {
        final String s = "aba aaba babba ab aabb bba";
        final String key = "ab";
        final String val = "cba";

        final String expected = "cbaa acbaa bcbaba cba acbab bba";
        final String result = new SearchAndReplace().searchAndReplace(s, key, val);
        Assert.assertThat(result, Matchers.equalTo(expected));
    }

}
