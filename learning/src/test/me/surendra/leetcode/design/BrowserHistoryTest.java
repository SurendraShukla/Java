package me.surendra.leetcode.design;


import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class BrowserHistoryTest {

    @Test
    public void test() {
        final BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");

        assertThat(browserHistory.back(1), equalTo("facebook.com"));
        assertThat(browserHistory.back(1), equalTo("google.com"));
        assertThat(browserHistory.forward(1), equalTo("facebook.com"));

        browserHistory.visit("linkedin.com");

        assertThat(browserHistory.forward(2), equalTo("linkedin.com"));
        assertThat(browserHistory.back(2), equalTo("google.com"));
        assertThat(browserHistory.back(7), equalTo("leetcode.com"));
    }

}
