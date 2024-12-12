package busSimulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BusTest {
    @InjectMocks
    private Bus bus;

    @Mock
    private BusStop busStop;

    @Test
    void testBusArrive() {
        Mockito.when(busStop.arrive("Bus1")).thenReturn(true);

        BusStop[] route = {busStop};
        bus = new Bus("Bus1", route);

        Thread busThread = new Thread(bus);
        busThread.start();

        try {
            busThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Mockito.verify(busStop, Mockito.times(1)).arrive("Bus1");
    }

    @Test
    void testBusThrowsException() {
        Mockito.when(busStop.arrive(null)).thenThrow(new IllegalArgumentException("Bus name cannot be null"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> busStop.arrive(null));
    }

    @Test
    void testBusLeave() {
        Mockito.when(busStop.arrive("Bus1")).thenReturn(true);

        BusStop[] route = {busStop};
        bus = new Bus("Bus1", route);

        Thread busThread = new Thread(bus);
        busThread.start();

        try {
            busThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Mockito.verify(busStop, Mockito.times(1)).leave("Bus1");
    }
}
