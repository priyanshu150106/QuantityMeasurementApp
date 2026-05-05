public class QuantityMeasurementApp {

    // 🔹 Unit Interface
    interface Unit {
        double getConversionFactor();
    }

    // 🔹 Length Units
    enum LengthUnit implements Unit {
        FEET(12.0),
        INCH(1.0),
        YARD(36.0),
        CM(0.393701);

        private final double factor;

        LengthUnit(double factor) {
            this.factor = factor;
        }

        public double getConversionFactor() {
            return factor;
        }
    }

    // 🔹 Weight Units
    enum WeightUnit implements Unit {
        KG(1.0),
        G(0.001),
        LB(0.453592);

        private final double factor;

        WeightUnit(double factor) {
            this.factor = factor;
        }

        public double getConversionFactor() {
            return factor;
        }
    }

    // 🔹 Generic Quantity Class
    static class Quantity<T extends Unit> {

        private double value;
        private T unit;

        public Quantity(double value, T unit) {
            this.value = value;
            this.unit = unit;
        }

        // ✅ Equality
        public boolean compare(Quantity<T> other) {
            double thisBase = this.value * this.unit.getConversionFactor();
            double otherBase = other.value * other.unit.getConversionFactor();
            return thisBase == otherBase;
        }

        // ✅ Conversion
        public double convertTo(T targetUnit) {
            double base = this.value * this.unit.getConversionFactor();
            return base / targetUnit.getConversionFactor();
        }

        // ✅ Addition
        public Quantity<T> add(Quantity<T> other, T targetUnit) {
            double thisBase = this.value * this.unit.getConversionFactor();
            double otherBase = other.value * other.unit.getConversionFactor();

            double total = thisBase + otherBase;
            double result = total / targetUnit.getConversionFactor();

            return new Quantity<>(result, targetUnit);
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    // 🔹 Main Method
    public static void main(String[] args) {

        // ✅ LENGTH TEST
        Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12, LengthUnit.INCH);

        System.out.println("Length Equal? " + l1.compare(l2));

        double cm = l1.convertTo(LengthUnit.CM);
        System.out.println("1 Foot in CM: " + cm);

        Quantity<LengthUnit> lResult = l1.add(l2, LengthUnit.FEET);
        System.out.println("Length Add: " + lResult);


        // ✅ WEIGHT TEST
        Quantity<WeightUnit> w1 = new Quantity<>(1, WeightUnit.KG);
        Quantity<WeightUnit> w2 = new Quantity<>(1000, WeightUnit.G);

        System.out.println("Weight Equal? " + w1.compare(w2));

        double pounds = w1.convertTo(WeightUnit.LB);
        System.out.println("1 KG in LB: " + pounds);

        Quantity<WeightUnit> wResult = w1.add(w2, WeightUnit.KG);
        System.out.println("Weight Add: " + wResult);
    }
}