package me.surendra.leetcode.dynamic_programming;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class HouseRobberTest {

    private final HouseRobber houseRobber = new HouseRobber();

    private int callMethod(final int[] houseHoldingMoney) {
        return houseRobber.robUsingRecursionWithMemoization(houseHoldingMoney);

//        return houseRobber.robFromLastHouseUsingBottomUpApproachWithVariable(houseHoldingMoney);
//        return houseRobber.robFromFirstHouseUsingBottomUpApproachWithVariable(houseHoldingMoney);

//        return houseRobber.robFromFirstHouseUsingBottomUpApproachWithTable(houseHoldingMoney);
//        return houseRobber.robFromLastHouseUsingBottomUpApproachWithTable(houseHoldingMoney);
    }

    @Test
    public void moneyRobbedWorthOf1() {
        assertThat(callMethod(new int[]{1}), equalTo(1));
    }

    @Test
    public void moneyRobbedWorthOf2() {
        assertThat(callMethod(new int[]{1, 2}), equalTo(2));
    }

    @Test
    public void moneyRobbedWorthOf4FromOddHouses() {
        assertThat(callMethod(new int[]{1, 2, 3}), equalTo(4));
    }

    @Test
    public void moneyRobbedWorthOf4FromEvenHouses() {
        assertThat(callMethod(new int[]{1, 2, 3, 1}), equalTo(4));
    }

    @Test
    public void moneyRobbedWorthOf12() {
        assertThat(callMethod(new int[]{2, 7, 9, 3, 1}), equalTo(12));
    }

    @Test
    public void moneyRobbedWorthAtNextToNextHouse() {
        assertThat(callMethod(new int[]{2, 1, 1, 2}), equalTo(4));
    }

    @Test
    public void moneyRobbedWorthAtNextToNextCoupleOfHouses() {
        assertThat(callMethod(new int[]{6, 3, 10, 8, 2, 10, 3, 5, 10, 5, 3}), equalTo(39));
    }

}
