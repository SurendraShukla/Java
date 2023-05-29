package me.surendra.leetcode.graph.bfs;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class WordLadderIITest {

    private List<List<String>> callMethod(final String beginWord, final String endWord, final List<String> wordList) {
        final WordLadderII wordLadderII = new WordLadderII();
        return wordLadderII.findLadders(beginWord, endWord, wordList);
    }

    @Test
    public void directCyclicGraph() {
        final List<String> wordList = newArrayList("hot", "dot", "dog", "lot", "log", "cog");

        // execute
        final List<List<String>> actual = callMethod("hit", "cog", wordList);

        final List<List<String>> expected = newArrayList(
            newArrayList("hit", "hot", "dot", "dog", "cog"),
            newArrayList("hit", "hot", "lot", "log", "cog")
        );
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void graphWithoutDestination() {
        final List<String> wordList = newArrayList("hot", "dot", "dog", "lot", "log");

        // execute
        final List<List<String>> actual = callMethod("hit", "cog", wordList);

        final List<List<String>> expected = newArrayList();
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void directAcyclicGraph() {
        final List<String> wordList = newArrayList("hot", "dog", "dot");

        // execute
        final List<List<String>> actual = callMethod("hot", "dog", wordList);

        final List<List<String>> expected = Arrays.asList(
            newArrayList("hot", "dot", "dog")
        );
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void timeLimitExceeded() {
        final List<String> wordList = newArrayList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye");

        // execute
        final List<List<String>> actual = callMethod("qa", "sq", wordList);

        final List<List<String>> expected = Arrays.asList(
            newArrayList("hot", "dot", "dog")
        );
        assertThat(actual, equalTo(expected));
    }

}
