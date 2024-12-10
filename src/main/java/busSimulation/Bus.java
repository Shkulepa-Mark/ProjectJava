package busSimulation;

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
