package me.surendra.leetcode.graph.union_find;


public class UnionFind {

    int[] parents;
    int[] rank;
    int group;

    public UnionFind(final int n) {
        group = n;
        rank = new int[n];
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public boolean union(final int node1, final int node2) {
        final int p1 = find(node1);
        final int p2 = find(node2);
        if (p1 == p2) {
            return false;
        }
        if (rank[p1] < rank[p2]) {
            parents[p1] = p2;
            rank[p2] += rank[p1];
        } else {
            parents[p2] = p1;
            rank[p1] += rank[p2];
        }
        group--;
        return true;
    }

    public int find(final int idx) {
        if (idx == parents[idx]) {
            return idx;
        }
        parents[idx] = find(parents[idx]);
        return parents[idx];
    }

    public int getCount() {
        return group;
    }

}
