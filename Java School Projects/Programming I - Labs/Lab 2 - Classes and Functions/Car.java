package MilnerJustin_lab7;

/**
 * Represents a car with its make, model, year, owner, and odometer reading.
 * Instances of this class are mutable.
 * 
 * @author C0535365 Justin Milner
 */
public class Car {
    /**
     * The make of the car.
     */
    public final String make;
    
    /**
     * The model of the car.
     */
    public final String model;
    
    /**
     * The year of the car.
     */
    public final int year;
    
    /**
     * The owner of the car.
     */
    public final Person owner;
    
    /**
     * The odometer reading of the car.
     */
    public long odometer;
    
    /**
     * Constructs a car with the specified make, model, and year.
     * The odometer is set to 0 and the owner to null.
     * 
     * @param make the make of the car
     * @param model the model of the car
     * @param year the year of the car
     */
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.odometer = 0;
        this.owner = null;
    }
    
    /**
     * Drives the car by updating the odometer reading and returns the updated reading.
     * 
     * @param odometer the distance driven in miles
     * @return the updated odometer reading
     */
    public long drive(long odometer) {
        System.out.println("Vroom! Vroom!");
        this.odometer += odometer;
        return this.odometer;
    }
    
    /**
     * Returns a string representation of the car.
     * 
     * @return a string representation of the car in the format "Car: [year] [make] [model]"
     */
    @Override
    public String toString() {
        return String.format("Car: %d %s %s", this.year, this.make, this.model);
    }
}