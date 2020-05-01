package me.surendra.tdd;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class DuelingDice {

    @Test
    public void shouldBeAbleToAddEntryAndGetScore() {
        final ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.addEntry(1);
        assertThat("Player_1:0 Player_2:0", equalTo(scoreBoard.getScore()));
    }

    @Test
    public void shouldReturnPlayer1ScoreTo1ForEntry1() {
        final ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.addEntry(5);
        assertThat("Player_1:1 Player_2:0", equalTo(scoreBoard.getScore()));
    }

    @Test
    public void shouldReturnPlayer1ScoreTo2ForEntry2And4() {
        final ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.addEntry(2);
        scoreBoard.addEntry(4);
        assertThat("Player_1:1 Player_2:0", equalTo(scoreBoard.getScore()));
    }

    @Test
    public void shouldReturnPlayer1ScoreTo2ForEntry1And5() {
        final ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.addEntry(1);
        scoreBoard.addEntry(5);
        assertThat("Player_1:2 Player_2:0", equalTo(scoreBoard.getScore()));
    }

    @Test
    public void shouldReturnPlayer1ScoreTo3ForEntry1And5() {
        final ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.addEntry(1);
        scoreBoard.addEntry(1);
        scoreBoard.addEntry(5);
        assertThat("Player_1:3 Player_2:0", equalTo(scoreBoard.getScore()));
    }

}


class ScoreBoard {
    final List<Integer> entries = Lists.newArrayList();
    int score = 0;
    public void addEntry(final int entry) {
        entries.add(entry);
    }

    public String getScore() {
        int total = 0;
        for(Integer entry: entries) {
            if (entry == 5) {
                score++;
            }
            total+= entry;
        }
        if (total > 5) {
            score++;
        }
        return "Player_1:"+score+" Player_2:0";
    }
}
