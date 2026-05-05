public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // Equality check
        QuantityWeight w1 = new QuantityWeight(1, WeightUnit.KG);
        QuantityWeight w2 = new QuantityWeight(1000, WeightUnit.G);

        System.out.println("Equal? " + w1.compare(w2));

        // Conversion
        double pounds = w1.convertTo(WeightUnit.LB);
        System.out.println("1 KG in LB = " + pounds);

        // Addition
        QuantityWeight result = w1.add(w2, WeightUnit.KG);
        System.out.println("Total Weight = " + result);
    }
}