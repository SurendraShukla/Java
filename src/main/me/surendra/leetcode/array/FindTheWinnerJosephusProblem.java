package me.surendra.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/find-the-winner-of-the-circular-game/">Find the Winner of the Circular Game</a>
 */
public class FindTheWinnerJosephusProblem {

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public int findTheWinnerUsingList(int n, int k) {
        final List<Integer> friendList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            friendList.add(i+1);
        }
        k--;
        int index = 0;
        while(friendList.size() > 1) {
            index = (index + k) % friendList.size();
            friendList.remove(index);
        }
        return friendList.get(0);
    }

    /*
        Time Complexity - O(n*n)
        Space Complexity - O(n)
     */
    public int findTheWinnerUsingPrimitiveArray(int n, int k) {
        final int[] friends = getFriendsInCircle(n);

        int loopTerminator = n;
        int idx = k-1;
        while(loopTerminator > 1) {
            friends[idx] = -1;
            idx = getFriendIndexInTheGame(n, k, friends, idx);
            loopTerminator--;
        }

        return getWinnerFriend(n, friends);
    }

    private int getFriendIndexInTheGame(final int n, final int k, final int[] friends, int idx) {
        int tmpK = 1;
        while(tmpK <= k) {
            idx = (idx + 1) % n;
            while (friends[idx] == -1) {
                idx = (idx + 1) % n;
            }
            tmpK++;
        }
        return idx;
    }

    private int[] getFriendsInCircle(final int n) {
        final int[] friends = new int[n];
        for (int i = 0; i< n; i++) {
            friends[i] = i;
        }
        return friends;
    }

    private int getWinnerFriend(final int n, final int[] friends) {
        int winnerFriend = 0;
        for(int j = 0; j< n; j++) {
            if (friends[j] != -1) {
                winnerFriend = friends[j]+1;
                break;
            }
        }
        return winnerFriend;
    }

}
