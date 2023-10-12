package me.surendra.leetcode.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/reorder-data-in-log-files/">Reorder Data in Log Files</a>
 */
public class LetterLog implements Comparable<LetterLog> {
    String identifier;
    String sentence;

    public LetterLog() {
    }

    LetterLog(final String[] letterLogs) {
        this.identifier = letterLogs[0];

        final StringBuilder sb = new StringBuilder();
        for (int i = 1; i < letterLogs.length; i++) {
            sb.append(letterLogs[i]).append(" ");
        }
        this.sentence = sb.toString().trim();
    }

    private String getOriginalString() {
        return identifier + " " + sentence;
    }

    public String[] reorderLogFiles(final String[] logs) {

        final List<LetterLog> letterLogs = new ArrayList<>();
        final List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            final String[] words = log.split(" ");
            if (Character.isDigit(words[1].charAt(0))) {
                digitLogs.add(log);
            } else {
                letterLogs.add(new LetterLog(words));
            }
        }

        Collections.sort(letterLogs);

        final String[] result = new String[logs.length];
        int i = 0;
        for (LetterLog log: letterLogs) {
            result[i++] = log.getOriginalString();
        }
        for (String log: digitLogs) {
            result[i++] = log;
        }

        return result;
    }

    @Override
    public int compareTo(final LetterLog obj) {
        final int sentenceEqual = this.sentence.compareTo(obj.sentence);
        if (sentenceEqual == 0) {
            return this.identifier.compareTo(obj.identifier);
        }
        return sentenceEqual;
    }

    @Override
    public String toString() {
        return "identifier=[" + identifier + "] sentence=[" + sentence + "]";
    }

}
