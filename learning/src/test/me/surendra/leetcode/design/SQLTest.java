package me.surendra.leetcode.design;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class SQLTest {

    @Test
    public void test() {
        final SQL sql = new SQL(Arrays.asList("one", "two", "three"), Arrays.asList(2, 3, 1));
        sql.insertRow("two", Arrays.asList("first", "second", "third"));

        assertThat(sql.selectCell("two", 1, 3), equalTo("third"));

        sql.insertRow("two", Arrays.asList("fourth", "fifth", "sixth"));
        sql.deleteRow("two", 1);

        assertThat(sql.selectCell("two", 2, 2), equalTo("fifth"));
    }
}
