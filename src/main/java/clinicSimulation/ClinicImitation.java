package clinicSimulation;

import java.util.ArrayList;
import java.util.List;

public class ClinicImitation {
    public static void main(String[] args) {
        Doctor surgeon = new Surgeon();
        Doctor neurosurgeon = new Neurosurgeon();

        List<Doctor> doctors = new ArrayList<>();
        doctors.add(surgeon);
        doctors.add(neurosurgeon);

        for (Doctor doctor : doctors) {
            doctor.treat();
            doctor.consult();
        }
    }
}
