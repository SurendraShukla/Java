package me.surendra;

import org.junit.Assert;
import java.util.List;


public class TestUtil {

    public static void assertion(final List<Integer> expected, final List<Integer> actual) {
//        Assert.assertThat(actual.size(), Matchers.equalTo(expected.size()));
        Assert.assertTrue(actual.containsAll(expected) &&  expected.containsAll(actual));
    }

}
