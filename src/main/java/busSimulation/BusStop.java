package busSimulation;

import java.util.concurrent.Semaphore;

public class BusStop {
    private final String name;
    final Semaphore semaphore;

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

