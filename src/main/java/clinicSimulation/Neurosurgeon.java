package clinicSimulation;

public class Neurosurgeon implements Doctor {
    @Override
    public void treat() {
        System.out.print("Neurosurgeon performs an operation\n");
    }

    @Override
    public void consult() {
        System.out.print("Neurosurgeon performs an consultation\n");
    }
}
