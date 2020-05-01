package me.surendra.tdd;

import java.util.HashMap;
import java.util.Map;

public class ScoreCard {
    private static final Map<String, Integer> SCORES = new HashMap<>();
    {
        SCORES.put("single", 1);
        SCORES.put("double", 2);
        SCORES.put("triple", 3);
        SCORES.put("homerun", 4);
    }

    private int awayScore = 0;
    private int homeScore = 0;
    private int outCount = 0;

    public void addEntry(final String entry) {
        if ("out".equals(entry)) {
            outCount++;
        }
        if(outCount < 3) {
            awayScore += SCORES.getOrDefault(entry, 0);
        }else{
            homeScore += SCORES.getOrDefault(entry, 0);
        }

    }

    public String getScore() {
        return String.format("Home: %d Away: %d", homeScore/4, awayScore / 4);
    }
}

//
//Enum Run {
//    SINGLE,
//    DOUBLE,
//    TRIPLE,
//    HOMERUN,
//    OUT
//}
