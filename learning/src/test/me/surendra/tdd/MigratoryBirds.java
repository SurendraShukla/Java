package me.surendra.tdd;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class MigratoryBirds {

    @Test
    public void shouldReturnSingleOccurrenceForOneBird() {
        int birdId = RandomUtils.nextInt();
        verifyResult(birdId, 1, birdId);
    }

    @Test
    public void shouldReturnLowerNumberBirdOccurrenceForBirdsWithOneOccurrenceEach() {
        verifyResult(1, 1, 2, 1);
    }

    @Test
    public void shouldReturnBirdWithMaxNumberOfOccurrences() {
        verifyResult(2, 2, 2, 2, 1);
    }

    @Test
    public void shouldWorkForHackerRankInput() {
        verifyResult(1, 2, 1, 1, 2, 2, 3);
        verifyResult(4, 3, 1, 4, 4, 4, 5, 3);
        verifyResult(3, 3, 1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4);
    }



    private void verifyResult(final int birdId, final int occurrence, final int... input) {
        final int[] out = migratoryBirds(input);
        assertThat(out[0], equalTo(birdId));
        assertThat(out[1], equalTo(occurrence));
    }


    private int[] migratoryBirds(final int... input) {
        final AtomicInteger maxOccurrence = new AtomicInteger();
        final Map<Integer, Integer> birdOccurrences = new HashMap<>();

        for (int birdId : input) {
            int count = birdOccurrences.compute(birdId, (k, v) -> v == null ? 1 : ++v);
            if (count > maxOccurrence.intValue()) {
                maxOccurrence.set(count);
            }
        }

        int[] output = new int[2];
        output[0] = birdOccurrences.entrySet().stream().filter(e -> e.getValue() == maxOccurrence.intValue()).mapToInt(Map.Entry::getKey).min().orElse(0);
        output[1] = maxOccurrence.intValue();
        return output;
    }

}
