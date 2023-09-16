package MilnerJustin_lab7;

/**
 * A class for testing the functionality of the Point, Person, Car, and AcademicRecord classes.
 * 
 * author C0535365 Justin Milner
 */
public class TestingObjects {
    
    /**
     * The main method that executes the testing code.
     * 
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        
        // Testing Point
        Point p1 = new Point();
        Point p2 = new Point(2.5, 4.7);
        double distanceP1ToP2 = p1.distanceFrom(p2);
        String p1Str = p1.toString();
        
        if (distanceP1ToP2 == 5.32) {
            System.out.println("\u001B[32m" + "Expected 5.32  Passed");
        } else {
            System.out.println("\u001B[31m" + "Expected 5.32  Failed was " + distanceP1ToP2); 
        }
        if ("Point: [0.00, 0.00]".equals(p1Str)) {
            System.out.println("\u001B[32m" + "Expected Point: [0.00, 0.00]  Passed");
        } else {
            System.out.println("\u001B[31m" + "Expected Point: [0.00, 0.00]  Failed was " + p1Str); 
        }
        
        
        // Testing Person
        Person person1 = new Person("Don", "Hulio");
        Person person2 = new Person("Jake", "Ferris", "C0924234", 29);
        String greetingString = person1.sayHelloTo(person2);
        String personString1 = person1.toString();
        
        if ("Hello Jake, my name is Don!".trim().equals(greetingString.trim())) {
            System.out.println("\u001B[32m" + "Expected Hello Jake, my name is Don!  Passed");
        } else {
            System.out.println("\u001B[31m" + "Expected Hello Jake, my name is Don!  Failed was " + greetingString); 
        }
        if ("Person: Don Hulio null, null".equals(personString1)) {
            System.out.println("\u001B[32m" + "Expected Person: Don Hulio null, null  Passed");
        } else {
            System.out.println("\u001B[31m" + "Expected Person: Don Hulio null, null  Failed was " + personString1);
        }
         
        
        // Testing Car
        Car car1 = new Car("Ford", "Mustang", 2024);
        long car1Odometer = car1.drive(100);
        String carInfo = car1.toString();
        
        if (100 == car1Odometer) {
            System.out.println("\u001B[32m" + "Expected 100  Passed");
        } else {
            System.out.println("\u001B[31m" + "Expected 100  Failed was " + car1Odometer); 
        }
        if ("Car: 2024 Ford Mustang".equals(carInfo)) {
            System.out.println("\u001B[32m" + "Expected Car: 2024 Ford Mustang");
        } else {
            System.out.println("\u001B[31m" + "Expected Car: 2024 Ford Mustang  Failed was " + carInfo);
        }
        
        
        // Testing AcademicRecord
        AcademicRecord academicRecord1 = new AcademicRecord(person2);
        String academicString1 = academicRecord1.toString();
        if ("AcademicRecord: C0924234 undeclared F".trim().equals(academicString1.trim())) {
            System.out.println("\u001B[32m" + "Expected AcademicRecord: C0924234 undeclared F  Passed");
        } else {
            System.out.println("\u001B[31m" + "Expected AcademicRecord: C0924234 undeclared F  Failed was " + academicString1);
        }
    }
}