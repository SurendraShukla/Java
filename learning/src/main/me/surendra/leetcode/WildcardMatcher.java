package me.surendra.leetcode;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/**
 * @see <a href="https://leetcode.com/problems/wildcard-matching/">Wildcard Matching</a>
 */
public class WildcardMatcher {

    /*
        Time complexity : O(n)
        Space complexity: O(1)
     */
    public boolean isMatch(String s, String p) {
        final CharacterIterator tokenIterator = new StringCharacterIterator(p);
        final CharacterIterator charIterator = new StringCharacterIterator(s);

        while (tokenIterator.current() != CharacterIterator.DONE) {
            char token = tokenIterator.current();
            switch (token) {
                case '*':
                    if(!isMatch(tokenIterator, charIterator)) {
                        return false;
                    }
                    break;
                case '?':
                    tokenIterator.next();
                    charIterator.next();
                    break;
                default:
                    if (charIterator.current() != tokenIterator.current()) {
                        return false;
                    }
                    tokenIterator.next();
                    charIterator.next();
            }

        }

        if (charIterator.current() != CharacterIterator.DONE ||
            tokenIterator.current() != CharacterIterator.DONE
        ) {
            return false;
        }

        return true;
    }

    private boolean isMatch(final CharacterIterator tokenIterator, final CharacterIterator charIterator) {
        while(tokenIterator.current() != CharacterIterator.DONE &&
            (tokenIterator.current() == '*' || tokenIterator.current() == '?')
        ) {
            tokenIterator.next();
        }
        if (tokenIterator.current() == CharacterIterator.DONE) {
            while (charIterator.current() != CharacterIterator.DONE) {
                charIterator.next();
            }
            return true;
        }

        char tokenChar = tokenIterator.current();
        while (charIterator.current() != CharacterIterator.DONE &&
            charIterator.current() != tokenChar
        ) {
           charIterator.next();
        }
        if (charIterator.current() != CharacterIterator.DONE) {
            return true;
        }
        return false;
    }

}
