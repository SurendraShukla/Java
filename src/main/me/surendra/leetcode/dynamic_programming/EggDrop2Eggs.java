package me.surendra.leetcode.dynamic_programming;

/**
 * @see <a href="https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/">Egg Drop With 2 Eggs and N Floors</a>
 */
public class EggDrop2Eggs {

    /*
        Time complexity : O(log n)
        Space complexity: O(1)
     */
    public int twoEggDrop(int n) {
        int no = 1;
        while(n > 0) {
            n-=no;
            no++;
        }
        return no-1;
    }

}
