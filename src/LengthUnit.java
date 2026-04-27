public enum LengthUnit {

    FEET(12.0),
    INCH(1.0),
    YARD(36.0),
    CM(0.393701);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }
}