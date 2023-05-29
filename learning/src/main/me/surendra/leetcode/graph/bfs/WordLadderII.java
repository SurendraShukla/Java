package me.surendra.leetcode.graph.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @see <a href="https://leetcode.com/problems/word-ladder-ii/">Word Ladder II</a>
 */
public class WordLadderII {

    final private Map<String, List<String>> graph = new HashMap<>();
    final private List<List<String>> transformationSequences = new ArrayList<>();
    private int shortestTransformationLength = Integer.MAX_VALUE;
    private String startWord;
    private String finishWord;

    public List<List<String>> findLadders(
        final String beginWord,
        final String endWord,
        final List<String> wordList
    ) {
        this.startWord = beginWord;
        this.finishWord = endWord;

        createGraph(wordList);
        populateTransformationSequences(beginWord, new LinkedHashSet<>());
        return getShortestTransformationSequence();
    }

    private List<List<String>> getShortestTransformationSequence() {
        final Set<List<String>> shortestTransformationSequences = new LinkedHashSet<>();
        for (List<String> transformationSequence: transformationSequences) {
            if (transformationSequence.size() == shortestTransformationLength) {
                shortestTransformationSequences.add(transformationSequence);
            }
        }
        return new ArrayList<>(shortestTransformationSequences);
    }

    private void populateTransformationSequences(final String sourceNode,
                                                 final Set<String> visitedSet
    ) {
        if (visitedSet.contains(finishWord) && visitedSet.contains(startWord)) {
            shortestTransformationLength = Math.min(shortestTransformationLength, visitedSet.size());
            transformationSequences.add(new ArrayList<>(visitedSet));
            return;
        }
        if (visitedSet.contains(sourceNode)) {
            return;
        }
        for (final String node : graph.get(sourceNode)) {
            visitedSet.add(sourceNode);
            populateTransformationSequences(node, visitedSet);
            visitedSet.remove(sourceNode);
        }
    }

    private void createGraph(final List<String> wordList) {
        for (String word: wordList) {
            createConnection(word, wordList);
        }
        if (!graph.containsKey(startWord)) {
            createConnection(startWord, wordList);
        }
    }

    private void createConnection(final String str1, final List<String> wordList) {
        graph.put(str1, new ArrayList<>());

        for (final String str2: wordList) {
            if (str1.equals(str2)) {
                continue;
            }
            if (transformationIsPossible(str1, str2)) {
                graph.get(str1).add(str2);
            }
        }
    }

    private boolean transformationIsPossible(final String str1, final String str2) {
        int transformationSteps = 1;
        for (int charIndex = 0; charIndex < str1.length(); charIndex++) {
            if (str1.charAt(charIndex) == str2.charAt(charIndex)) {
                continue;
            }
            if (transformationSteps == 2) {
                return false;
            }
            transformationSteps++;
        }
        return true;
    }

}
