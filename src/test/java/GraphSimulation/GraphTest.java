package graphSimulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GraphTest {
    private Graph graph;

    @BeforeEach
    void setUp() {
        graph = new Graph(7);
    }

    @Test
    void testGraphAddEdge() {
        graph.addEdge(1,2);
        graph.addEdge(1,4);

        Assertions.assertTrue(graph.getAdjacencyList().get(1).contains(2));
        Assertions.assertTrue(graph.getAdjacencyList().get(1).contains(4));
        Assertions.assertTrue(graph.getAdjacencyList().get(2).contains(1));
        Assertions.assertTrue(graph.getAdjacencyList().get(4).contains(1));
    }

    @Test
    void testGraphRemoveEdge() {
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.removeEdge(1, 2);

        Assertions.assertFalse(graph.getAdjacencyList().get(1).contains(2));
        Assertions.assertFalse(graph.getAdjacencyList().get(2).contains(1));

        Assertions.assertTrue(graph.getAdjacencyList().get(4).contains(1));
        Assertions.assertTrue(graph.getAdjacencyList().get(1).contains(4));
    }

    @Test
    void testPrintGraph() {
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        graph.printGraph();

        String expectedOutput = "Vertex 1: -> 2 -> 4\n" +
                "Vertex 2: -> 1 -> 3\n" +
                "Vertex 3: -> 2\n" +
                "Vertex 4: -> 1\n" +
                "Vertex 5:\n" +
                "Vertex 6:\n";

        String actualOutput = outputStream.toString().replace("\r\n", "\n");
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

}
