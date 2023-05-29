package me.surendra.coursera;

import org.junit.Test;

import java.util.Scanner;

public class QuickUnionUFTest {

    @Test
    public void scanner() {
        // Scanner in = new Scanner(new File("/some/path/to/file.txt"));
        Scanner in = new Scanner(System.in);  // replace as required!
        int n = in.nextInt();    // Read number of sites
        QuickUnionUF quickUnion = new QuickUnionUF(n);
        while (in.hasNextInt()) {
            int p = in.nextInt();
            int q = in.nextInt();                     // Read pair to connect
            if (quickUnion.connected(p, q)) continue; // Ignore if connected
            quickUnion.union(p, q);                   // Combine components
            System.out.println(p + " " + q);          // and print connection
        }
        //    System.out.println(quickUnion.count() + " components")
    }


    @Test
    public void stdLib() {
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
    }

}
