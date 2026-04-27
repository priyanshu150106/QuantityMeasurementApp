public class Quantity {

    double value;
    Unit unit;

    public Quantity(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public boolean compare(Quantity other) {

        double thisInInches = this.value * this.unit.getConversionFactor();
        double otherInInches = other.value * other.unit.getConversionFactor();

        return thisInInches == otherInInches;
    }

    public double convertTo(Unit targetUnit) {

        double valueInInches = this.value * this.unit.getConversionFactor();

        return valueInInches / targetUnit.getConversionFactor();
    }

    public Quantity add(Quantity other, Unit targetUnit) {

        double thisInInches = this.value * this.unit.getConversionFactor();
        double otherInInches = other.value * other.unit.getConversionFactor();

        double totalInInches = thisInInches + otherInInches;

        double resultValue = totalInInches / targetUnit.getConversionFactor();

        return new Quantity(resultValue, targetUnit);
    }
}