package GL6_VAR_7A;

public class Neurosurgeon implements Doctor{
    @Override
    public void treat() {
        System.out.println("Neurosurgeon performs an operation");
    }

    @Override
    public void consult() {
        System.out.println("Neurosurgeon performs an consultation");
    }
}
