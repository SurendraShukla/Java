package me.surendra.tdd;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ComparatorTripletTest {

    @Test
    public void whenBothArraysAreEmptyScoreIsZero() {
        verify(asList(), asList(), 0, 0);
    }

    @Test
    public void whenBothArrayHasOneElementAndAHasBiggerElementThenAIsWon() {
        verify(asList(2), asList(1), 1, 0);
    }


    @Test
    public void whenBothArrayHasOneElementAndBHasBiggerElementThenBIsWon() {
        verify(asList(1), asList(2), 0, 1);
    }

    @Test
    public void whenBothArrayHas2ElementsAndElementsAreSame() {
        verify(asList(1,2), asList(1,2), 0, 0);
    }

    @Test
    public void whenBothArrayHas2ElementsAndAHas2ElementGreaterThanB2ndElement() {
        verify(asList(1,3), asList(1,2), 1, 0);
    }

    private void verify(final List<Integer> listA, final List<Integer> listB, final int aScore, final int bScore) {
        List<Integer> score = score(listA, listB);
        assertThat(score.size(), is(2));

        assertThat(score.get(0), is(aScore));
        assertThat(score.get(1), is(bScore));
    }



    private List<Integer> score(final List<Integer> listA, final List<Integer> listB) {
        int scoreA = 0;
        int scoreB = 0;

        for(int index=0; index<listA.size(); index++) {
            if( listA.get(index) > listB.get(index) ) {
                scoreA++;
            }
            if (listB.get(index) > listA.get(index)) {
                scoreB++;
            }
        }
        return asList(scoreA, scoreB);

    }

    private List<Integer> asList(Integer... ints) {
        return Arrays.asList(ints);
    }
}
