public class QuantityWeight {

    private double value;
    private WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    // ✅ Equality
    public boolean compare(QuantityWeight other) {

        double thisInKg = this.value * this.unit.getFactor();
        double otherInKg = other.value * other.unit.getFactor();

        return thisInKg == otherInKg;
    }

    // ✅ Conversion
    public double convertTo(WeightUnit targetUnit) {

        double valueInKg = this.value * this.unit.getFactor();

        return valueInKg / targetUnit.getFactor();
    }

    // ✅ Addition
    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {

        double thisInKg = this.value * this.unit.getFactor();
        double otherInKg = other.value * other.unit.getFactor();

        double totalInKg = thisInKg + otherInKg;

        double result = totalInKg / targetUnit.getFactor();

        return new QuantityWeight(result, targetUnit);
    }
}
