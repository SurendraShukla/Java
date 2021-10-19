package me.surendra.leetcode.string.log_files;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @see <a href="https://leetcode.com/problems/reorder-data-in-log-files/">Reorder Data in Log Files</a>
 */
public class DataReorder {

    /*
        Time complexity : O(n)
        Space complexity: O(n)
     */
    public String[] reorderLogFiles(String[] logs) {
        final Map<String, String> letterLogs = new HashMap<>();
        final List<String> digitLogs = new ArrayList<>();
        for (final String log : logs) {
            final String[] logStrings = log.split(" ", 2);
            if(Character.isDigit(logStrings[1].charAt(0))) {
                digitLogs.add(log);
            }else{
                letterLogs.put(log, logStrings[1]);
            }
        }
        final LinkedHashMap<String, String> sortedLetterLogs = letterLogs.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1, e2) -> e2,
                    LinkedHashMap::new
                )
            );

        final String[] returnString = new String[logs.length];
        int counter = 0;
        for (final String stringEntry : sortedLetterLogs.keySet()) {
            returnString[counter++] = stringEntry;
        }
        for (final String digitLog : digitLogs) {
            returnString[counter++] = digitLog;
        }
        return returnString;
    }

}
