package me.surendra.leetcode.string;

import com.sun.tools.javac.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/find-and-replace-in-string/">Find And Replace in String</a>
 */
public class FindAndReplacer {

    /*
        Time Complexity - 0(n)
        Space Complexity - 0(n)
     */
    public String findReplaceString(String mainStr, int[] indexes, String[] sources, String[] targets) {
        final Map<Integer, Pair> searchDetailMap = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            searchDetailMap.put(indexes[i], new Pair(sources[i], targets[i]));
        }

        final StringBuilder stringBuilder = new StringBuilder();
        for(int j=0; j<mainStr.length();) {
            if (searchDetailMap.containsKey(j)) {
                final Pair pair = searchDetailMap.get(j);
                final String searchStr = (String) pair.fst;
                final String replaceStr = (String) pair.snd;
                if(mainStr.startsWith(searchStr, j)) {
                    stringBuilder.append(replaceStr);
                    j+=searchStr.length();
                }else{
                    stringBuilder.append(mainStr.charAt(j));
                    j++;
                }
            }else{
                stringBuilder.append(mainStr.charAt(j));
                j++;
            }
        }
        return stringBuilder.toString();
    }

}
