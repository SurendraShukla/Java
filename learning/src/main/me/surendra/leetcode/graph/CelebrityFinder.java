package me.surendra.leetcode.graph;

/**
 * @see <a href="https://leetcode.com/problems/find-the-celebrity/">Find the Celebrity</a>
 */
public class CelebrityFinder {

    final int[][] relations;

    public CelebrityFinder(final int[][] relations) {
        this.relations = relations;
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(1)
     */
    public int findCelebrity(int n) {
        int celebrityCandidate = 0;
        for (int otherCandidate=1; otherCandidate<n; otherCandidate++) {
            if (knows(celebrityCandidate, otherCandidate)) {
                celebrityCandidate = otherCandidate;
            }
        }
        return isCelebrity(celebrityCandidate, n) ? celebrityCandidate : -1;
    }

    private boolean isCelebrity(final int celebrityCandidate, final int n) {
        for (int otherCandidate = 0; otherCandidate < n; otherCandidate++) {
            if (otherCandidate == celebrityCandidate) {
                continue;
            }
            if (!knows(otherCandidate, celebrityCandidate) || knows(celebrityCandidate, otherCandidate)) {
                return false;
            }
        }
        return true;
    }

    /*
        Time Complexity - O(n^2)
        Space Complexity - O(n)
     */
    public int findCelebrityByConsideringFirstCelebrityAndThenFinding(int n) {
        final int[] celebrityStatus = new int[n];
        for (int person1=0; person1<n; person1++) {
            for (int person2=0; person2<n; person2++) {
                if (person1 == person2) {
                    continue;
                }
                if (knows(person1, person2)) {
                    celebrityStatus[person1] = 1;
                }
            }
        }

        for (int i=0; i<n; i++) {
            if ((celebrityStatus[i] == 0) && isCelebrity(i, n)) {
                return i;
            }
        }
        return -1;
    }

    /*
        Time Complexity - O(n^2)
        Space Complexity - O(n)
     */
    public int findCelebrityWithBothCount_OtherAndHeKnows(int n) {
        final int[] celebrityStatus = new int[n];
        final int[] celebrityKnowsOther = new int[n];
        for (int person1=0; person1<n; person1++) {
            for (int person2=0; person2<n; person2++) {
                if (person1 == person2) {
                    celebrityKnowsOther[person1]+=1;
                    continue;
                }
                if (knows(person1, person2)) {
                    celebrityKnowsOther[person2]+=1;
                    celebrityStatus[person1] = 1;
                }
            }
        }

        for (int i=0; i<n; i++) {
            if (celebrityKnowsOther[i] == n && celebrityStatus[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    private boolean knows(final int person1, final int person2) {
        return relations[person1][person2] == 1;
    }

}
