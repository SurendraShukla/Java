package me.surendra.leetcode.graph;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class AccountsMergeTest {

    private List<List<String>> callMethod(final List<List<String>> accounts) {
        return new AccountsMerge().accountsMergeUsingFindUnion(accounts);
//        return new AccountsMerge().accountsMerge(accounts);
    }

    private List<List<String>> convertStringArrayToList(final String[][] accounts) {
        return Stream.of(accounts)
            .map(nameWithEmailAddresses -> Stream.of(nameWithEmailAddresses).collect(Collectors.toList()))
            .collect(Collectors.toList());
    }

    @Test
    public void test1() {
        // Arrange
        final String[][] accounts = {
            {"John","john_newyork@mail.com","johnsmith@mail.com"},
            {"John","johnsmith@mail.com","john00@mail.com"},
            {"Mary","mary@mail.com"},
            {"John","johnnybravo@mail.com"}
        };
        final String[][] expected = {
            {"John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"},
            {"Mary","mary@mail.com"},
            {"John","johnnybravo@mail.com"}
        };
        final List<List<String>> expectedAccounts = convertStringArrayToList(expected);

        // Act
        final List<List<String>> actual = callMethod(convertStringArrayToList(accounts));

        // Assert
        assertThat(actual.size(), equalTo(expectedAccounts.size()));
    }

    @Test
    public void test2() {
        // Arrange
        final String[][] emailAccounts = {
            {"Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"},
            {"Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"},
            {"Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"},
            {"Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"},
            {"Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"}
        };
        final String[][] expected = {
            {"Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"},
            {"Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"},
            {"Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"},
            {"Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"},
            {"Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"}
        };
        final List<List<String>> expectedAccounts = convertStringArrayToList(expected);

        // Act
        final List<List<String>> actual = callMethod(convertStringArrayToList(emailAccounts));

        // Assert
        assertThat(actual.size(), equalTo(expectedAccounts.size()));
    }

    @Test
    public void test3_MergeHappensAfterSometime() {
        final String[][] accounts = {
            {"David","David0@m.co","David1@m.co"},
            {"David","David3@m.co","David4@m.co"},
            {"David","David4@m.co","David5@m.co"},
            {"David","David2@m.co","David3@m.co"},
            {"David","David1@m.co","David2@m.co"}
        };
        final String[][] expected = {
            {"David","David0@m.co","David1@m.co","David2@m.co","David3@m.co","David4@m.co","David5@m.co"}
        };
        final List<List<String>> expectedAccounts = convertStringArrayToList(expected);

        // Act
        final List<List<String>> actual = callMethod(convertStringArrayToList(accounts));

        // Assert
        assertThat(actual.size(), equalTo(expectedAccounts.size()));
    }

    @Test
    public void test4_MergeHappensAfterSometime() {
        final String[][] accounts = {
            {"Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"},
            {"Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"},
            {"Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"},
            {"Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"},
            {"Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"}
        };
        final String[][] expected = {
            {"Alex","Alex0@m.co","Alex4@m.co","Alex5@m.co"},
            {"Ethan","Ethan0@m.co","Ethan3@m.co"},
            {"Gabe","Gabe0@m.co","Gabe2@m.co","Gabe3@m.co","Gabe4@m.co"},
            {"Kevin","Kevin2@m.co","Kevin4@m.co"}
        };
        final List<List<String>> expectedAccounts = convertStringArrayToList(expected);

        // Act
        final List<List<String>> actual = callMethod(convertStringArrayToList(accounts));

        // Assert
        assertThat(actual.size(), equalTo(expectedAccounts.size()));
    }

}
