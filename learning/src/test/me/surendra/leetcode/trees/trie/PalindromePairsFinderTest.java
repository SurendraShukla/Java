package me.surendra.leetcode.trees.trie;


import org.junit.Test;

import java.math.BigInteger;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class PalindromePairsFinderTest {

    private List<List<Integer>> callMethod(final String[] words) {
        return new PalindromePairsFinder().palindromePairs(words);
    }

    @Test
    public void name() {
        BigInteger yourNumber = new BigInteger("101000101110...1010", 2);
        yourNumber.mod(BigInteger.valueOf(1000000007)).intValue();
        System.out.println(Integer.toBinaryString(1));

        String[] split = "2.txt(txt)".split(".txt");
        System.out.println(split);

        final String[] words = {"abcd", "dcba", "lls", "s", "sssll"};

        final List<List<Integer>> actual = callMethod(words);

        final List<List<Integer>> expected = newArrayList(
            newArrayList(0, 1),
            newArrayList(1, 0),
            newArrayList(3, 2),
            newArrayList(2, 4)
        );
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test2() {
        final String[] words = {"bat", "tab", "cat"};

        final List<List<Integer>> actual = callMethod(words);

        final List<List<Integer>> expected = newArrayList(
            newArrayList(0, 1),
            newArrayList(1, 0)
        );
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test3() {
        final String[] words = {"a", ""};

        final List<List<Integer>> actual = callMethod(words);

        final List<List<Integer>> expected = newArrayList(
            newArrayList(0, 1),
            newArrayList(1, 0)
        );
        assertThat(actual, equalTo(expected));
    }

}
