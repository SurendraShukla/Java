package me.surendra.leetcode.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class LongestSubstringTest {

    @Test
    public void test() {
        final List<String> stringList = LongestSubstring.getStringPermutation("a");
        final ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        assertThat(stringList, equalTo(arrayList));
    }

}
