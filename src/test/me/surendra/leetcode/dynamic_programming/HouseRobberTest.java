package me.surendra.leetcode.dynamic_programming;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class HouseRobberTest {

    private int callMethod(final int[] houseHoldingMoney) {
//        return new HouseRobber().robUsingRecursionWithMemoization(houseHoldingMoney);

//        return new HouseRobber().robUsingDpBottomUpApproachWithTable(houseHoldingMoney);
        return new HouseRobber().robUsingDpBottomUpApproachWithVariables(houseHoldingMoney);

//        return new HouseRobber().robUsingDpTopDownApproachWithVariables(houseHoldingMoney);
//        return new HouseRobber().robUsingDpTopDownApproachWithTable(houseHoldingMoney);
    }

    @Test
    public void moneyRobbedWorthOf1() {
        int[] houseHoldingMoney = {1};

        assertThat(callMethod(houseHoldingMoney), equalTo(1));
    }

    @Test
    public void moneyRobbedWorthOf2() {
        int[] houseHoldingMoney = {1, 2};

        assertThat(callMethod(houseHoldingMoney), equalTo(2));
    }

    @Test
    public void moneyRobbedWorthOf4FromOddHouses() {
        int[] houseHoldingMoney = {1, 2, 3};

        assertThat(callMethod(houseHoldingMoney), equalTo(4));
    }

    @Test
    public void moneyRobbedWorthOf4FromEvenHouses() {
        int[] houseHoldingMoney = {1, 2, 3, 1};

        assertThat(callMethod(houseHoldingMoney), equalTo(4));
    }

    @Test
    public void moneyRobbedWorthOf12() {
        int[] houseHoldingMoney = {2, 7, 9, 3, 1};

        assertThat(callMethod(houseHoldingMoney), equalTo(12));
    }

    @Test
    public void moneyRobbedWorthAtNextToNextHouse() {
        int[] houseHoldingMoney = {2, 1, 1, 2};

        assertThat(callMethod(houseHoldingMoney), equalTo(4));
    }

    @Test
    public void moneyRobbedWorthAtNextToNextCopuleOfHouses() {
        int[] houseHoldingMoney = {6,3,10,8,2,10,3,5,10,5,3};

        assertThat(callMethod(houseHoldingMoney), equalTo(39));
    }

}
