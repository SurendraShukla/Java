package me.surendra.leetcode.string;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class LetterLogTest {

    String[] callMethod(final String[] logs) {
        final LetterLog letterLog = new LetterLog();

        return letterLog.reorderLogFiles(logs);
    }

    @Test
    public void test1() {
        final String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};

        // execute
        final String[] actual = callMethod(logs);

        final String[] expected = {"let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6"};
        assertThat(actual, equalTo(expected));
    }


    @Test
    public void test2() {
        final String[] logs = {"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};

        // execute
        final String[] actual = callMethod(logs);

        final String[] expected = {"g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7"};
        assertThat(actual, equalTo(expected));
    }


    @Test
    public void test3() {
        final String[] logs = {"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo", "a2 act car"};

        // execute
        final String[] actual = callMethod(logs);

        final String[] expected = {"a2 act car", "g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7"};
        assertThat(actual, equalTo(expected));
    }


    @Test
    public void test4() {
        final String[] logs = {"zoey i love you", "lucas i love you", "rong i love you"};

        // execute
        final String[] actual = callMethod(logs);

        final String[] expected = {"lucas i love you", "rong i love you", "zoey i love you"};
        assertThat(actual, equalTo(expected));
    }


    @Test
    public void test5() {
        final String[] logs = {"27 85717 7",  "2 y xyr fc",  "52 314 99",  "d 046099 0",  "m azv x f",  "7e apw c y",  "8 hyyq z p",  "6 3272401",  "c otdk cl",  "8 ksif m u"};

        // execute
        final String[] actual = callMethod(logs);

        final String[] expected = {"7e apw c y", "m azv x f", "8 hyyq z p", "8 ksif m u", "c otdk cl", "2 y xyr fc", "27 85717 7", "52 314 99", "d 046099 0", "6 3272401"};
        assertThat(actual, equalTo(expected));
    }

}
