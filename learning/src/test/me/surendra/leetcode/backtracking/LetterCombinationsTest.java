package me.surendra.leetcode.backtracking;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class LetterCombinationsTest {

    private List<String> callMethod(final String digits) {
//        return new LetterCombinations().letterCombinations(digits);
        return new LetterCombinations().letterCombinationsUsingBacktracking(digits);
    }

    @Test
    public void test1() {
        final List<String> expected = Lists.newArrayList();

        assertThat(callMethod("").size(), equalTo(expected.size()));
    }

    @Test
    public void test2() {
        final List<String> expected = Lists.newArrayList("a", "b", "c");

        assertThat(callMethod("2").size(), equalTo(expected.size()));
    }

    @Test
    public void test3() {
        final List<String> expected = Lists.newArrayList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");

        assertThat(callMethod("23").size(), equalTo(expected.size()));
    }

    /*
    @Test
    public void test4() {
        final List<String> expected = Lists.newArrayList("mptw","nptw","optw","mqtw","nqtw","oqtw","mrtw","nrtw","ortw","mstw","nstw","ostw","mpuw","npuw","opuw","mquw","nquw","oquw","mruw","nruw","oruw","msuw","nsuw","osuw","mpvw","npvw","opvw","mqvw","nqvw","oqvw","mrvw","nrvw","orvw","msvw","nsvw","osvw","mptx","nptx","optx","mqtx","nqtx","oqtx","mrtx","nrtx","ortx","mstx","nstx","ostx","mpux","npux","opux","mqux","nqux","oqux","mrux","nrux","orux","msux","nsux","osux","mpvx","npvx","opvx","mqvx","nqvx","oqvx","mrvx","nrvx","orvx","msvx","nsvx","osvx","mpty","npty","opty","mqty","nqty","oqty","mrty","nrty","orty","msty","nsty","osty","mpuy","npuy","opuy","mquy","nquy","oquy","mruy","nruy","oruy","msuy","nsuy","osuy","mpvy","npvy","opvy","mqvy","nqvy","oqvy","mrvy","nrvy","orvy","msvy","nsvy","osvy","mptz","nptz","optz","mqtz","nqtz","oqtz","mrtz","nrtz","ortz","mstz","nstz","ostz","mpuz","npuz","opuz","mquz","nquz","oquz","mruz","nruz","oruz","msuz","nsuz","osuz","mpvz","npvz","opvz","mqvz","nqvz","oqvz","mrvz","nrvz","orvz","msvz","nsvz");

        final List<String> actual = new LetterCombinations().letterCombinations("6789");

        assertThat(actual.size(), equalTo(expected.size()));
    }
    */

}
