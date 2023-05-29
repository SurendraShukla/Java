package me.surendra.coursera;

import java.util.Arrays;

public class QuickUnionUF implements me.surendra.coursera.UF {

    private int[] id;

    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (i != id[i]) i = id[i];
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
        id[i] = j;
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
        return "QuickUnionUF{" +
                "id=" + Arrays.toString(id) +
                '}';
    }

//
//    public static void main(String[] args) {
//        int N = StdIn.readInt();    // Read number of sites
//        QuickUnionUF quickunion = new QuickUnionUF(N);
//        while (!StdIn.isEmpty()) {
//            int p = StdIn.readInt();
//            int q = StdIn.readInt();                     // Read pair to connect
//            if (quickunion.connected(p, q)) continue;     // Ignore if connected
//            quickunion.union(p, q);                       // Combine components
//            StdOut.println(p + " " + q);                 // and print connection
//        }
//        StdOut.println(quickunion.count() + " components");
//    }

}
