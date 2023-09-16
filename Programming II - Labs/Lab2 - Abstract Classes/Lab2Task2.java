/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Lab2;

/**
 *
 * Author: juice
 */
public class Lab2Task2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create some Rational instances for testing
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(3, 4);
        Rational r3 = new Rational(2, 3);

        // Test arithmetic operations
        Rational sum = r1.add(r2);
        Rational difference = r2.subtract(r1);
        Rational product = r1.multiply(r2);
        Rational quotient = r1.divide(r2);

        System.out.println("Sum: " + sum);             // Output: 5/4
        System.out.println("Difference: " + difference); // Output: 1/4
        System.out.println("Product: " + product);       // Output: 3/8
        System.out.println("Quotient: " + quotient);     // Output: 2/3

        // Test other methods
        System.out.println("Absolute value of r3: " + r3.abs()); // Output: 2/3
        System.out.println("Is r1 a proper fraction? " + r1.isProper()); // Output: true
        System.out.println("Is r2 a repeating decimal? " + r2.isRepeatingDecimal()); // Output: false

        // Test value conversions
        double doubleValue = r1.doubleValue();
        float floatValue = r1.floatValue();
        int intValue = r1.intValue();
        long longValue = r1.longValue();

        System.out.println("Double value: " + doubleValue);   // Output: 0.5
        System.out.println("Float value: " + floatValue);     // Output: 0.5
        System.out.println("Int value: " + intValue);         // Output: 0
        System.out.println("Long value: " + longValue);       // Output: 0

        // Test comparison
        int comparison = r1.compareTo(r2);
        System.out.println("Comparison of r1 and r2: " + comparison); // Output: -1

        // Test equality
        boolean equal = r1.equals(r2);
        System.out.println("Are r1 and r2 equal? " + equal); // Output: false
        
        System.out.println(r1.toString());
    }
}
