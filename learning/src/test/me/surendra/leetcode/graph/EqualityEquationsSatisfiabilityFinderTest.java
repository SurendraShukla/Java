package me.surendra.leetcode.graph;


import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class EqualityEquationsSatisfiabilityFinderTest {

    private boolean callMethod(final String[] equations) {
        return new EqualityEquationsSatisfiabilityFinder().equationsPossible(equations);
    }

    @Test
    public void test() {
        assertThat(
            callMethod(new String[]{"a==b", "b!=a"}),
            equalTo(false)
        );
    }

}
