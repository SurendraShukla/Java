package me.surendra.coursera;

public interface UF {
    // Are p and q in the same component?
    boolean connected(int p, int q);

    // Add connection between p and q
    void union(int p, int q);

    // Component identifier for p (0 to N – 1)
    int find(int p);

    // Number of components
    int count();
}
