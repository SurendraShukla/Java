package me.surendra.tdd.TreasureTrail;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class TreasureTrailTest {

    @Test
    public void singleStoneShouldHaveZeroAsFinalNumber() {
        TreasureTrail tt = new TreasureTrail(1, 2);
        assertEquals(setOf(0), tt.getPossibleFinalStones(1));
    }

    @Test
    public void shouldLeadTo2CombinationIfTotalStonesAre2() {
        TreasureTrail tt = new TreasureTrail(1, 2);
        assertEquals(setOf(1, 2), tt.getPossibleFinalStones(2));
    }

    @Test
    public void shouldLeadTo3CombinationIfTotalStonesAre3() {
        TreasureTrail tt = new TreasureTrail(1, 2);
        assertEquals(setOf(2, 3, 4), tt.getPossibleFinalStones(3));
    }

    @Test
    public void numberOnNextStoneShouldGive2Combination() {
        TreasureTrail tt = new TreasureTrail(1, 2);
        assertEquals(setOf(1, 2), tt.nextStone(0));
    }

    @Test
    public void numberOnNextStoneShouldGive2CombinationByAddingTheDiffs() {
        TreasureTrail tt = new TreasureTrail(1, 2);
        assertEquals(setOf(2, 3), tt.nextStone(1));
    }

    private static Set<Integer> setOf(Integer... arr) {
        return new HashSet<>(Arrays.asList(arr));
    }

}
