package me.surendra.tdd;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

// https://www.codewars.com/kata/baseball
public class ScoreCardTest {

    @Test
    public void shouldReturnInitialScoreAtGameStart() {
        final ScoreCard scoreCard = new ScoreCard();
        String score = scoreCard.getScore();
        Assert.assertThat(score, Matchers.equalTo("Home: 0 Away: 0"));
    }

    @Test
    public void shouldReturnAwayScoreAs1AfterFirstHomeRun() {
        final ScoreCard scoreCard = new ScoreCard();
        scoreCard.addEntry("homerun");
        Assert.assertThat(scoreCard.getScore(), Matchers.equalTo("Home: 0 Away: 1"));
    }

    @Test
    public void shouldReturnScoreAs0AfterFirstSingle() {
        final ScoreCard scoreCard = new ScoreCard();
        scoreCard.addEntry("single");
        Assert.assertThat(scoreCard.getScore(), Matchers.equalTo("Home: 0 Away: 0"));
    }

    @Test
    public void shouldReturnScoreAs1AfterFourSingles() {
        final ScoreCard scoreCard = new ScoreCard();
        scoreCard.addEntry("single");
        scoreCard.addEntry("single");
        scoreCard.addEntry("single");
        scoreCard.addEntry("single");
        Assert.assertThat(scoreCard.getScore(), Matchers.equalTo("Home: 0 Away: 1"));
    }

    @Test
    public void shouldReturnScoreAs1After2Doubles() {
        final ScoreCard scoreCard = new ScoreCard();
        scoreCard.addEntry("double");
        scoreCard.addEntry("double");
        Assert.assertThat(scoreCard.getScore(), Matchers.equalTo("Home: 0 Away: 1"));
    }

    @Test
    public void shouldReturnScoreAs1After1SingleAnd1Triple() {
        final ScoreCard scoreCard = new ScoreCard();
        scoreCard.addEntry("single");
        scoreCard.addEntry("triple");
        Assert.assertThat(scoreCard.getScore(), Matchers.equalTo("Home: 0 Away: 1"));
    }

    @Test
    public void shouldReturnReturnScoreAs2AfterAllBets() {
        final ScoreCard scoreCard = new ScoreCard();
        scoreCard.addEntry("single");
        scoreCard.addEntry("double");
        scoreCard.addEntry("triple");
        scoreCard.addEntry("homerun");
        Assert.assertThat(scoreCard.getScore(), Matchers.equalTo("Home: 0 Away: 2"));
    }

    @Test
    public void shouldPlayHomeTeamAfter3Outs() {
        final ScoreCard scoreCard = new ScoreCard();
        scoreCard.addEntry("out");
        scoreCard.addEntry("out");
        scoreCard.addEntry("out");
        scoreCard.addEntry("homerun");
        Assert.assertThat(scoreCard.getScore(), Matchers.equalTo("Home: 1 Away: 0"));
    }

}
