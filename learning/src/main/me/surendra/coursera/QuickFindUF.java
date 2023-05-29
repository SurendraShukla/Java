package me.surendra.coursera;

import java.util.Arrays;

public class QuickFindUF implements me.surendra.coursera.UF {

    private int[] id;

    public QuickFindUF(final int N) {
        id = new int[N];
        for(int i=0; i<N; i++) {
            id[i] = i;
        }
    }

    @Override
    public boolean connected(final int p, final int q) {
        return id[p] == id[q];
    }

    @Override
    public void union(final int p, final int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) id[i] = qid;
        }
    }

    @Override
    public int find(final int p) {
        return 0;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public String toString() {
        return "QuickFindUF{" +
            "id=" + Arrays.toString(id) +
            '}';
    }
}
