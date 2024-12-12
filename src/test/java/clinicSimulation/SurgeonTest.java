package clinicSimulation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SurgeonTest {
    private Surgeon surgeon;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        surgeon = new Surgeon();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testSurgeonTreat() {
        surgeon.treat();
        Assertions.assertEquals("Surgeon performs an operation\n", outContent.toString());
    }

    @Test
    void testSurgeonConsult() {
        surgeon.consult();
        Assertions.assertEquals("Surgeon performs an consultation\n", outContent.toString());
    }
}
