package me.surendra.leetcode.linked_list;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PalindromeCheckerTest {

    @Test
    public void shouldReturnTrueForOneValue() {
        final ListNode linkedListCommon = LinkedList.from(new int[]{RandomUtils.nextInt()});

        assertThat(PalindromeChecker.isPalindrome(linkedListCommon), equalTo(true));
    }


    @Test
    public void shouldReturnTrueForTwoSameValues() {
        int no = RandomUtils.nextInt();
        final ListNode linkedListCommon = LinkedList.from(new int[]{no, no});

        assertThat(PalindromeChecker.isPalindrome(linkedListCommon), equalTo(true));
    }


    @Test
    public void shouldReturnFalseForTwoDifferentValues() {
        int no = RandomUtils.nextInt();
        final ListNode linkedListCommon = LinkedList.from(new int[]{no, no+1});

        assertThat(PalindromeChecker.isPalindrome(linkedListCommon), equalTo(false));
    }

    @Test
    public void shouldReturnTrueForMultipleDifferentValues() {
        final ListNode linkedListCommon = LinkedList.from(new int[]{1, 2, 2, 1});

        assertThat(PalindromeChecker.isPalindrome(linkedListCommon), equalTo(true));
    }

    @Test
    public void shouldReturnFalseForMultipleDifferentValues() {
        final ListNode linkedListCommon = LinkedList.from(new int[]{8, 4, 5});

        assertThat(PalindromeChecker.isPalindrome(linkedListCommon), equalTo(false));
    }

}

