public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity first = new Quantity(1, LengthUnit.FEET);
        Quantity second = new Quantity(2, LengthUnit.INCH);

        Quantity result = first.add(second);

        System.out.println("Result: " + result.value + " " + result.unit);
    }
}