package me.surendra.data_structures.recursion;

public class Array {
    public static boolean isSorted(final int arr[],final int arrLen) {
        if (arrLen == 1) return true;
        return (arr[arrLen-1] < arr[arrLen-2]) ? false : isSorted(arr, arrLen-1);
    }

    public static boolean isSorted(final int startPos, final int arr[]) {
        if (startPos >= arr.length-1) return true;
        return arr[startPos] < arr[startPos+1] && isSorted(startPos+1, arr);
    }
}
