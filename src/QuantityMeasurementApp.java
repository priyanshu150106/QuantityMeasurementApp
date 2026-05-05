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

    // 🔹 Volume Units (NEW - UC11)
    enum VolumeUnit implements Unit {
        LITRE(1.0),
        ML(0.001),
        GALLON(3.78541);

        private final double factor;

        VolumeUnit(double factor) {
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

        // 🔸 LENGTH
        Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12, LengthUnit.INCH);
        System.out.println("Length Equal? " + l1.compare(l2));

        // 🔸 WEIGHT
        Quantity<WeightUnit> w1 = new Quantity<>(1, WeightUnit.KG);
        Quantity<WeightUnit> w2 = new Quantity<>(1000, WeightUnit.G);
        System.out.println("Weight Equal? " + w1.compare(w2));

        // 🔸 VOLUME (UC11)
        Quantity<VolumeUnit> v1 = new Quantity<>(1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000, VolumeUnit.ML);

        System.out.println("Volume Equal? " + v1.compare(v2));

        double gallons = v1.convertTo(VolumeUnit.GALLON);
        System.out.println("1 Litre in Gallons: " + gallons);

        Quantity<VolumeUnit> vResult = v1.add(v2, VolumeUnit.LITRE);
        System.out.println("Volume Add: " + vResult);
    }
}