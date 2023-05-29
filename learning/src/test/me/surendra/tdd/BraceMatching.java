package me.surendra.tdd;

import org.junit.Test;


import java.util.HashMap;
import java.util.Stack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BraceMatching {

    public void testOne() {
        assertThat(evaluate("{}"), is(true));
    }

    @Test
    public void testTwo() {
        assertThat(evaluate("{}{"), is(false));
    }

    @Test
    public void testThree() {
        assertThat(evaluate("[]"), is(true));
    }

    @Test
    public void testFour() {
        assertThat(evaluate("]["), is(false));
    }

    @Test
    public void testFive() {
        assertThat(evaluate("()"), is(true));
    }

    @Test
    public void testSix() {
        assertThat(evaluate(")("), is(false));
    }

    @Test
    public void testSeven() {
        assertThat(evaluate("{[()]}"), is(true));
    }

    @Test
    public void testEight() { assertThat(evaluate("{{([[[({})]]])}}"), is(true)); }

    @Test
    public void testNine() {
        assertThat(evaluate("{[(})]"), is(false));
    }

    @Test
    public void testTen() {
        assertThat(evaluate("{(]({[]})[)}"), is(false));
    }

    @Test
    public void testEleven() {
        assertThat(evaluate("{{{}()}[[()({})]]}"), is(true));
    }

    @Test
    public void testTwelve() { assertThat(evaluate("{([][])(){}}()[]({[]()[]})"), is(true)); }

    @Test
    public void testThirteen() {
        assertThat(evaluate("{{({}{})}[(])[]()}"), is(false));
    }

    @Test
    public void testFourteen() {
        assertThat(evaluate("{{([][])}}{()[]}}}"), is(false));
    }

    @Test
    public void testFifteen() {
        assertThat(evaluate("{"), is(false));
    }

    @Test
    public void testSixteen() {
        assertThat(evaluate("((([]))"), is(false));
    }

    @Test
    public void testSeventeen()
    {
        assertThat(evaluate("(({}))))"), is(false));
    }

    @Test
    public void testEighteen() {
        assertThat(evaluate("{[(})]}"), is(false));
    }

    @Test
    public void testNineteen() {
        assertThat(evaluate("{[(])}"), is(false));
    }

    @Test
    public void testTwenty() {
        assertThat(evaluate(null), is(false));
    }

    @Test
    public void testTwentyOne()
    {
        assertThat(evaluate(""), is(true));
    }

    private Boolean evaluate(String input) {

        if (input == null) {
            return false;
        }

        if ( (input.length() % 2) !=0 ) {
            return false;
        }

        Stack<Character> charStack = new Stack<>();
        HashMap<Character, Character> bracketList = getBracketHashMap();


        for (int counter=0; counter< input.length(); counter++) {

            Character currentCh = input.charAt(counter);
            Character openingBracket = bracketList.get(currentCh);

            // If its opening bracket, map is going to return null
            // Add currentChar in Stack
            if ( openingBracket == null ) {
                charStack.add(currentCh);
                continue;
            }

            try {
                Character popedBracket = charStack.pop();
                if ( !openingBracket.equals(popedBracket) ) {
                    return false;
                }
            }catch (Exception e) {
                return false;
            }


        }
        return true;

    }

    private HashMap<Character, Character> getBracketHashMap() {
        HashMap<Character , Character> bracketList = new HashMap<>();
        bracketList.put('}', '{');
        bracketList.put(')', '(');
        bracketList.put(']', '[');
        return bracketList;
    }

}

