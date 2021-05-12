package me.surendra.leetcode.array;

public class ColorSorter {

    /*
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public static void sortColorsUsingExtraArray(int[] nums) {
        final int[] colorsCount = new int[3];
        for (int i = 0; i<nums.length; i++) {
            colorsCount[nums[i]]++;
        }
        for(int j=0, k=0; j<3; j++) {
            while(colorsCount[j] != 0) {
                nums[k++] = j;
                colorsCount[j]--;
            }
        }
    }

    /*
        Time complexity: O(n)
        Space complexity: O(1)
     */
    public static void sortColorsUsing3Pointers(int[] nums) {
        int startPointer=0, endPointer= nums.length-1, i=0;
        while(i <= endPointer) {
            if(nums[i] == 0) {
                swap(nums, i++, startPointer++);
            }else if(nums[i] == 2) {
                swap(nums, i, endPointer--);
            }else {
                i++;
            }
        }
    }

    private static void swap(final int[] nums, final int idx1, final int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
}
