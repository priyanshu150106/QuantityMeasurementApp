public class QuantityMeasurementApp {

    public static void main(String[] args) {

        double value1 = 5.0;
        double value2 = 5.0;

        boolean isEqual = compareFeet(value1, value2);

        System.out.println("Are both measurements equal? " + isEqual);
    }

    public static boolean compareFeet(double value1, double value2) {
        return value1 == value2;
    }
}