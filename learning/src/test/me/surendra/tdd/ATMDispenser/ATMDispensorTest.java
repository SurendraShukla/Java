package me.surendra.tdd.ATMDispenser;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by deyv on 24/03/16.
 */
public class ATMDispensorTest {

    private final ATMDispensor d = ATMDispensor.create();

    @Test
    public void shouldCreateATMDispensorToDispenseMoney() {
        Assert.assertNotNull(d);
    }

    @Test
    public void shouldDispenseSingleNoteForAllValidDenominations() {
        Assert.assertArrayEquals(new Integer[]{10}, d.dispense(10));
        Assert.assertArrayEquals(new Integer[]{20}, d.dispense(20));
        Assert.assertArrayEquals(new Integer[]{100}, d.dispense(100));
    }

    @Test
    public void shouldDispenseTwoNotesOfSameDenomiationForHigherAmount() {
        Assert.assertArrayEquals(new Integer[]{20, 20}, d.dispense(40));
        Assert.assertArrayEquals(new Integer[]{100, 100}, d.dispense(200));
    }


    @Test
    public void shouldDispenseHigherDenominationFirstInCaseOfCombinations() {
        Assert.assertArrayEquals(new Integer[]{20, 10}, d.dispense(30));
        Assert.assertArrayEquals(new Integer[]{20, 20, 10}, d.dispense(50));
        Assert.assertArrayEquals(new Integer[]{100, 100, 20, 10}, d.dispense(230));
        Assert.assertArrayEquals(new Integer[]{500, 20, 10}, d.dispense(530));
    }

    @Test
    public void shouldFailTransactionWhenAmountCannotBeDispensedWith() {
        validateFailureForIndispensableAmount(5);
        validateFailureForIndispensableAmount(15);
    }

    private void validateFailureForIndispensableAmount(final int amount) {
        try {
            d.dispense(amount);
            Assert.fail("Should have failed for amount not dispensable for given denominations.");
        } catch (IllegalArgumentException exp) {

        }
    }

}
