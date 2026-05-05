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

        public boolean compare(Quantity<T> other) {
            return (value * unit.getConversionFactor()) ==
                    (other.value * other.unit.getConversionFactor());
        }

        public double convertTo(T target) {
            double base = value * unit.getConversionFactor();
            return base / target.getConversionFactor();
        }

        public Quantity<T> add(Quantity<T> other, T target) {
            double total = (value * unit.getConversionFactor()) +
                    (other.value * other.unit.getConversionFactor());
            return new Quantity<>(total / target.getConversionFactor(), target);
        }

        // 🔥 UC12 — SUBTRACTION
        public Quantity<T> subtract(Quantity<T> other, T target) {
            double result = (value * unit.getConversionFactor()) -
                    (other.value * other.unit.getConversionFactor());

            return new Quantity<>(result / target.getConversionFactor(), target);
        }

        // 🔥 UC12 — DIVISION
        public double divide(Quantity<T> other) {
            double thisBase = value * unit.getConversionFactor();
            double otherBase = other.value * other.unit.getConversionFactor();

            return thisBase / otherBase;
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    public static void main(String[] args) {

        // 🔹 SUBTRACTION (Length)
        Quantity<LengthUnit> l1 = new Quantity<>(2, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(6, LengthUnit.INCH);

        Quantity<LengthUnit> lSub = l1.subtract(l2, LengthUnit.FEET);
        System.out.println("Length Subtraction: " + lSub);

        // 🔹 DIVISION (Length)
        double ratio = l1.divide(l2);
        System.out.println("Length Division: " + ratio);

        // 🔹 SUBTRACTION (Weight)
        Quantity<WeightUnit> w1 = new Quantity<>(2, WeightUnit.KG);
        Quantity<WeightUnit> w2 = new Quantity<>(500, WeightUnit.G);

        Quantity<WeightUnit> wSub = w1.subtract(w2, WeightUnit.KG);
        System.out.println("Weight Subtraction: " + wSub);

        // 🔹 DIVISION (Volume)
        Quantity<VolumeUnit> v1 = new Quantity<>(2, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(500, VolumeUnit.ML);

        double vDiv = v1.divide(v2);
        System.out.println("Volume Division: " + vDiv);
    }
}