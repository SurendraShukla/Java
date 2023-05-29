package me.surendra.leetcode.search.binary_search;

/**
 * @see <a href="https://leetcode.com/problems/kth-missing-positive-number/">Kth Missing Positive Number</a>
 */
public class KthMissingPositiveNumber {

    /*
        Time Complexity - O(log n)
        Space Complexity - O(1)
     */
    public int findKthPositiveUsingBinarySearch(int[] arr, int k) {
        int low = 0;
        int high = arr.length-1;

        while (low <= high) {
            int mid = low + (high-low)/2;
            if (arr[mid] - mid -1 < k) {
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low+k;
    }


    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int findKthPositiveIterative(int[] arr, int k) {
        int expectedMissingNumber = 1;
        for (final int no : arr) {
            if (no == expectedMissingNumber) {
                expectedMissingNumber++;
                continue;
            }
            while((k != 0) && (no != expectedMissingNumber)) {
                k--;
                if (k == 0) {
                    return expectedMissingNumber;
                }
                expectedMissingNumber++;
            }
            expectedMissingNumber++;
        }
        return arr[arr.length-1]+k;
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public int findKthPositiveUsingExtraMemory(int[] arr, int k) {
        int arrLength   = arr.length;
        int arrLastVal  = arr[arrLength-1];

        int[] arrWithMaxCapacity = new int[arrLastVal+1];
        for (final int no : arr) {
            arrWithMaxCapacity[no] = 1;
        }

        for (int j = 1; j < arrWithMaxCapacity.length; j++) {
            if (arrWithMaxCapacity[j] == 0) {
                k--;
                if (k == 0) {
                    return j;
                }
            }
        }

        return arrLastVal + k;
    }

}
