package me.surendra.leetcode.regex;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class BasicParser {

    static boolean isMatch(String text, String pattern) {
        final char dotChar = '.';
        final char starChar= '*';

        final CharacterIterator textIterator = new StringCharacterIterator(text);
        final CharacterIterator patternIterator = new StringCharacterIterator(pattern);

        char patternChar = textIterator.current();;
        char textChar = patternIterator.current();

        while (
            (patternIterator.current() != CharacterIterator.DONE) &&
            (textIterator.current() != CharacterIterator.DONE)
        ) {

            if (patternChar == dotChar) {
                textChar = textIterator.next();
                patternChar = patternIterator.next();
                continue;
            }

            if (patternChar == starChar) {
                char tmpPatternChar = patternIterator.previous();
                while(tmpPatternChar == textIterator.current()) {
                    textChar = textIterator.next();
                }
                patternIterator.next();
                patternChar = patternIterator.next();
                continue;
            }

            if (textChar != patternChar) {
                return false;
            }
            textChar = textIterator.next();
            patternChar = patternIterator.next();

        }

        final boolean b = (patternIterator.current() != CharacterIterator.DONE) || (textIterator.current() != CharacterIterator.DONE);
        return b ? false : true;

    }

//    static char getChar(final CharacterIterator iterator) {
//        if (iterator.current() == CharacterIterator.DONE) {
//            return CharacterIterator.DONE;
//        }
//        return iterator.current();
//    }

}
