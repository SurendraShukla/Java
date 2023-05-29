package me.surendra.coursera;

import java.util.Arrays;

public class WeightedQuickUnionWithPathCompression implements UF {

    private int[] id;
    private int[] sz;

    public WeightedQuickUnionWithPathCompression(int N) {
        id = new int[N];
        for(int i=0; i<N; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j; sz[j] += sz[i];
        } else {
            id[j] = i; sz[i] += sz[j];
        }
    }

    @Override
    public int find(int p) {
        return 0;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public String toString() {
        return "WeightedQuickUnion{" +
            "id=" + Arrays.toString(id) +
            '}';
    }
}
