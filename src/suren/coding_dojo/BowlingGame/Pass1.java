package suren.coding_dojo.BowlingGame;

public class Pass1 {
    private int score = 0;

    public void roll(int pins) {
        score += pins;
    }

    public int score() {
        return score;
    }
}