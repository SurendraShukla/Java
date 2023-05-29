package me.surendra.leetcode.graph;

/**
 * @see <a href="https://leetcode.com/problems/find-the-town-judge/">Find the Town Judge</a>
 */
public class TownJudgeFinder {

    /*
        Time Complexity - O(E)
                E is no. of edges (trust person) graph has. It will be mostly more than no. of node (person) in graph.
        Space Complexity - O(n)
     */
    public int findJudge(int n, int[][] trust) {
        // InDegree of a vertex (person) is the number of directed edges (no people of trusting him) going into it.
        final int[] trustCountsForAPerson = new int[n+1];
        // OutDegree of a vertex (person) is the number of directed edges (people whom he trusted) going out of it.
        final int[] noOfPeopleTrustedByAPerson = new int[n+1];

        for (final int[] peopleTrust : trust) {
            trustCountsForAPerson[peopleTrust[1]]++;
            noOfPeopleTrustedByAPerson[peopleTrust[0]]++;
        }

        for (int i = 1; i <= n; i++) {
            if ((n-1 == trustCountsForAPerson[i]) && (noOfPeopleTrustedByAPerson[i] == 0)) {
                return i;
            }
        }
        return -1;
    }

    /*
        Time Complexity - O(E), E is no. of edges (trust person) graph has. It will be mostly more than no. of node
        (person) in graph.
        Space Complexity - O(n)
     */
    public int findJudgeUsingOneArray(int n, int[][] trust) {
        final int[] trustScores = new int[n+1];

        for (final int[] peopleTrust : trust) {
            trustScores[peopleTrust[1]]++;
            trustScores[peopleTrust[0]]--;
        }

        final int trustCount = n - 1;
        for (int i = 1; i <= n; i++) {
            if ((trustScores[i] == trustCount)) {
                return i;
            }
        }
        return -1;
    }
}
