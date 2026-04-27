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

    public double convertTo(LengthUnit targetUnit) {
        double valueInInches = this.value * this.unit.getConversionFactor();

        return valueInInches / targetUnit.getConversionFactor();
    }

    // 🔥 New Addition Method
    public Quantity add(Quantity other) {

        double thisInInches = this.value * this.unit.getConversionFactor();
        double otherInInches = other.value * other.unit.getConversionFactor();

        double totalInInches = thisInInches + otherInInches;

        double resultValue = totalInInches / this.unit.getConversionFactor();

        return new Quantity(resultValue, this.unit);
    }
}