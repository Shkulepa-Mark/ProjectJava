package busSimulation;

import org.junit.Assert;
import org.junit.Test;

public class BusStopTest {
    @Test
    public void testBusStopArriveSuccess() {
        BusStop stop = new BusStop("Central", 1);
        boolean arrived = stop.arrive("Bus1");

        Assert.assertTrue("Bus should be able to stop when there is capacity", arrived);
        stop.leave("Bus1");
    }

    @Test
    public void testBusStopLeave() {
        BusStop stop = new BusStop("Central", 1);
        boolean arrived1 = stop.arrive("Bus1");

        Assert.assertTrue("Bus should be able to stop when there is capacity", arrived1);
        stop.leave("Bus1");

        boolean arrived2 = stop.arrive("Bus2");

        Assert.assertTrue("Bus2 should be able to stop after Bus1 leaves", arrived2);
        stop.leave("Bus2");
    }

    @Test
    public void testInterruptedExceptionInArrive() {
        BusStop stop = new BusStop("Central", 1);

        Thread.currentThread().interrupt();

        boolean result = stop.arrive("Bus1");

        Assert.assertFalse("Arrive should return false when interrupted", result);
        Assert.assertTrue("Thread should remain interrupted", Thread.currentThread().isInterrupted());
    }

    @Test
    public void testBusStopConcurrency() throws InterruptedException {
        BusStop stop = new BusStop("Central", 2);

        Runnable busTask = () -> {
            String busName = Thread.currentThread().getName();
            if (stop.arrive(busName)) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    stop.leave(busName);
                }
            }
        };

        Thread[] buses = {
                new Thread(busTask, "Bus1"),
                new Thread(busTask, "Bus2"),
                new Thread(busTask, "Bus3")
        };

        for (Thread bus : buses) {
            bus.start();
        }

        for (Thread bus : buses) {
            bus.join();
        }

        Assert.assertEquals("Semaphore should release all permits", 2, stop.semaphore.availablePermits());
    }
}
