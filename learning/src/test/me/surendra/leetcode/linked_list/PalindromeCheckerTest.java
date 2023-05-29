package me.surendra.leetcode.linked_list;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class PalindromeCheckerTest {

    private boolean callMethod(final ListNode linkedListCommon) {
        return new PalindromeChecker().isPalindrome(linkedListCommon);
//        return new PalindromeChecker().isPalindromeUsingList(linkedListCommon);
//        return new PalindromeChecker().isPalindromeRecursivelyAdvanced(linkedListCommon);
    }

    @Test
    public void shouldReturnTrueForOneValue() {
        final ListNode linkedListCommon = LinkedList.from(new int[]{RandomUtils.nextInt()});

        assertThat(callMethod(linkedListCommon), equalTo(true));
    }

    @Test
    public void shouldReturnTrueForTwoSameValues() {
        final ListNode linkedListCommon = LinkedList.from(new int[]{1, 1});

        assertThat(callMethod(linkedListCommon), equalTo(true));
    }

    @Test
    public void shouldReturnFalseForTwoDifferentValues() {
        final ListNode linkedListCommon = LinkedList.from(new int[]{1, 2});

        assertThat(callMethod(linkedListCommon), equalTo(false));
    }

    @Test
    public void shouldReturnTrueFor3Values() {
        final ListNode linkedListCommon = LinkedList.from(new int[]{1, 2, 1});

        assertThat(callMethod(linkedListCommon), equalTo(true));
    }

    @Test
    public void shouldReturnTrueForMultipleDifferentValues() {
        final ListNode linkedListCommon = LinkedList.from(new int[]{1, 2, 2, 1});

        assertThat(callMethod(linkedListCommon), equalTo(true));
    }

    @Test
    public void shouldReturnFalseForMultipleDifferentValues() {
        final ListNode linkedListCommon = LinkedList.from(new int[]{8, 4, 5});

        assertThat(callMethod(linkedListCommon), equalTo(false));
    }

    @Test
    public void shouldReturnTrueForMultipleDifferentValues1() {
        final ListNode linkedListCommon = LinkedList.from(new int[]{1, 2, 3, 2, 1});

        assertThat(callMethod(linkedListCommon), equalTo(true));
    }

    @Test
    public void shouldReturnTrueForMultipleDifferentValues2() {
        final ListNode linkedListCommon = LinkedList.from(new int[]{1, 2, 3, 3, 2, 1});

        assertThat(callMethod(linkedListCommon), equalTo(true));
    }

    @Test
    public void test() {
        final Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i <= 10; i++) {
            map.put(i, new ArrayList<>());
        }

        long power = 1;
        map.get(1).add("1");

        for (int i = 2; i <= 31; i++) {
            power *= 2;
            char[] chars = String.valueOf(power).toCharArray();
            Arrays.equals(chars, chars);
            final String number = String.valueOf(power);
            final int numberIdx = number.length();
            map.get(numberIdx).add(number);
            System.out.println(i + ":" + power);
        }

        System.out.println(map);
    }
}
