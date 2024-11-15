package GL6_VAR_7A;

public class Surgeon implements Doctor {
    @Override
    public void treat() {
        System.out.println("Surgeon performs an operation");
    }

    @Override
    public void consult() {
        System.out.println("Surgeon performs an consultation");
    }
}
