public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity quantity = new Quantity(2, LengthUnit.FEET);

        double convertedValue = quantity.convertTo(LengthUnit.INCH);

        System.out.println("Converted Value: " + convertedValue);
    }
}