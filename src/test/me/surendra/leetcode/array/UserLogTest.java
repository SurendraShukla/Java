package me.surendra.leetcode.array;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertThat;

public class UserLogTest {

    @Test
    public void test1() {
        final String[][] logs = new String[][] {
            { "58523", "user_1", "resource_1" },
            { "62314", "user_2", "resource_2" },
            { "54001", "user_1", "resource_3" },
            { "200", "user_6", "resource_5" },
            { "215", "user_6", "resource_4" },
            { "54060", "user_2", "resource_3" },
            { "53760", "user_3", "resource_3" },
            { "58522", "user_22", "resource_1" },
            { "53651", "user_5", "resource_3" },
            { "2", "user_6", "resource_1" },
            { "100", "user_6", "resource_6" },
            { "400", "user_7", "resource_2" },
            { "100", "user_8", "resource_6" },
            {"54359", "user_1", "resource_3"},
        };

        final Map<String, List<Integer>> expected = new HashMap<>();
        expected.put("user_1", asList(54001, 58523));
        expected.put("user_2", asList(54060, 62314));
        expected.put("user_3", asList(53760, 53760));
        expected.put("user_5", asList(53651, 53651));
        expected.put("user_6", asList(2, 215));
        expected.put("user_7", asList(400, 400));
        expected.put("user_8", asList(100, 100));
        expected.put("user_22", asList(58522, 58522));

        final Map<String, List<Integer>> actual = UserLog.getEarliestAndLatestAccessForUser(logs);

        assertThat(actual, Matchers.equalTo(expected));
    }

    @Test
    public void test2() {
        final String[][] logs = new String[][] {
            {"300", "user_1", "resource_3"},
            {"599", "user_1", "resource_3"},
            {"900", "user_1", "resource_3"},
            {"1199", "user_1", "resource_3"},
            {"1200", "user_1", "resource_3"},
            {"1201", "user_1", "resource_3"},
            {"1202", "user_1", "resource_3"}
        };

        final Map<String, List<Integer>> expected = new HashMap<>();
        expected.put("user_1", asList(300, 1202));

        final Map<String, List<Integer>> actual = UserLog.getEarliestAndLatestAccessForUser(logs);

        assertThat(actual, Matchers.equalTo(expected));
    }

}
