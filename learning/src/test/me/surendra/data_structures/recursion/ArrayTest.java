package me.surendra.data_structures.recursion;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayTest {

    @Test
    public void shouldReturnTrueForSortedArray() {
        int arr[] = {1, 2, 3, 4, 5};
        assertThat(Array.isSorted(arr, arr.length), equalTo(true));
        assertThat(Array.isSorted(0, arr), equalTo(true));
    }

    @Test
    public void shouldReturnFalseForSortedArray() {
        int arr[] = {10, 9};
        assertThat(Array.isSorted(arr, arr.length), equalTo(false));
        assertThat(Array.isSorted(0, arr), equalTo(false));
    }

}
