package MilnerJustin_lab8;
import MilnerJustin_lab7.Person;

/**
 * The `Employee` class represents an employee, inheriting from the `Person` class.
 * It contains information about the employee's company, position, and mentee.
 * An employee can also provide a customized greeting to another person.
 *
 * author C0535365 Justin Milner
 * version 1.0
 * since 2023-06-14
 */
public class Employee extends Person {
    String company;
    String position;
    private Student mentee;
    
    /**
     * Constructs an employee object with the specified first name and last name.
     *
     * @param firstname the first name of the employee
     * @param lastname  the last name of the employee
     */
    public Employee(String firstname, String lastname) {
        super(firstname, lastname);
    }
    
    /**
     * Constructs an employee object with the specified first name, last name, company, and position.
     *
     * @param firstname the first name of the employee
     * @param lastname  the last name of the employee
     * @param company   the company the employee works for
     * @param position  the position of the employee in the company
     */
    public Employee(String firstname, String lastname, String company, String position) {
        super(firstname, lastname);
        this.company = company;
        this.position = position;
    }
    
    /**
     * Sets the mentee of the employee.
     *
     * @param mentee the student mentee of the employee
     */
    public void addMentee(Student mentee) {
        this.mentee = mentee;
    }
    
    /**
     * Starts mentoring the assigned mentee.
     */
    public void startMentoring() {
        System.out.printf("%s is mentoring %s%n", super.firstName, mentee.firstName);
    }
    
    /**
     * Overrides the base class method to provide a customized greeting to another person.
     *
     * @param person the person to greet
     * @return       a string containing the customized greeting
     */
    @Override
    public String sayHelloTo(Person person) {
        return String.format("Hello %s!%n", person.firstName);
    }
}

    