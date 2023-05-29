package me.surendra.leetcode.string.log_files;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class DataReorderTest {

    private String[] callMethod(final String[] logs) {
        return new DataReorder().reorderLogFiles(logs);
    }

    @Test
    public void test1() {
        final String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        final String[] expected = {"let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"};

        final String[] actual = callMethod(logs);
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test2() {
        final String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        final String[] expected = {"g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"};

        final String[] actual = callMethod(logs);
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test3() {
        final String[] logs = {"27 85717 7", "2 y xyr fc", "52 314 99", "d 046099 0", "m azv x f", "7e apw c y", "8 hyyq z p", "6 3272401", "c otdk cl", "8 ksif m u"};
        final String[] expected = {"7e apw c y","m azv x f","8 hyyq z p","8 ksif m u","c otdk cl","2 y xyr fc","27 85717 7","52 314 99","d 046099 0","6 3272401"};

        final String[] actual = callMethod(logs);
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void test4() {

    }
}
