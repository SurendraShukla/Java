package me.surendra.leetcode.dynamic_programming;

/**
 * @see <a href="https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/">Egg Drop With 2 Eggs and N Floors</a>
 */
public class EggDropFinder {

    /*
        Time complexity : O(n)
        Space complexity: O(1)
     */
    public int twoEggDropFromFirstFloorOnwards(int n) {
        //Go to 1,3,6,10,.. n floors to see if first egg breaks
        int i=1;
        while(i<n) {
            n = n-i;
            i++;
        }

	    // Second egg will be droped from each floor starting from current floor to last floor,
        // (So the distance between last floor and current floor is the maximum no of times the eggs has to be dropped)
        return i;
    }

    /*
        Time complexity : O(n)
        Space complexity: O(1)
     */
    public int twoEggDropFromTopFloorDownwards(int n) {
        /*
           For Input 10 output would be 4.
           Start from Go to 10,9,7,4,0 floors to see if first egg breaks.
           10 - 0
           9  - 1
           7  - 2
           4  - 3
           0  - 4
           To understand more, see explanation of example 2nd for 100 floors.
         */
        int minimumNoOfMoves = 1;
        while(n > 0) {
            n-=minimumNoOfMoves;
            minimumNoOfMoves++;
        }
        return minimumNoOfMoves-1;
    }

}
