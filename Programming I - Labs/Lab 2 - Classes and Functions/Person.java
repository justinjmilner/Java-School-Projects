package MilnerJustin_lab7;

/**
 * Represents a person with basic information such as name, ID, and age.
 * Instances of this class are immutable.
 * 
 * @author C0535365 Justin Milner
 */
public class Person {
    /**
     * The ID of the person.
     */
    public final String ID;
    
    /**
     * The first name of the person.
     */
    public final String firstName;
    
    /**
     * The last name of the person.
     */
    public final String lastName;
    
    /**
     * The age of the person.
     */
    public final Integer age;
    
    /**
     * Constructs a person with the specified first name and last name.
     * The ID and age are set to null.
     * 
     * @param firstname the first name of the person
     * @param lastname the last name of the person
     */
    public Person(String firstname, String lastname) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.age = null;
        this.ID = null;
    }
    
    /**
     * Constructs a person with the specified first name, last name, ID, and age.
     * 
     * @param firstname the first name of the person
     * @param lastname the last name of the person
     * @param id the ID of the person
     * @param age the age of the person
     */
    public Person(String firstname, String lastname, String id, int age) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.ID = id;
        this.age = age;
    }
    
    /**
     * Generates a greeting message to another person by using their first name.
     * 
     * @param firstname the first name of the person to greet
     * @return a greeting message in the format "Hello [firstname], my name is [this.firstName]!"
     */
    private String sayHelloTo(String firstname) {
        return String.format("Hello %s, my name is %s!%n", firstname, this.firstName);
    }
    
    /**
     * Generates a greeting message to another person by using their first name.
     * 
     * @param person the person to greet
     * @return a greeting message in the format "Hello [person.firstName], my name is [this.firstName]!"
     */
    public String sayHelloTo(Person person) {
        return sayHelloTo(person.firstName);
    }
    
    /**
     * Returns a string representation of this person.
     * 
     * @return a string representation of this person in the format "Person: [firstName] [lastName] [ID], [age]"
     */
    @Override
    public String toString() {
        return String.format("Person: %s %s %s, %d", this.firstName, this.lastName, this.ID, this.age);
    }
}
