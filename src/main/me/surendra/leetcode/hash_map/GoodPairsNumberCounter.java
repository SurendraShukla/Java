package me.surendra.leetcode.hash_map;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;


/**
 * @see <a href="https://leetcode.com/problems/number-of-good-pairs/">Number of Good Pairs</a>
 */
public class GoodPairsNumberCounter {

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public int numIdenticalPairs(int[] nums) {
        final Map<Integer, Integer> numberAndPairCountMap = new HashMap<>();
        for (final int num : nums) {
            if(numberAndPairCountMap.containsKey(num)) {
                numberAndPairCountMap.put(num, numberAndPairCountMap.get(num)+1);
            }else{
                numberAndPairCountMap.put(num, 1);
            }
        }

        int numberOfGoodPairs = 0;
        for (final Integer appearance : numberAndPairCountMap.values()) {
            if(appearance > 1) {
                numberOfGoodPairs += ((appearance * appearance) - appearance) / 2;
            }
        }
        return numberOfGoodPairs;
    }


    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public int numIdenticalPairsUsingPair(int[] nums) {
        final Map<Integer, Pair<Integer, Integer>> numberAndPairCountMap = new HashMap<>();
        for (final int num : nums) {
            if(numberAndPairCountMap.containsKey(num)) {
                final Pair<Integer, Integer> appearedAndTotal = numberAndPairCountMap.get(num);
                final Integer appeared = appearedAndTotal.getKey();
                int tmpTotal = appeared + appearedAndTotal.getValue();
                numberAndPairCountMap.put(num, new Pair<>(appeared+1, tmpTotal));
            }else{
                numberAndPairCountMap.put(num, new Pair<>(1, 0));
            }
        }

        int numberOfGoodPairs = 0;
        for (final Pair<Integer, Integer> pair : numberAndPairCountMap.values()) {
            numberOfGoodPairs+=pair.getValue();
        }
        return numberOfGoodPairs;
    }

}
