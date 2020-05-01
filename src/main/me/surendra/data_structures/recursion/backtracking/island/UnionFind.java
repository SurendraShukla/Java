package me.surendra.data_structures.recursion.backtracking.island;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UnionFind {
    final int[] no;

    public UnionFind(final int no) {
        this.no = new int[no];
        for(int i=0; i<no; i++) {
            this.no[i] = i;
        }
    }
    public void connect(final int point1, final int point2) {
        this.no[point2]  = this.no[point1];
    }
//
//    public void connect(final int point1, final int point2) {
//        int newPoint  = this.no[point2];
//        int previousPoint = this.no[point1];
//        for(int i=0; i<point2; i++) {
//            if (this.no[i] == previousPoint) {
//                this.no[i] = newPoint;
//            }
//        }
//        this.no[point1] = newPoint;
//    }

    public int getMaxConnectedPointsCount() {
        return getAllPoints()
            .entrySet()
            .parallelStream()
            .map((m) -> m.getValue().size())
            .max(Integer::compare)
            .get()
        ;
    }

    public Map<Integer, Set<Integer>> getConnectedPointsOnly() {
        return getAllPoints()
            .entrySet()
            .parallelStream()
            .filter((m) -> m.getValue().size() > 1)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
            ;
    }

    private Map<Integer, Set<Integer>> getAllPoints() {
        final Map<Integer, Set<Integer>> returnMap = new HashMap<>();
        for(int i=0; i<getNo().length; i++) {
            int val = this.no[i];
            returnMap.putIfAbsent(val, new HashSet<>());
            returnMap.get(val).add(i);
        }
        return returnMap;
    }

    public int[] getNo() {
        return no;
    }

}
