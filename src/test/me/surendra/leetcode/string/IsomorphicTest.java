package me.surendra.leetcode.string;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class IsomorphicTest {

    private boolean callMethod(final String str1, final String str2) {
        return new Isomorphic().isIsomorphic(str1, str2);
    }

    @Test
    public void test1() {
        assertThat(callMethod("egg", "add"), equalTo(true));
        assertThat(callMethod("foo", "bar"), equalTo(false));
        assertThat(callMethod("bar", "foo"), equalTo(false));
        assertThat(callMethod("paper", "title"), equalTo(true));
    }

}
