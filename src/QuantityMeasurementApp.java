public class QuantityMeasurementApp {

    public static void main(String[] args) {

        double feet = 2.0;
        double inches = 24.0;

        boolean isEqual = compareFeetAndInches(feet, inches);

        System.out.println("Are both measurements equal? " + isEqual);
    }

    public static boolean compareFeetAndInches(double feet, double inches) {

        double convertedFeetToInches = feet * 12;

        return convertedFeetToInches == inches;
    }
}