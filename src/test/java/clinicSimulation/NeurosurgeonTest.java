package clinicSimulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class NeurosurgeonTest {
    private Neurosurgeon neurosurgeon;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        neurosurgeon = new Neurosurgeon();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testNeurosurgeonTreat() {
        neurosurgeon.treat();
        Assertions.assertEquals("Neurosurgeon performs an operation\n", outContent.toString());
    }

    @Test
    void testNeurosurgeonConsult() {
        neurosurgeon.consult();
        Assertions.assertEquals("Neurosurgeon performs an consultation\n", outContent.toString());
    }
}
