public class Quantity {

    double value;
    LengthUnit unit;

    public Quantity(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public boolean compare(Quantity other) {

        double thisInInches = this.value * this.unit.getConversionFactor();
        double otherInInches = other.value * other.unit.getConversionFactor();

        return thisInInches == otherInInches;
    }
}