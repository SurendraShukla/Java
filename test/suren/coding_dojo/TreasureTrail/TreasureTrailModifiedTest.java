package suren.coding_dojo.TreasureTrail;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class TreasureTrailModifiedTest {
    @Test
    public void amountShouldBeZeroIfNoStoneCollected() {
        assertEquals(setOf(0), worthOfCollectedStones(0, 1, 2));
    }

    @Test
    public void possibleAmountsShouldBePriceOfStonesIfOnlyOneStoneCollected() {
        assertEquals(setOf(1, 2), worthOfCollectedStones(1, 1, 2));
    }

    @Test
    public void possibleAmountsIfTwoStoneCollected() {
        assertEquals(setOf(2, 3, 4), worthOfCollectedStones(2, 1, 2));
    }

    private static Set<Integer> setOf(Integer... arr) {
        return new TreeSet<>(Arrays.asList(arr));
    }

    private Set<Integer> worthOfCollectedStones(int totalStones, int priceOfBlack, int priceOfWhite) {
        //return 0;
        // return (totalStones == 0) ? setOf(0) : setOf(priceOfBlack, priceOfWhite);
        ArrayList<Integer> combinations = new ArrayList<>();
        for (int i = 0; i <= totalStones; i++) {
            combinations.add(i * priceOfBlack + (totalStones - i) * priceOfWhite);
        }
        return new TreeSet<>(combinations);
    }
}
