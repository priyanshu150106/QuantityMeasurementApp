public enum WeightUnit {

    KG(1.0),        // base unit
    G(0.001),       // 1 g = 0.001 kg
    LB(0.453592);   // 1 lb = 0.453592 kg

    private final double factor;

    WeightUnit(double factor) {
        this.factor = factor;
    }

    public double getFactor() {
        return factor;
    }
}