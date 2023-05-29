package com.surendra.hazelcast.jet;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class WordCounterTest {

    @Test
    public void whenGivenSentencesAndWordThenReturnCountOfWord() {
        final List<String> sentences = new ArrayList<>();
        sentences.add("The first second was alright, but the second second was tough.");
        final WordCounter wordCounter = new WordCounter();
        final long countSecond = wordCounter.countWord(sentences, "second");
        assertEquals(3, countSecond);
    }
}
