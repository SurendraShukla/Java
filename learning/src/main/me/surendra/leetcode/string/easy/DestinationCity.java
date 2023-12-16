package me.surendra.leetcode.string.easy;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @see <a href="https://leetcode.com/problems/destination-city/">Destination City</a>
 */
public class DestinationCity {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)

        Set for outgoing edges/city
     */
    public String destCity(final List<List<String>> paths) {
        final Set<String> hasOutgoing = new HashSet();
        for (int i = 0; i < paths.size(); i++) {
            hasOutgoing.add(paths.get(i).get(0));
        }

        for (int i = 0; i < paths.size(); i++) {
            final String candidate = paths.get(i).get(1);
            if (!hasOutgoing.contains(candidate)) {
                return candidate;
            }
        }

        return "";
    }

}
