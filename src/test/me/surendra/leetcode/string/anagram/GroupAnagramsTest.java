package me.surendra.leetcode.string.anagram;

import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Arrays.asList;
import static me.surendra.TestUtil.assertTrue;


public class GroupAnagramsTest {

    private final GroupAnagrams groupAnagrams = new GroupAnagrams();

    private List<List<String>> callMethod(final String[] strings) {
//        return groupAnagrams.groupAnagramsCategorizeBySortedString(strings);
        return groupAnagrams.groupAnagramsCategorizeByCount(strings);
    }

    @Test
    public void test1() {
        final String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};

        final List<List<String>> actual = callMethod(strings);

        final List<List<String>> expected = newArrayList(
            newArrayList("bat"),
            newArrayList("nat", "tan"),
            newArrayList("ate", "eat", "tea")
        );
        assertTrue(actual, expected);
    }


    @Test
    public void test2() {
        final String[] strings = {""};

        final List<List<String>> actual = callMethod(strings);

        final List<List<String>> expected = asList(
            asList("")
        );
        assertTrue(actual, expected);
    }

    @Test
    public void test3() {
        final String[] strings = {"a"};

        final List<List<String>> actual = callMethod(strings);

        final List<List<String>> expected = asList(
            asList("a")
        );
        assertTrue(actual, expected);
    }

}
