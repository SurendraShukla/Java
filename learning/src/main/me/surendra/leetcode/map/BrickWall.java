package me.surendra.leetcode.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @see <a href="https://leetcode.com/problems/brick-wall/">Brick Wall</a>
 */
public class BrickWall {

    /*
        Time complexity : O(n) n is the total number of bricks in a wall
        Space complexity: O(n) m refers to the width of the wall
     */
    public int leastBricks(List<List<Integer>> wall) {
        final Map<Integer, Integer> brickWidthItsCountMap = new HashMap<>();

        int wallLength = 0;
        for (final List<Integer> integers : wall) {
            int brickWidth = 0;
            for (int i = 0; i < integers.size()-1; i++) {
                brickWidth+=integers.get(i);
                if (brickWidthItsCountMap.containsKey(brickWidth)){
                    brickWidthItsCountMap.put(brickWidth, brickWidthItsCountMap.get(brickWidth)+1);
                }else{
                    brickWidthItsCountMap.put(brickWidth, 1);
                }
            }
            wallLength++;
        }

        int maxBrickLength = 0;
        for (final Integer brickLength : brickWidthItsCountMap.values()) {
            maxBrickLength = Math.max(maxBrickLength, brickLength);
        }

        return wallLength-maxBrickLength;
    }

}
