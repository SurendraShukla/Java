package me.surendra.leetcode.array;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class DuplicateFinderTest {

    final DuplicateFinder duplicateFinder = new DuplicateFinder();

    @Test
    public void testFindDuplicateBySeenAlgorithmUsingSameArray() {
        assertThat(duplicateFinder.findDuplicateBySeenAlgorithmUsingSameArray(new int[]{1, 3, 4, 2, 2}), equalTo(2));
        assertThat(duplicateFinder.findDuplicateBySeenAlgorithmUsingSameArray(new int[]{3, 1, 3, 4, 2}), equalTo(3));
        assertThat(duplicateFinder.findDuplicateBySeenAlgorithmUsingSameArray(new int[]{1, 1}), equalTo(1));
        assertThat(duplicateFinder.findDuplicateBySeenAlgorithmUsingSameArray(new int[]{1, 1, 2}), equalTo(1));
        assertThat(duplicateFinder.findDuplicateBySeenAlgorithmUsingSameArray(new int[]{2, 2, 2, 2, 2}), equalTo(2));
    }

    @Test
    public void testFindDuplicateBySeenAlgorithmUsingSet() {
        assertThat(duplicateFinder.findDuplicateBySeenAlgorithmUsingSet(new int[]{1, 3, 4, 2, 2}), equalTo(2));
        assertThat(duplicateFinder.findDuplicateBySeenAlgorithmUsingSet(new int[]{3, 1, 3, 4, 2}), equalTo(3));
        assertThat(duplicateFinder.findDuplicateBySeenAlgorithmUsingSet(new int[]{1, 1}), equalTo(1));
        assertThat(duplicateFinder.findDuplicateBySeenAlgorithmUsingSet(new int[]{1, 1, 2}), equalTo(1));
        assertThat(duplicateFinder.findDuplicateBySeenAlgorithmUsingSet(new int[]{2, 2, 2, 2, 2}), equalTo(2));
    }

    @Test
    public void testFindDuplicateUsingSorting() {
        assertThat(duplicateFinder.findDuplicateUsingSorting(new int[]{1, 3, 4, 2, 2}), equalTo(2));
        assertThat(duplicateFinder.findDuplicateUsingSorting(new int[]{3, 1, 3, 4, 2}), equalTo(3));
        assertThat(duplicateFinder.findDuplicateUsingSorting(new int[]{1, 1}), equalTo(1));
        assertThat(duplicateFinder.findDuplicateUsingSorting(new int[]{1, 1, 2}), equalTo(1));
        assertThat(duplicateFinder.findDuplicateUsingSorting(new int[]{2, 2, 2, 2, 2}), equalTo(2));
    }

    @Test
    public void testFindDuplicateByFloydsCycleDetection() {
        assertThat(duplicateFinder.findDuplicateByFloydsAlog_TortoiseAndHare(new int[]{1, 3, 4, 2, 2}), equalTo(2));
        assertThat(duplicateFinder.findDuplicateByFloydsAlog_TortoiseAndHare(new int[]{3, 1, 3, 4, 2}), equalTo(3));
        assertThat(duplicateFinder.findDuplicateByFloydsAlog_TortoiseAndHare(new int[]{1, 1}), equalTo(1));
        assertThat(duplicateFinder.findDuplicateByFloydsAlog_TortoiseAndHare(new int[]{1, 1, 2}), equalTo(1));
        assertThat(duplicateFinder.findDuplicateByFloydsAlog_TortoiseAndHare(new int[]{2, 2, 2, 2, 2}), equalTo(2));
    }
}
