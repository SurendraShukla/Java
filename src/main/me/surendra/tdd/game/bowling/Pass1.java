package me.surendra.tdd.game.bowling;

public class Pass1 {
    private int score = 0;

    public void roll(int pins) {
        score += pins;
    }

    public int score() {
        return score;
    }
}
