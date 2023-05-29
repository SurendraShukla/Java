package me.surendra.data_structures;

import java.util.List;

class ListPerformance {

    static void createList(final List<Integer> arrayList, int n) {
        long startTime = System.nanoTime();
        for(int i=0; i<n; i++) {
            arrayList.add(i);
        }
        long endTime = System.nanoTime();
        System.out.println(endTime-startTime);
    }

}
