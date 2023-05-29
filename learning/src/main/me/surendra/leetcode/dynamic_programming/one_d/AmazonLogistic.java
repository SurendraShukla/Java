package me.surendra.leetcode.dynamic_programming.one_d;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/discuss/interview-question/1365052/Amazon-OA">Choose Fleets</a>
 */
public class AmazonLogistic {

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public static List<Integer> chooseFleets(final List<Integer> wheels) {
        final List<Integer> waysList = new ArrayList<>();
        for (int i = 0; i < wheels.size(); i++) {
            final Integer totalWheels = wheels.get(i);
            int way;
            if (totalWheels % 2 != 0) {
                way = 0;
            } else {
                way = (wheels.get(i) / 4) + 1;
            }
            waysList.add(i, way);
        }
        return waysList;
    }
}
