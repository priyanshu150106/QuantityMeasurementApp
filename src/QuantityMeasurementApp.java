public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity first = new Quantity(3, LengthUnit.FEET);
        Quantity second = new Quantity(1, LengthUnit.YARD);

        boolean isEqual = first.compare(second);

        System.out.println("Are both measurements equal? " + isEqual);
    }
}