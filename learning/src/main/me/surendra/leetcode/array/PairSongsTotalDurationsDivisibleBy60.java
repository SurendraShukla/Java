package me.surendra.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class PairSongsTotalDurationsDivisibleBy60 {

    /*
        Time complexity: O(n^2)
        Space complexity: O(1)
   */
    public static int byBruteForce(int[] time) {
        int pairs = 0;
        for(int i=0; i<time.length-1; i++) {
            for(int j=i+1; j<time.length; j++) {
                if ((time[i] + time[j]) %60 == 0) {
                    pairs++;
                }
            }
        }
        return pairs;
    }

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public static int byUsingHashMapToStoreSeenPair(int[] time) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < time.length; i++) {
            int key = time[i] % 60;
            int pairedKey = key == 0 ? key : 60 - key;

            count += map.getOrDefault(pairedKey, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return count;
    }

    /*
        Time complexity: O(n)
        Space complexity: O(1)
     */
    public static int byUsingArrayToStoreSeenPair(int[] time) {
        int[] map = new int[60];
        int total = 0;
        for (int n: time) {
            int remain = n % 60;
            if (remain == 0) {
                total += map[0];
                map[0]++;
            } else {
                total += map[60-remain];
                map[remain]++;
            }
        }
        return total;
    }


    /*
        Time complexity: O(n)
        Space complexity: O(1)
       */
    public static int byUseAnArrayToStoreFrequencies(int[] time) {
        int remainders[] = new int[60];
        int count = 0;
        for (int t: time) {
            if (t % 60 == 0) { // check if a%60==0 && b%60==0
                count+= remainders[0];
            } else { // check if a%60+b%60==60
                count+= remainders[60 - t % 60];
            }
            remainders[t % 60]++; // remember to update the remainders
        }
        return count;
    }

}
