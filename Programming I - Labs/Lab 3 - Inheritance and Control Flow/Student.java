package MilnerJustin_lab8;
import MilnerJustin_lab7.Person;

/**
 * The `Student` class represents a student, inheriting from the `Person` class.
 * It contains information about the student's GPA and school.
 *
 * author C0535365
 * version 1.0
 * since 2023-06-14
 */
public class Student extends Person {
    private double gpa;
    String school;
    
    /**
     * Constructs a student object with the specified first name and last name.
     *
     * @param firstname the first name of the student
     * @param lastname  the last name of the student
     */
    public Student(String firstname, String lastname) {
        super(firstname, lastname);
    }
    
    /**
     * Constructs a student object with the specified first name, last name, GPA, and school.
     *
     * @param firstname the first name of the student
     * @param lastname  the last name of the student
     * @param gpa       the GPA of the student
     * @param school    the school the student attends
     */
    public Student(String firstname, String lastname, Double gpa, String school) {
        super(firstname, lastname);
        this.gpa = gpa;
        this.school = school;
    }
    
    /**
     * Returns a string indicating the subject the student is studying.
     *
     * @param subject the subject the student is studying
     * @return        the string indicating the subject being studied
     */
    public String study(String subject) {
        return String.format("Studying: " + subject);
    }
    
    /**
     * Prints the student's report card based on the provided grades.
     * The GPA is calculated as grades divided by 25.
     *
     * @param grades the total grades obtained by the student
     */
    public void printReportCard(double grades) {
        this.gpa = grades / 25;
        System.out.printf("%s has a GPA of %.2f at %s%n", super.ID, this.gpa, this.school);
    }
    
    /**
     * Updates the student's GPA based on the provided grades.
     * The GPA is calculated as grades divided by 25.
     *
     * @param grades the total grades obtained by the student
     */
    public void addGrades(double grades) {
        this.gpa = grades / 25;
    }
    
    /**
     * Overrides the base class method to provide a customized greeting to another person.
     *
     * @param person the person to greet
     * @return       a string containing the customized greeting
     */
    @Override
    public String sayHelloTo(Person person) {
        return String.format("Hello %s, my name is %s! I'm a student at %s and my GPA is %s!%n", person.firstName, super.firstName, this.school, this.gpa);
    }
}
