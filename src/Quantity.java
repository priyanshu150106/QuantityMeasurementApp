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

    // 🔥 New Add Method with Target Unit
    public Quantity add(Quantity other, LengthUnit targetUnit) {

        double thisInInches = this.value * this.unit.getConversionFactor();
        double otherInInches = other.value * other.unit.getConversionFactor();

        double totalInInches = thisInInches + otherInInches;

        double resultValue = totalInInches / targetUnit.getConversionFactor();

        return new Quantity(resultValue, targetUnit);
    }
}