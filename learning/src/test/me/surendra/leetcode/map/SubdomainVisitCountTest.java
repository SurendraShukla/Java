package me.surendra.leetcode.map;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SubdomainVisitCountTest {

    private List<String> callMethod(final String[] cpDomains) {
        return new SubdomainVisitCount().subdomainVisits(cpDomains);
    }

    @Test
    public void test1() {
        final String[] cpDomains = {"9001 discuss.leetcode.com"};

        // execute
        final List<String> subDomainVisits = callMethod(cpDomains);

        final List<String> expectedCountPairDomains = Arrays.asList("9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com");
        assertTrue(subDomainVisits.containsAll(expectedCountPairDomains));
    }

    @Test
    public void test2() {
        final String[] cpDomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};

        // execute
        final List<String> subDomainVisits = callMethod(cpDomains);

        final List<String> expectedCountPairDomains = Arrays.asList("901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com");
        assertTrue(subDomainVisits.containsAll(expectedCountPairDomains));
    }

}
