package me.surendra.leetcode.graph.dfs;


import me.surendra.leetcode.linked_list.LinkedList;

import java.util.Map;

/**
 * @<a href="https://leetcode.com/problems/reconstruct-itinerary/description/">Reconstruct Itinerary</a>
 */
public class ReconstructItinerary {
//
//    final LinkedList<String> result;
//    final Map<String, LinkedList<String>> graph;
//
//    public List<String> findItinerary(List<List<String>> tickets) {
//        graph = new HashMap<>();
//        for (List<String> ticket: tickets) {
//            String curAirport = ticket.get(0);
//            String nextAirport = ticket.get(1);
//            graph.putIfAbsent(curAirport, new LinkedList<>());
//            graph.get(curAirport).add(nextAirport);
//        }
//
//        for (LinkedList<String> airports: graph.values()) {
//            Collections.sort(airports);
//        }
//        result = new LinkedList<String>();
//        dfs("JFK");
//
//        return result;
//    }
//
//    void dfs(String curAirport) {
//        if (graph.containsKey(curAirport)) {
//            LinkedList<String> airports = graph.get(curAirport);
//            while(!airports.isEmpty()) {
//                String nextAirport = airports.pollFirst();
//                dfs(nextAirport);
//            }
//        }
//
//        result.offerFirst(curAirport);
//    }

}
