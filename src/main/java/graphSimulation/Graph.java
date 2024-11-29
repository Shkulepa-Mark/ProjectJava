package graphSimulation;

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
        for (int i = 1; i < vertices; i++) {
            System.out.print("Vertex " + i + ":");
            for (Integer edge : adjacencyList.get(i)) {
                System.out.print(" -> " + edge);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7);

        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(4, 3);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);

        graph.printGraph();

        System.out.println("Graph after removing edge (1, 4)");
        graph.removeEdge(1, 4);

        graph.printGraph();
    }
}
