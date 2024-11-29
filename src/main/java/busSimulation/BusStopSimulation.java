package busSimulation;

public class BusStopSimulation {
    public static void main(String[] args) {
        BusStop stop1 = new BusStop("Stop 1", 1);
        BusStop stop2 = new BusStop("Stop 2", 2);
        BusStop stop3 = new BusStop("Stop 3", 3);

        BusStop[] route = {stop1, stop2, stop3};

        Bus bus1 = new Bus("Bus 1", route);
        Bus bus2 = new Bus("Bus 2", route);
        Bus bus3 = new Bus("Bus 3", route);
        Bus bus4 = new Bus("Bus 4", route);
        Bus bus5 = new Bus("Bus 5", route);

        bus1.start();
        bus2.start();
        bus3.start();
        bus4.start();
        bus5.start();
    }
}
