package me.surendra;

import org.hamcrest.Matchers;
import org.junit.Assert;
import java.util.List;


public class TestUtil {

    public static <T> void assertion(final List<T> expected, final List<T> actual) {
        Assert.assertThat(actual.size(), Matchers.equalTo(expected.size()));
        Assert.assertTrue(actual.containsAll(expected) &&  expected.containsAll(actual));
    }

}
