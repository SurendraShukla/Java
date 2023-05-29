package me.surendra;

import org.hamcrest.Matchers;
import org.junit.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertThat;


public class TestUtil {

    public static <T> void assertion(final List<T> expected, final List<T> actual) {
        assertThat(actual.size(), Matchers.equalTo(expected.size()));
        Assert.assertTrue(actual.containsAll(expected) &&  expected.containsAll(actual));
    }

    public static <T> boolean assertTrue(final List<T> expected, final List<T> actual) {
        assertThat(actual.size(), Matchers.equalTo(expected.size()));

        final Set<T> set = new HashSet<>();
        for (final T list : expected) {
            set.add(list);
        }
        for (final T t : actual) {
            if (!set.contains(t)) {
                return false;
            }
        }
        return false;
    }

}
