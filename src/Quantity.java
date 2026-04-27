public class Quantity {

    double value;

    public Quantity(double value) {
        this.value = value;
    }

    public boolean compare(Quantity other) {
        return this.value == other.value;
    }
}
