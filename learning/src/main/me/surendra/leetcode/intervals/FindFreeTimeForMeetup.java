package me.surendra.leetcode.intervals;

import java.util.ArrayList;
import java.util.List;


/**
 * @see <a href="https://stackoverflow.com/a/63748835"></a>
 */
public class FindFreeTimeForMeetup {

    /*
        Time complexity : O(n)
        Space complexity: O(1)
        https://stackoverflow.com/a/23588814
     */
    public List<Integer[]> findFreeTimes(List<List<Integer[]>> intervals) {
        final int[] hours = new int[24];
        intervals.forEach(interval -> {
            interval.forEach(intArr -> {
                for (int i=intArr[0]; i<=intArr[1]; i++) {
                    hours[i] = 1;
                }
            });
        });

        int intervalStart = hours[0];
        final List<Integer[]> returnList = new ArrayList<>();
        int length = hours.length;
        for (int i = 1; i < length; i++) {
            if (hours[i-1] == hours[i]) {
                continue;
            }
            if (hours[i] == 1) {
                returnList.add(new Integer[]{intervalStart, i});
            }else{
                intervalStart = i;
            }
        }
        if ( (hours[length -1] == 0) && (intervalStart < length) ) {
            returnList.add(new Integer[]{intervalStart, length-1});
        }
        return returnList;
    }

}
