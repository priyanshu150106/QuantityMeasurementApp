public class QuantityMeasurementApp {

    interface Unit {
        double getConversionFactor();
    }

    enum LengthUnit implements Unit {
        FEET(12.0), INCH(1.0), YARD(36.0), CM(0.393701);

        private final double factor;

        LengthUnit(double factor) { this.factor = factor; }

        public double getConversionFactor() { return factor; }
    }

    enum WeightUnit implements Unit {
        KG(1.0), G(0.001), LB(0.453592);

        private final double factor;

        WeightUnit(double factor) { this.factor = factor; }

        public double getConversionFactor() { return factor; }
    }

    enum VolumeUnit implements Unit {
        LITRE(1.0), ML(0.001), GALLON(3.78541);

        private final double factor;

        VolumeUnit(double factor) { this.factor = factor; }

        public double getConversionFactor() { return factor; }
    }

    static class Quantity<T extends Unit> {

        private double value;
        private T unit;

        public Quantity(double value, T unit) {
            this.value = value;
            this.unit = unit;
        }

        // 🔥 CENTRALIZED METHODS (UC13)

        private double toBase() {
            return value * unit.getConversionFactor();
        }

        private double fromBase(double baseValue, T targetUnit) {
            return baseValue / targetUnit.getConversionFactor();
        }

        private double operate(Quantity<T> other, String operation) {

            double thisBase = this.toBase();
            double otherBase = other.toBase();

            switch (operation) {
                case "ADD":
                    return thisBase + otherBase;
                case "SUB":
                    return thisBase - otherBase;
                case "DIV":
                    if (otherBase == 0)
                        throw new ArithmeticException("Divide by zero");
                    return thisBase / otherBase;
                default:
                    throw new IllegalArgumentException("Invalid operation");
            }
        }

        // ✅ Equality
        public boolean compare(Quantity<T> other) {
            return this.toBase() == other.toBase();
        }

        // ✅ Conversion
        public double convertTo(T target) {
            return fromBase(this.toBase(), target);
        }

        // ✅ Addition
        public Quantity<T> add(Quantity<T> other, T target) {
            double result = operate(other, "ADD");
            return new Quantity<>(fromBase(result, target), target);
        }

        // ✅ Subtraction
        public Quantity<T> subtract(Quantity<T> other, T target) {
            double result = operate(other, "SUB");
            return new Quantity<>(fromBase(result, target), target);
        }

        // ✅ Division
        public double divide(Quantity<T> other) {
            return operate(other, "DIV");
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    public static void main(String[] args) {

        Quantity<LengthUnit> l1 = new Quantity<>(2, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(6, LengthUnit.INCH);

        System.out.println("Add: " + l1.add(l2, LengthUnit.FEET));
        System.out.println("Sub: " + l1.subtract(l2, LengthUnit.FEET));
        System.out.println("Div: " + l1.divide(l2));

        Quantity<WeightUnit> w1 = new Quantity<>(2, WeightUnit.KG);
        Quantity<WeightUnit> w2 = new Quantity<>(500, WeightUnit.G);

        System.out.println("Weight Add: " + w1.add(w2, WeightUnit.KG));
    }
}