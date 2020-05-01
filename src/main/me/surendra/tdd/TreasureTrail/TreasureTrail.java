package me.surendra.tdd.TreasureTrail;

import com.google.common.collect.Sets;

import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

public class TreasureTrail {

    private final int diff1;
    private final int diff2;

    public TreasureTrail(int diff1, int diff2) {
        this.diff1 = diff1;
        this.diff2 = diff2;
    }

    public Set<Integer> getPossibleFinalStones(int numberOfStones) {
        //       return setOf(0);
        //       return (numberOfStones == 1) ? setOf(0) : setOf(diff1, diff2);

        Stream<Integer> stream = Stream.of(0);
        for (int i = 2; i <= numberOfStones; i++) {
            stream = stream.flatMap(stone -> nextStone(stone).stream());
        }
        return stream.collect(toSet());
    }

    public Set<Integer> nextStone(int currentStone) {
//        return setOf(currentStone + diff1, currentStone + diff2);
        return Sets.newHashSet();
    }
}
