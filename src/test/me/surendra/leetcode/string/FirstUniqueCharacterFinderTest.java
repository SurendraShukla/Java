package me.surendra.leetcode.string;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class FirstUniqueCharacterFinderTest {

    private int callMethod(final String leetcode) {
        return new FirstUniqueCharacterFinder().firstUniqChar(leetcode);
    }

    @Test
    public void test() {
        assertThat(callMethod("leetcode"), equalTo(0));
        assertThat(callMethod("loveleetcode"), equalTo(2));
        assertThat(callMethod("aabb"), equalTo(-1));
    }

}
