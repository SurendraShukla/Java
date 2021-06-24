package me.surendra.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * Asked by Better.com
 * @see <a href="https://leetcode.com/discuss/interview-question/859968/bettercom-phone-karat-interview">Aggrate user log access time</a>
 */
public class UserLog {

    /*
    Input:  Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, the ID of the user making the access, and the resource ID.
                The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.
    Output: We would like to compute user sessions, specifically: write a function that takes the logs and returns a data structure that associates to each user their the aggregate earliest and latest access times.
     */
    public static Map<String, List<Integer>> getEarliestAndLatestAccessForUser(final String[][] logs) {

        final Map<String, TreeSet<Integer>> userAccessLogs = new HashMap<>();

        for(int i=0; i<logs.length; i++) {
            final String user = logs[i][1];
            final String accessTime = logs[i][0];
            userAccessLogs.putIfAbsent(user, new TreeSet<>());
            final TreeSet<Integer> accessTimeList =  userAccessLogs.get(user);
            accessTimeList.add(Integer.valueOf(accessTime));
            userAccessLogs.put(user, accessTimeList);
        }

        final Map<String, List<Integer>> returnHashMap = new HashMap<>();
        userAccessLogs.forEach((k, v) -> {
            returnHashMap.putIfAbsent(k, new ArrayList<>());
            final List<Integer> accessTimeList =  returnHashMap.get(k);
            accessTimeList.add(v.first());
            accessTimeList.add(v.last());
            returnHashMap.put(k, accessTimeList);
        });
        return returnHashMap;
    }

}
