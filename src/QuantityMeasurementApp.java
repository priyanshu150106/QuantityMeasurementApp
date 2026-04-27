public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity firstValue = new Quantity(5.0);
        Quantity secondValue = new Quantity(5.0);

        boolean isEqual = firstValue.compare(secondValue);

        System.out.println("Are both quantities equal? " + isEqual);
    }
}