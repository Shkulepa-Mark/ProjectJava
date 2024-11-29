package busSimulation;

import java.util.concurrent.Semaphore;

public class BusStop {
    private final String name;
    private final Semaphore semaphore;

    public BusStop(String name, int capacity) {
        this.name = name;
        this.semaphore = new Semaphore(capacity, true);
    }

    public boolean arrive(String busName) {
        try {
            if (semaphore.tryAcquire()) {
                System.out.println(busName + " stop on " + name);
                Thread.sleep(1000);
                return true;
            } else {
                System.out.println(busName + " couldn't stop on " + name + ": no places.");
                return false;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(busName + " interrupted by " + name);
            return false;
        }
    }

    public void leave(String busName) {
        System.out.println(busName + " leaves " + name);
        semaphore.release();
    }
}

class Bus extends Thread {
    private final String busName;
    private final BusStop[] route;


    Bus(String busName, BusStop[] route) {
        this.busName = busName;
        this.route = route;
    }

    @Override
    public void run() {
        for (BusStop stop : route) {
            if (stop.arrive(busName)) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    stop.leave(busName);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(busName + " finished the route");
    }
}
