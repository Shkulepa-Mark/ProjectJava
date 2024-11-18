package GL10_VAR_4B;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int vertices;
    private final List<List<Integer>> adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        if (source < vertices && destination < vertices) {
            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source);
        }
    }

    public void removeEdge(int source, int destination) {
        if (source < vertices && destination < vertices) {
            adjacencyList.get(source).remove(Integer.valueOf(destination));
            adjacencyList.get(destination).remove(Integer.valueOf(source));
        }
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ":");
            for (Integer edge : adjacencyList.get(i)) {
                System.out.print(" -> " + edge);
            }
        }
        System.out.println();
    }
}
