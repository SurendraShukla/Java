package me.surendra.leetcode.graph;

import org.apache.commons.lang.math.RandomUtils;

/**
 * @see <a href="https://leetcode.com/problems/find-the-celebrity/">Find the Celebrity</a>
 */
public class CelebrityFinder {

//    [[1,0],[0,1]]

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public int findCelebrity(int n) {
        final int[] persons = new int[n];
        int person1 = 0;
        int person2 = n-1;
        while(person1 < person2) {
            boolean knows = knows(person1, person2);
            System.out.println("person1=["+ person1 + "] know person1=[" + person2 + "] [" + knows + "]");
            if (knows) {
                System.out.println("Person1 knows person2");
                persons[person1] = 1;
                person1++;
            }else{
                System.out.println("Person1 does not know person2");
                persons[person1] = 1;
                person2--;
            }
        }
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] == 0) {
                if (!celebrityKnows(persons, i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean celebrityKnows(final int[] persons, final int i) {

        for (int j = 0; j < persons.length; j++) {
            System.out.println("i=["+ i + "] j=[" + j + "]");
            if (i == j) {
                continue;
            }
            boolean knows = knows(i, j);
            System.out.println("i=["+ i + "] know j=[" + j + "] [" + knows + "]");
            if(knows) {
                return true;
            }
        }
        return false;
    }

    private boolean knows(final int person1, final int person2) {
        return RandomUtils.nextBoolean();
    }


}
