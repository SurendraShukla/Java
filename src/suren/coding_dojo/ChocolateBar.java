package suren.coding_dojo;

public class ChocolateBar {
    public int makeChocolate(int small, int big, int goal) {

        int requiredSmallBar = goal - Math.min(goal / 5, big) * 5;
        return  small - requiredSmallBar < 0 ? -1 : requiredSmallBar;
    }
}
