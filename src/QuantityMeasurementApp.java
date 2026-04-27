public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity first = new Quantity(1, Unit.FEET);
        Quantity second = new Quantity(2, Unit.INCH);

        Quantity result = first.add(second, Unit.INCH);

        System.out.println("Result: " + result.value + " " + result.unit);
    }
}