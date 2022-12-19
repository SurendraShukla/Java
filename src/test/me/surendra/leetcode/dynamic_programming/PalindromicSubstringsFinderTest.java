package me.surendra.leetcode.dynamic_programming;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PalindromicSubstringsFinderTest {

    private int callMethod(final String abc) {
        return new PalindromicSubstringsFinder().countSubstrings(abc);
    }

    @Test
    public void test1() {
        assertThat(callMethod("abc"), equalTo(3));
        assertThat(callMethod("aaa"), equalTo(6));
        assertThat(callMethod("aaaaa"), equalTo(15));
        assertThat(callMethod("bbccaacacdbdbcbcbbbcbadcbdddbabaddbcadb"), equalTo(64));
    }

}
