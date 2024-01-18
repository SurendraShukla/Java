package me.surendra.leetcode.graph.union_find;


import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/number-of-islands-ii/">Number of Islands II</a>
 */
public class NumberOfIslandsII {

    /*
        Time complexity : O(n * m) M is no. of rows & N is no. of cols
        Space complexity: O(n * m) M is no. of rows & N is no. of cols
     */
    public List<Integer> numIslands2(final int m, final int n, final int[][] positions) {
        int x[] = { -1, 1, 0, 0 };
        int y[] = { 0, 0, -1, 1 };
        final UnionFind dsu = new UnionFind(m * n);
        final List<Integer> answer = new ArrayList<>();

        for (int[] position : positions) {
            final int landPosition = position[0] * n + position[1];
            dsu.addLand(landPosition);

            for (int i = 0; i < 4; i++) {
                final int neighborX = position[0] + x[i];
                final int neighborY = position[1] + y[i];
                final int neighborPosition = neighborX * n + neighborY;
                if (neighborX >= 0 && neighborX < m && neighborY >= 0 && neighborY < n && dsu.isLand(neighborPosition)) {
                    dsu.union(landPosition, neighborPosition);
                }
            }
            answer.add(dsu.numberOfIslands());
        }
        return answer;
    }

    class UnionFind {
        int[] parent;
        int[] rank;
        int count;

        UnionFind(final int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++)
                parent[i] = -1;
            count = 0;
        }

        public void addLand(int x) {
            if (parent[x] > -1)
                return;
            parent[x] = x;
            count++;
        }

        public boolean isLand(int x) {
            if (parent[x] > -1) {
                return true;
            } else {
                return false;
            }
        }

        int numberOfIslands() {
            return count;
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(final int x, final int y) {
            final int xset = find(x);
            final int yset = find(y);
            if (xset == yset) {
                return;
            } else if (rank[xset] < rank[yset]) {
                parent[xset] = yset;
            } else if (rank[xset] > rank[yset]) {
                parent[yset] = xset;
            } else {
                parent[yset] = xset;
                rank[xset]++;
            }
            count--;
        }
    }


}
