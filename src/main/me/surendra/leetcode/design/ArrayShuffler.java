package me.surendra.leetcode.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @see <a href="https://leetcode.com/problems/shuffle-an-array/solution/">Shuffle an Array</a>
 */
public class ArrayShuffler {
    final private Random rand = new Random();

    private int[] original;
    private int[] array;
    private int arrLen;

    public ArrayShuffler(int[] nums) {
        array = nums;
        original = nums.clone();
        arrLen = array.length;
    }

    public int[] reset() {
        array = original.clone();
        return array;
    }

    /*
        Time complexity : O(n2)
        Space complexity: O(n)
     */
    public int[] shuffleByBruteForce() {
        final List<Integer> aux = getArrayCopy();

        for (int i = 0; i < arrLen; i++) {
            final int removeIdx = rand.nextInt(aux.size());
            array[i] = aux.get(removeIdx);
            aux.remove(removeIdx);
        }

        return array;
    }

    private List<Integer> getArrayCopy() {
        final List<Integer> asList = new ArrayList<>();
        for (int i = 0; i < arrLen; i++) {
            asList.add(array[i]);
        }
        return asList;
    }

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public int[] shuffleByFisherYates() {
        for (int i = 0; i < arrLen; i++) {
            swap(array, i, randRange(0, arrLen));
        }
        return array;
    }

    private void swap(final int[] array, final int index, final int replaceIndex) {
        final int tmp = array[index];
        array[index] = array[replaceIndex];
        array[replaceIndex] = tmp;
    }

    private int randRange(final int min, final int max) {
        return min + rand.nextInt(max - min);
    }

}
