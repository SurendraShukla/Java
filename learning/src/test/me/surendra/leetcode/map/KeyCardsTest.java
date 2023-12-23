package me.surendra.leetcode.map;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class KeyCardsTest {

    private List<String> callMethod(final String[] keyNames, final String[] keyTimes) {
        return new KeyCards().alertNames(keyNames, keyTimes);
    }

    @Test
    public void testToMakeSureAnHourIsProperlyConsidered() {
        final String[] keyNames = {"daniel","daniel","daniel","luis","luis","luis","luis"};
        final String[] keyTimes = {"10:00","10:40","11:00","09:00","11:00","13:00","15:00"};
        final List<String> expectedEmployeeNames = Arrays.asList("daniel");

        // execute
        assertThat(callMethod(keyNames, keyTimes), equalTo(expectedEmployeeNames));
    }

    @Test
    public void testToMakeSureSingleUsersHavingMoreThan3TimeAccessWithinAnHour
        () {
        final String[] keyNames = {"alice","alice","alice","bob","bob","bob","bob"};
        final String[] keyTimes = {"12:01","12:00","18:00","21:00","21:20","21:30","23:00"};
        final List<String> expectedEmployeeNames = Arrays.asList("bob");

        // execute
        assertThat(callMethod(keyNames, keyTimes), equalTo(expectedEmployeeNames));
    }

    @Test
    public void testToMakeSureConsiderationForNextDay() {
        final String[] keyNames = {"john","john","john"};
        final String[] keyTimes = {"23:58","23:59","00:01"};
        final List<String> expectedEmployeeNames = Arrays.asList();

        // execute
        assertThat(callMethod(keyNames, keyTimes), equalTo(expectedEmployeeNames));
    }

    @Test
    public void testToMakeSureMultipleUsersAreReturned() {
        final String[] keyNames = {"leslie","leslie","leslie","clare","clare","clare","clare"};
        final String[] keyTimes = {"13:00","13:20","14:00","18:00","18:51","19:30","19:49"};
        final List<String> expectedEmployeeNames = Arrays.asList("clare","leslie");

        // execute
        assertThat(callMethod(keyNames, keyTimes), equalTo(expectedEmployeeNames));
    }

    @Test
    public void testToMakeSureAccessTimeIsSorted() {
        final String[] keyNames = {"a","a","a","a","a","b","b","b","b","b","b"};
        final String[] keyTimes = {"04:48","23:53","06:36","07:45","12:16","00:52","10:59","17:16","00:36","01:26","22:42"};
        final List<String> expectedEmployeeNames = Arrays.asList("b");

        // execute
        assertThat(callMethod(keyNames, keyTimes), equalTo(expectedEmployeeNames));
    }

}
