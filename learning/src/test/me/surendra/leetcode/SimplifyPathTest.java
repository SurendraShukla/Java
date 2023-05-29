package me.surendra.leetcode;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class SimplifyPathTest {
    final Directory directory = new Directory();

    @Test
    public void directoryWithSlashAtEnd() {
        assertThat(directory.simplifyPath("/home/"), equalTo("/home"));
    }

    @Test
    public void directoryWithDoubleDotsAndSlashAtEnd() {
        assertThat(directory.simplifyPath("/../"), equalTo("/"));
    }

    @Test
    public void directoryWithSlashConsequently() {
        assertThat(directory.simplifyPath("/home//foo/"), equalTo("/home/foo"));
    }

    @Test
    public void directoryWith1SingleDot2DoubleDots() {
        assertThat(directory.simplifyPath("/a/./b/../../c/"), equalTo("/c"));
    }

    @Test
    public void directoryWith1SingleDot3TwoDoubleAndExtraSlashes2Times() {
        assertThat(directory.simplifyPath("/a/../../b/../c//.//"), equalTo("/c"));
    }

    @Test
    public void directoryWith2SingleDot1TwoDoubleAndExtraSlashes5Times() {
        assertThat(directory.simplifyPath("/a//b////c/d//././/.."), equalTo("/a/b/c"));
    }

}
