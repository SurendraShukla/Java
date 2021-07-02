package me.surendra.leetcode.hash_map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/">Alert Using Same Key-Card Three or More Times in a One Hour Period</a>
 */
public class KeyCards {

    /*
        Time Complexity - O(n * n log n)
        Space Complexity - O(n)
     */
    public List<String> alertNames(final String[] keyName, final String[] keyTime) {
        final Map<String, List<Integer>> employeeWithAccessTimes = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) { // O(n) - linear
            final String employeeName = keyName[i];
            final List<Integer> accessTime;
            if (employeeWithAccessTimes.containsKey(employeeName)) {
                accessTime = employeeWithAccessTimes.get(employeeName);
            }else{
                accessTime = new ArrayList<>();
            }
            populateAccessTime(keyTime[i], accessTime);
            employeeWithAccessTimes.put(employeeName, accessTime);
        }

        final ArrayList<String> employeeNames = new ArrayList<>();
        for (final Map.Entry<String, List<Integer>> employeeAccessTimes : employeeWithAccessTimes.entrySet()) {  // O(n) - linear
            if(isCardAccessedMoreThan2TimesInAnHour(employeeAccessTimes)) { // O(n log n)
                employeeNames.add(employeeAccessTimes.getKey());
            }
        }

        Collections.sort(employeeNames);
        return employeeNames;
    }

    private boolean isCardAccessedMoreThan2TimesInAnHour(final Map.Entry<String, List<Integer>> employeeAccessTimes) {
        final List<Integer> employeeAccessTimeWithCount = employeeAccessTimes.getValue();
        if (employeeAccessTimeWithCount.size() < 3) { // O(1) Linear
            return false;
        }
        Collections.sort(employeeAccessTimeWithCount); // O(n log n)
        for (int i = 2; i < employeeAccessTimeWithCount.size(); i++) { // O(n)
            final Integer accessedFirstInterval = employeeAccessTimeWithCount.get(i - 2);
            final Integer accessedThirdInterval = employeeAccessTimeWithCount.get(i);
            int timeDifference = accessedThirdInterval - accessedFirstInterval;
            if ((timeDifference >= 0) && (timeDifference <= 60)) {
                return true;
            }
        }
        return false;
    }

    private void populateAccessTime(final String s, final List<Integer> accessTimes) {
        final String[] accessHourAndMinute = s.split(":");
        final Integer accessHour  = Integer.valueOf(accessHourAndMinute[0]);
        final Integer accessMinute= Integer.valueOf(accessHourAndMinute[1]);
        final Integer time = (accessHour * 60) + accessMinute;
        accessTimes.add(time);
    }

}
