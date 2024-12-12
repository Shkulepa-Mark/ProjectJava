package clinicSimulation;

public class Surgeon implements Treatable {
    @Override
    public void treat() {
        System.out.print("Surgeon performs an operation\n");
    }

    @Override
    public void consult() {
        System.out.print("Surgeon performs an consultation\n");
    }
}
