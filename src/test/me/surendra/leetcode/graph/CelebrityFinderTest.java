package me.surendra.leetcode.graph;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class CelebrityFinderTest {

    private int getCelebrity(final int[][] relations) {
        return new CelebrityFinder(relations).findCelebrity(relations.length);
//        return new CelebrityFinder(relations).findCelebrityWithBothCount_OtherAndHeKnows(relations.length);
//        return new CelebrityFinder(relations).findCelebrityByConsideringFirstCelebrityAndThenFinding(relations.length);
    }

    @Test
    public void celebrityInGroup() {
        final int[][] relations = {{1,1,0},{0,1,0},{1,1,1}};

        assertThat(getCelebrity(relations), equalTo(1));
    }

    @Test
    public void celebrityIn2() {
        final int[][] relations = {{1,0},{1,1}};

        assertThat(getCelebrity(relations), equalTo(0));
    }

    @Test
    public void noCelebrityIfOneKnowsOtherOneOnly() {
        final int[][] relations = {{1,0,1},{1,1,0},{0,1,1}};

        assertThat(getCelebrity(relations), equalTo(-1));
    }

    @Test
    public void noCelebrityIfNobodyKnowsAnybody() {
        final int[][] relations = {{1,0},{0,1}};

        assertThat(getCelebrity(relations), equalTo(-1));
    }

    @Test
    public void noCelebrityIfEverybodyKnowsEverybody() {
        final int[][] relations = {{1,1},{1,1}};

        assertThat(getCelebrity(relations), equalTo(-1));
    }

    @Test
    public void noCelebrityIfEverybodyKnowsHimButHeAlsoKnowsSomeone() {
        final int[][] relations = {{1,1,0},{0,1,1},{0,1,1}};

        assertThat(getCelebrity(relations), equalTo(-1));
    }

    @Test
    public void noCelebrityIfOneDoesNotKnowTheCelebrity() {
        final int[][] relations = {{1,1,1},{1,1,0},{0,0,1}};

        assertThat(getCelebrity(relations), equalTo(-1));
    }

}
