package me.surendra.leetcode.graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @see <a href="https://leetcode.com/problems/satisfiability-of-equality-equations/">Satisfiability of Equality Equations</a>
 */
public class EqualityEquationsSatisfiabilityFinder {

    public boolean equationsPossible(final String[] equations) {
        final Map<Character, List<Character>> connectedNodesMap = new HashMap<>();
        final List<char[]> disConnectedNodesList = new ArrayList<>();

        for (String equation: equations) {
            final char leftChar = equation.charAt(0);
            final char rightChar = equation.charAt(3);
            if (equation.contains("==")) {
                if (connectedNodesMap.containsKey(leftChar)) {
                    connectedNodesMap.get(leftChar).add(rightChar);
                } else {
                    final List<Character> charList = new ArrayList<>();
                    connectedNodesMap.put(leftChar, charList);
                }
            } else {
                final char[] chars = {leftChar, rightChar};
                disConnectedNodesList.add(chars);
            }
        }

        final List<List<Character>> union = new ArrayList<>();
//        populate();

        return false;
    }

    public String pushDominoes(String dominoes) {
        int strLen = dominoes.length();
        final int[] left = new int[strLen];
        final int[] right = new int[strLen];
        Arrays.fill(left, strLen);
        Arrays.fill(right, strLen);

        for (int leftIdx = strLen - 1; leftIdx >= 0; leftIdx--) {
            if (dominoes.charAt(leftIdx) == 'L') {
                left[leftIdx] = 0;
            } else {
                if (leftIdx != strLen - 1) {
                    if (left[leftIdx + 1] != strLen) {
                        left[leftIdx] = left[leftIdx + 1] + 1;
                    }
                }
            }
        }

        for (int rightIdx = 0; rightIdx < strLen; rightIdx++) {
            if (dominoes.charAt(rightIdx) == 'R') {
                right[rightIdx] = 0;
            } else {
                if (rightIdx != 0) {
                    if (right[rightIdx - 1] != strLen) {
                        right[rightIdx] = right[rightIdx - 1] + 1;
                    }
                }
            }
        }

        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strLen; i++) {
            if (left[i] >= strLen && right[i] >= strLen) {
                stringBuilder.append('.');
            } else if (left[i] == right[i]) {
                stringBuilder.append('.');
            } else if (left[i] < right[i]) {
                stringBuilder.append('L');
            } else if (right[i] < left[i]) {
                stringBuilder.append('R');
            }
        }

        return stringBuilder.toString();
    }

    public List<Integer> findClosestElements(final int[] arr, final int k, final int x) {
        final PriorityQueue<int[]> q = new PriorityQueue<int[]>((a1, a2) -> {
            if (a1[0] == a2[0]) {
                return a2[1] - a1[1];
            }
            return a2[0] - a1[0];
        });
        for (int i = 0; i < arr.length; i++) {
            final int[] nums = {Math.abs(arr[i] - x), arr[i]};
            q.add(nums);
            if (q.size() > k) {
                q.remove();
            }
        }
        // System.out.println(q.size());
        if (q.size() > k) {
            q.remove();
        }

        final List<Integer> returnList = new ArrayList<>();
        while (!q.isEmpty()) {
            final int[] smallValues = q.remove();
            returnList.add(smallValues[1]);
        }
        Collections.sort(returnList);
        // System.out.println(returnList.size());
        return returnList;
    }

    public static void main(final String[] args) {
        TreeSet<Employee> treeSet = new TreeSet<>(Comparator.comparingInt(Employee::getAge));

//        final String s = new EqualityEquationsSatisfiabilityFinder().pushDominoes(".L.R...LR..L..");
//        System.out.println(s);
        final int[] arr = {1,2,3,4,5};
        final List<Integer> closestElements = new EqualityEquationsSatisfiabilityFinder().findClosestElements(arr, 4, 3);
        System.out.println(closestElements);
    }


    class Employee {
        int age = 0;
        String name = "";

        Employee(final int age, final String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(final int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }
    }

}

