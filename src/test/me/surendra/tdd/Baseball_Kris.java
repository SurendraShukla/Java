package me.surendra.tdd;

import com.google.common.collect.Maps;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

import java.util.Map;
import java.util.Objects;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

// https://www.codewars.com/kata/baseball
public class Baseball_Kris {

    @Test
    public void shouldCreateScorecard() {
        final Scorecard scorecard = Scorecard.create();
        assertThat(scorecard, notNullValue());
    }
    @Test
    public void shouldGetScore() {
        final Scorecard scorecard = Scorecard.create();
        assertThat(scorecard.getScore(), equalTo("Home: 0 Away: 0"));
    }
    @Test
    public void shouldHaveEntries() {
        assertThat(Entry.SINGLE.name(), equalTo("SINGLE"));
        assertThat(Entry.DOUBLE.name(), equalTo("DOUBLE"));
        assertThat(Entry.TRIPLE.name(), equalTo("TRIPLE"));
        assertThat(Entry.HOME_RUN.name(), equalTo("HOME_RUN"));
        assertThat(Entry.OUT.name(), equalTo("OUT"));
    }
    @Test
    public void shouldHaveTuple() {
        final int runsScored = RandomUtils.nextInt();
        final int nextState = RandomUtils.nextInt();
        final State t = State.create(runsScored, nextState);
        assertThat(t, notNullValue());
        assertThat(t.getRunsScord(), equalTo(runsScored));
        assertThat(t.getNextState(), equalTo(nextState));
        assertThat(t, equalTo(State.create(runsScored, nextState)));
    }
    @Test
    public void shouldHaveSingleHitState() {
        final Map<Integer, State> expected = Maps.newHashMap();
        expected.put(0, State.create(0, 4));
        expected.put(1, State.create(1, 4));
        expected.put(2, State.create(0, 5));
        expected.put(3, State.create(1, 5));
        expected.put(4, State.create(0, 6));
        expected.put(5, State.create(1, 6));
        expected.put(6, State.create(0, 7));
        expected.put(7, State.create(1, 7));
        final Map<Integer, State> result = Scorecard.create().getSingles();
        assertThat(result, equalTo(expected));
    }
    @Test
    public void shouldHaveDoubleHitState() {
        final Map<Integer, State> expected = Maps.newHashMap();
        expected.put(0, State.create(0, 2));
        expected.put(1, State.create(1, 2));
        expected.put(2, State.create(1, 2));
        expected.put(3, State.create(2, 2));
        expected.put(4, State.create(0, 3));
        expected.put(5, State.create(1, 3));
        expected.put(6, State.create(1, 3));
        expected.put(7, State.create(2, 3));
        final Map<Integer, State> result = Scorecard.create().getDoubles();
        assertThat(result, equalTo(expected));
    }
    @Test
    public void shouldHaveTripleHitState() {
        final Map<Integer, State> expected = Maps.newHashMap();
        expected.put(0, State.create(0, 1));
        expected.put(1, State.create(1, 1));
        expected.put(2, State.create(1, 1));
        expected.put(3, State.create(2, 1));
        expected.put(4, State.create(1, 1));
        expected.put(5, State.create(2, 1));
        expected.put(6, State.create(2, 1));
        expected.put(7, State.create(3, 1));
        final Map<Integer, State> result = Scorecard.create().getTriples();
        assertThat(result, equalTo(expected));
    }
    @Test
    public void shouldHaveHomeRunsHitState() {
        final Map<Integer, State> expected = Maps.newHashMap();
        expected.put(0, State.create(1, 0));
        expected.put(1, State.create(2, 0));
        expected.put(2, State.create(2, 0));
        expected.put(3, State.create(3, 0));
        expected.put(4, State.create(2, 0));
        expected.put(5, State.create(3, 0));
        expected.put(6, State.create(3, 0));
        expected.put(7, State.create(4, 0));
        final Map<Integer, State> result = Scorecard.create().getHomeRuns();
        assertThat(result, equalTo(expected));
    }
    @Test
    public void shouldAddEntry() {
        Scorecard.create().addEntry(Entry.DOUBLE);
    }
    @Test
    public void shouldGetOuts() {
        final Scorecard scorecard = Scorecard.create();
        assertThat(scorecard.getOuts(), equalTo(0));
    }
    @Test
    public void shouldGetAtBat() {
        final Scorecard scorecard = Scorecard.create();
        assertThat(scorecard.getAtBat(), equalTo(AtBat.AWAY));
    }
    @Test
    public void shouldSwitchSidesAfter3Outs() {
        final Scorecard scorecard = Scorecard.create();
        assertThat(scorecard.getAtBat(), equalTo(AtBat.AWAY));
        scorecard.addEntry(Entry.OUT);
        assertThat(scorecard.getAtBat(), equalTo(AtBat.AWAY));
        scorecard.addEntry(Entry.OUT);
        assertThat(scorecard.getAtBat(), equalTo(AtBat.AWAY));
        scorecard.addEntry(Entry.OUT);
        assertThat(scorecard.getAtBat(), equalTo(AtBat.HOME));
        assertThat(scorecard.getAtBat(), equalTo(AtBat.HOME));
        scorecard.addEntry(Entry.OUT);
        assertThat(scorecard.getAtBat(), equalTo(AtBat.HOME));
        scorecard.addEntry(Entry.OUT);
        assertThat(scorecard.getAtBat(), equalTo(AtBat.HOME));
        scorecard.addEntry(Entry.OUT);
        assertThat(scorecard.getAtBat(), equalTo(AtBat.AWAY));
    }
    @Test
    public void shouldRawScore() {
        final Scorecard scorecard = Scorecard.create();
        final Map<AtBat, Integer> expected = Maps.newHashMap();
        expected.put(AtBat.AWAY, 0);
        expected.put(AtBat.HOME, 0);
        assertThat(scorecard.getRawScore(), equalTo(expected));
    }
    @Test
    public void shouldGetTallyScore() {
        final Scorecard scorecard = Scorecard.create();
        assertThat(scorecard.getScore(), equalTo("Home: 0 Away: 0"));
        scorecard.addEntry(Entry.HOME_RUN);
        final Map<AtBat, Integer> expected = Maps.newHashMap();
        expected.put(AtBat.AWAY, 1);
        expected.put(AtBat.HOME, 0);
        assertThat(scorecard.getRawScore(), equalTo(expected));
        assertThat(scorecard.getScore(), equalTo("Home: 0 Away: 1"));
    }
    @Test
    public void shouldScore4Singles() {
        final Map<AtBat, Integer> expected = Maps.newHashMap();
        expected.put(AtBat.AWAY, 0);
        expected.put(AtBat.HOME, 0);
        final Scorecard scorecard = Scorecard.create();
        assertThat(scorecard.getState(), equalTo(0));
        assertThat(scorecard.getScore(), equalTo("Home: 0 Away: 0"));
        scorecard.addEntry(Entry.SINGLE);
        assertThat(scorecard.getState(), equalTo(4));
        assertThat(scorecard.getScore(), equalTo("Home: 0 Away: 0"));
        scorecard.addEntry(Entry.SINGLE);
        assertThat(scorecard.getState(), equalTo(6));
        assertThat(scorecard.getScore(), equalTo("Home: 0 Away: 0"));
        scorecard.addEntry(Entry.SINGLE);
        assertThat(scorecard.getState(), equalTo(7));
        assertThat(scorecard.getScore(), equalTo("Home: 0 Away: 0"));
        scorecard.addEntry(Entry.SINGLE);
        assertThat(scorecard.getState(), equalTo(7));
        assertThat(scorecard.getScore(), equalTo("Home: 0 Away: 1"));
    }
    @Test
    public void shouldRunGame() {
        final Scorecard scorecard = Scorecard.create();
        scorecard.addEntry(Entry.OUT);
        scorecard.addEntry(Entry.OUT);
        scorecard.addEntry(Entry.SINGLE);
        scorecard.addEntry(Entry.OUT);
        assertThat(scorecard.getScore(), equalTo("Home: 0 Away: 0"));
        scorecard.addEntry(Entry.OUT);
        scorecard.addEntry(Entry.DOUBLE);
        scorecard.addEntry(Entry.SINGLE);
        scorecard.addEntry(Entry.OUT);
        scorecard.addEntry(Entry.SINGLE);
        scorecard.addEntry(Entry.OUT);
        assertThat(scorecard.getScore(), equalTo("Home: 1 Away: 0"));
    }
    private static class Scorecard {
        private final Map<Integer, State> singles;
        private final Map<Integer, State> doubles;
        private final Map<Integer, State> triples;
        private final Map<Integer, State> homeRuns;
        private AtBat atBat = AtBat.AWAY;
        private int outs = 0;
        private final Map<AtBat, Integer> score = Maps.newHashMap();
        private int state = 0;
        private Scorecard() {
            score.put(AtBat.AWAY, 0);
            score.put(AtBat.HOME, 0);
            singles = Maps.newHashMap();
            singles.put(0, State.create(0, 4));
            singles.put(1, State.create(1, 4));
            singles.put(2, State.create(0, 5));
            singles.put(3, State.create(1, 5));
            singles.put(4, State.create(0, 6));
            singles.put(5, State.create(1, 6));
            singles.put(6, State.create(0, 7));
            singles.put(7, State.create(1, 7));
            doubles = Maps.newHashMap();
            doubles.put(0, State.create(0, 2));
            doubles.put(1, State.create(1, 2));
            doubles.put(2, State.create(1, 2));
            doubles.put(3, State.create(2, 2));
            doubles.put(4, State.create(0, 3));
            doubles.put(5, State.create(1, 3));
            doubles.put(6, State.create(1, 3));
            doubles.put(7, State.create(2, 3));
            triples = Maps.newHashMap();
            triples.put(0, State.create(0, 1));
            triples.put(1, State.create(1, 1));
            triples.put(2, State.create(1, 1));
            triples.put(3, State.create(2, 1));
            triples.put(4, State.create(1, 1));
            triples.put(5, State.create(2, 1));
            triples.put(6, State.create(2, 1));
            triples.put(7, State.create(3, 1));
            homeRuns = Maps.newHashMap();
            homeRuns.put(0, State.create(1, 0));
            homeRuns.put(1, State.create(2, 0));
            homeRuns.put(2, State.create(2, 0));
            homeRuns.put(3, State.create(3, 0));
            homeRuns.put(4, State.create(2, 0));
            homeRuns.put(5, State.create(3, 0));
            homeRuns.put(6, State.create(3, 0));
            homeRuns.put(7, State.create(4, 0));
        }
        static Scorecard create() {
            return new Scorecard();
        }
        public void addEntry(final Entry entry) {
            if (entry == Entry.OUT) {
                outs++;
                if (outs >= 3) {
                    atBat = atBat == AtBat.HOME ? AtBat.AWAY : AtBat.HOME;
                    outs = 0;
                    state = 0;
                }
            } else if (entry == Entry.SINGLE) {
                final State nextState = singles.get(state);
                score.put(atBat, score.get(atBat) + nextState.runsAdded);
                state = nextState.nextState;
            } else if (entry == Entry.DOUBLE) {
                final State nextState = doubles.get(state);
                score.put(atBat, score.get(atBat) + nextState.runsAdded);
                state = nextState.nextState;
            } else if (entry == Entry.TRIPLE) {
                final State nextState = triples.get(state);
                score.put(atBat, score.get(atBat) + nextState.runsAdded);
                state = nextState.nextState;
            } else if (entry == Entry.HOME_RUN) {
                final State nextState = homeRuns.get(state);
                score.put(atBat, score.get(atBat) + nextState.runsAdded);
                state = nextState.nextState;
            }
        }
        public String getScore() {
            return "Home: " + score.get(AtBat.HOME) + " Away: " + score.get(AtBat.AWAY);
        }
        public Map<Integer, State> getSingles() {
            return singles;
        }
        public Map<Integer, State> getDoubles() {
            return doubles;
        }
        public Map<Integer, State> getTriples() {
            return triples;
        }
        public Map<Integer, State> getHomeRuns() {
            return homeRuns;
        }
        public int getOuts() {
            return 0;
        }
        public AtBat getAtBat() {
            return atBat;
        }
        public Map<AtBat, Integer> getRawScore() {
            return score;
        }
        public int getState() {
            return state;
        }
    }
    private enum Entry {
        SINGLE, DOUBLE, TRIPLE, HOME_RUN, OUT;
    }
    private enum AtBat {
        HOME, AWAY;
    }
    private static class State {
        private final int runsAdded;
        private final int nextState;
        private State(final int runsAdded, final int nextState) {
            this.runsAdded = runsAdded;
            this.nextState = nextState;
        }
        public static State create(final int runsScored, final int nextState) {
            return new State(runsScored, nextState);
        }
        public int getRunsScord() {
            return runsAdded;
        }
        public int getNextState() {
            return nextState;
        }
        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final State tuple = (State) o;
            return runsAdded == tuple.runsAdded &&
                nextState == tuple.nextState;
        }
        @Override
        public int hashCode() {
            return Objects.hash(runsAdded, nextState);
        }
    }
}
