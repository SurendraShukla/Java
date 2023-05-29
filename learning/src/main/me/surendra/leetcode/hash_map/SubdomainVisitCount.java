package me.surendra.leetcode.hash_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/subdomain-visit-count/">Subdomain Visit Count</a>
 */
public class SubdomainVisitCount {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public List<String> subdomainVisits(String[] countPairDomains) {
        final Map<String, Integer> domainVisitMap = new HashMap<>();

        for (final String countPairDomain : countPairDomains) {
            final String[] domainVisitCountInfo = countPairDomain.split(" ");
            final Integer count = Integer.valueOf(domainVisitCountInfo[0]);
            final String[] subDomains = getAllSubDomains(domainVisitCountInfo[1]);

            for (final String domain : subDomains) {
                if(domainVisitMap.containsKey(domain)){
                    domainVisitMap.put(domain, domainVisitMap.get(domain) + count);
                }else{
                    domainVisitMap.put(domain, count);
                }
            }

        }

        final List<String> domainVisits = new ArrayList<>();
        domainVisitMap.forEach((key, val) -> {
            domainVisits.add(val + " " + key);
        });
        return domainVisits;
    }

    private String[] getAllSubDomains(final String domain) {
        final String[] mainDomain = domain.split("\\.");
        final String[] subDomains = new String[mainDomain.length];

        if (mainDomain.length == 3) {
            subDomains[0] = mainDomain[0] + "." + mainDomain[1] + "." + mainDomain[2];
            subDomains[1] = mainDomain[1] + "." + mainDomain[2];
            subDomains[2] = mainDomain[2];
        }else {
            subDomains[0] = mainDomain[0] + "." + mainDomain[1];
            subDomains[1] = mainDomain[1];
        }
        return subDomains;
    }
}
