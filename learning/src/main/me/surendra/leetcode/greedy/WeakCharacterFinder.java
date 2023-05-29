package me.surendra.leetcode.greedy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * @see <a href="https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/">The Number of Weak Characters in the Game</a>
 */
public class WeakCharacterFinder {
    final TreeMap<Integer, List<Integer>> characterGroup = new TreeMap<>();
    NavigableMap<Integer, List<Integer>> nMap;

    public int numberOfWeakCharacters(final int[][] properties) {
        for (int[] character: properties) {
            final List<Integer> characterDefense = characterGroup.getOrDefault(character[0], new ArrayList<>());
            characterDefense.add(character[1]);
            characterGroup.put(character[0], characterDefense);
        }

        for (Map.Entry<Integer, List<Integer>> characterAttributes: characterGroup.entrySet()) {
            Collections.sort(characterAttributes.getValue());
        }

        nMap = characterGroup.descendingMap();

        int weakCharacters = 0;
        for (Map.Entry<Integer, List<Integer>> characterAttributes: characterGroup.entrySet()) {
            final Integer characterAttack = characterAttributes.getKey();
            for (final Integer characterDefense : characterAttributes.getValue()) {
                if (weakCharacters(characterAttack, characterDefense)) {
                    weakCharacters++;
                }
            }
        }
        return weakCharacters;
    }

    private boolean weakCharacters(final Integer characterAttack, final Integer characterDefense) {
        for (NavigableMap.Entry<Integer, List<Integer>> characterAttributes: nMap.entrySet()) {
            final Integer currentCharacterAttack = characterAttributes.getKey();
            if (currentCharacterAttack < characterAttack) {
                continue;
            }

            final List<Integer> characterGroupDefense = characterAttributes.getValue();
            final Integer currentCharacterDefense = characterGroupDefense.get(characterGroupDefense.size() - 1);
            if (currentCharacterAttack > characterAttack &&
                currentCharacterDefense > characterDefense
            ) {
                return true;
            }
        }
        return false;
    }


    private static final long M = 1000000007;

    public int maxPerformance(final int n, final  int[] speed, final int[] efficiency, final int k) {
        final Map<Integer, Integer> speedEfficiencyMap = new HashMap<>();
        BigInteger maximumPerformance = new BigInteger("0");
        for (int i = 0; i < n; i++) {
            maximumPerformance = maximumPerformance.max(BigInteger.valueOf(speed[i] * efficiency[i]));
            speedEfficiencyMap.put(speed[i], efficiency[i]);
        }
        final int result = maximumPerformance.mod(BigInteger.valueOf(1000000007)).intValue();
        if (k == 1) {
            return result;
        }

        for (int currentEngineerIdx = 0; currentEngineerIdx < n; currentEngineerIdx++) {
            final int currentEngineerSpeed = speed[currentEngineerIdx];
            final int currentEngineerEfficiency = speed[currentEngineerIdx];
            final List<BigInteger> currentEngineerPerformance = new ArrayList<>();
            currentEngineerPerformance.add(BigInteger.valueOf(currentEngineerSpeed));
            currentEngineerPerformance.add(BigInteger.valueOf(currentEngineerEfficiency));

            final List<List<BigInteger>> groupPerformance = new ArrayList<>();
            groupPerformance.add(currentEngineerPerformance);

            for (int groupIdx = currentEngineerIdx + 1; groupIdx < n; groupIdx++) {
                final int otherEngineerLastIdx = Math.min(groupIdx + k, n);
                for (int otherEngineerIdx = groupIdx; otherEngineerIdx < otherEngineerLastIdx; otherEngineerIdx++) {

                }
            }
//            maximumPerformance = maximumPerformance.max(BigInteger.valueOf(speed[i] * efficiency[i]));
        }

        return result;
    }


}
