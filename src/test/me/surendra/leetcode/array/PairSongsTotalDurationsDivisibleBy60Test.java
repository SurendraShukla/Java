package me.surendra.leetcode.array;

import org.junit.Test;

import static me.surendra.leetcode.array.PairSongsTotalDurationsDivisibleBy60.byBruteForce;
import static me.surendra.leetcode.array.PairSongsTotalDurationsDivisibleBy60.byUseAnArrayToStoreFrequencies;
import static me.surendra.leetcode.array.PairSongsTotalDurationsDivisibleBy60.byUsingHashMapToStoreSeenPair;
import static me.surendra.leetcode.array.PairSongsTotalDurationsDivisibleBy60.byUsingArrayToStoreSeenPair;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PairSongsTotalDurationsDivisibleBy60Test {

    @Test
    public void shouldGet3PairsFor5Input() {
        int[] time = {30, 20, 150, 100, 40};
        int pairsExpected = 3;

        assertThat(byBruteForce(time), equalTo(pairsExpected));
        assertThat(byUsingArrayToStoreSeenPair(time), equalTo(pairsExpected));
        assertThat(byUsingHashMapToStoreSeenPair(time), equalTo(pairsExpected));
        assertThat(byUseAnArrayToStoreFrequencies(time), equalTo(pairsExpected));
    }

    @Test
    public void shouldGet3PairsFor3Input() {
        int[] time = {60, 60, 60};
        int pairsExpected = 3;

        assertThat(byBruteForce(time), equalTo(pairsExpected));
        assertThat(byUsingArrayToStoreSeenPair(time), equalTo(pairsExpected));
        assertThat(byUsingHashMapToStoreSeenPair(time), equalTo(pairsExpected));
        assertThat(byUseAnArrayToStoreFrequencies(time), equalTo(pairsExpected));
    }

    @Test
    public void shouldGet6PairsFor4Input() {
        int[] time = {60, 60, 60, 60};
        int pairsExpected = 6;

        assertThat(byBruteForce(time), equalTo(pairsExpected));
        assertThat(byUsingArrayToStoreSeenPair(time), equalTo(pairsExpected));
        assertThat(byUsingHashMapToStoreSeenPair(time), equalTo(pairsExpected));
        assertThat(byUseAnArrayToStoreFrequencies(time), equalTo(pairsExpected));
    }

    @Test
    public void shouldGet1PairFor1Input() {
        int[] time = {60};
        int pairsExpected = 0;

        assertThat(byBruteForce(time), equalTo(pairsExpected));
        assertThat(byUsingArrayToStoreSeenPair(time), equalTo(pairsExpected));
        assertThat(byUsingHashMapToStoreSeenPair(time), equalTo(pairsExpected));
        assertThat(byUseAnArrayToStoreFrequencies(time), equalTo(pairsExpected));
    }

}
