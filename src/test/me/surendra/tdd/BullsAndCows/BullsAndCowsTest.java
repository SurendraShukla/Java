package me.surendra.tdd.BullsAndCows;

import org.junit.Assert;
import org.junit.Test;

public class BullsAndCowsTest {

    @Test
    public void shouldHaveGetHintMethod(){
        BullsAndCows bullsAndCows = new BullsAndCows();
        String hint = bullsAndCows.getHint("8129","7839");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldAcceptOnly4DigitNumbers(){
        BullsAndCows bullsAndCows = new BullsAndCows();
        bullsAndCows.getHint("3333","454343");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptNumbersWithDuplicateDigits(){
        BullsAndCows bullsAndCows =  new BullsAndCows();
        bullsAndCows.getHint("8888","9999");
    }

    @Test
    public void shouldReturnCowForMatchingDigit(){
        BullsAndCows bullsAndCows = new BullsAndCows();
        Assert.assertEquals("0B1C" , bullsAndCows.getHint("1234","7891"));
        Assert.assertEquals("0B3C" , bullsAndCows.getHint("1234","4821"));
        Assert.assertEquals("0B0C" , bullsAndCows.getHint("1234","5678"));
    }

    @Test
    public void shouldReturnBullsForMatchingDigitsInplace(){
        BullsAndCows bullsAndCows = new BullsAndCows();
        Assert.assertEquals("1B0C" , bullsAndCows.getHint("1234","1890"));
        Assert.assertEquals("2B0C" , bullsAndCows.getHint("4569","4789"));
        Assert.assertEquals("4B0C" , bullsAndCows.getHint("4569","4569"));
    }

    @Test
    public void shouldReturnBullsCowsForInput(){
        BullsAndCows bullsAndCows = new BullsAndCows();
        Assert.assertEquals("1B1C" , bullsAndCows.getHint("1234","1840"));
        Assert.assertEquals("2B2C" , bullsAndCows.getHint("4569","4659"));
    }
}
