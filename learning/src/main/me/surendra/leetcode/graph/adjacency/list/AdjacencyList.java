package me.surendra.leetcode.graph.adjacency.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AdjacencyList {

    // No of vertices
    int noOfVertices;
    // Adjacency list for storing which vertices are connected
    ArrayList<ArrayList<Integer>> adjacencyList;

    public AdjacencyList(final int noOfVertices) {
        this.noOfVertices = noOfVertices;
        this.adjacencyList= new ArrayList<>(noOfVertices);

        for (int i = 0; i < noOfVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(final Integer vertex1, final Integer vertex2) {
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
    }


    public void addEdges(final int[][] edges) {
        for (final int[] edge : edges) {
            addEdge(edge[0], edge[1]);
        }
    }

    /*
        Time Complexity : O(V + E)
        Auxiliary Space: O(V)
     */
    public List<Integer> findTheShortestPath(final int sourceVertex, final int destinationVertex) {
        final int[] vertexParent = new int[noOfVertices];
        final int[] vertexDistance = new int[noOfVertices];
        final boolean[] vertexVisited = new boolean[noOfVertices];

        for (int i = 0; i < noOfVertices; i++) {
            vertexVisited[i] = false;
            vertexParent[i] = -1;
            vertexDistance[i] = Integer.MAX_VALUE;
        }

        if(!findShortestPathUsingBFS(sourceVertex, destinationVertex, vertexParent, vertexDistance, vertexVisited)) {
            System.out.println("Given sourceVertex and destinationVertex are not connected");
            return new ArrayList<>();
        }


        final List<Integer> path = new ArrayList<>();
        int vertex = destinationVertex;
        path.add(vertex);
        while(vertexParent[vertex] != -1) {
            path.add(vertexParent[vertex]);
            vertex = vertexParent[vertex];
        }

        // Print distance
        System.out.println(" ");
        System.out.println("Shortest path length is: " + vertexDistance[destinationVertex]);

        // Print path
        System.out.print("Path is: ");
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println(" ");

        return path;
    }

    private boolean findShortestPathUsingBFS(final int source, final int destination, final int[] vertexParent, final int[] vertexDistance, final boolean[] vertexVisited) {
        final Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        vertexVisited[source] = true;
        vertexDistance[source] = 0;

        while (!queue.isEmpty()) {
            final Integer parentVertex = queue.remove();
            final List<Integer> adjacentVertexes = adjacencyList.get(parentVertex);
            for (int j = 0; j < adjacentVertexes.size(); j++) {
                final Integer vertex = adjacentVertexes.get(j);
                if (vertexVisited[vertex] == false) {
                    vertexVisited[vertex] = true;
                    vertexParent[vertex] = parentVertex;
                    vertexDistance[vertex] = vertexDistance[parentVertex] + 1;
                    queue.add(vertex);

                    if (vertex == destination) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
