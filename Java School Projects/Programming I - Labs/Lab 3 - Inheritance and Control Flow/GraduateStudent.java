package MilnerJustin_lab8;
import MilnerJustin_lab7.Person;

/**
 * The `GraduateStudent` class represents an employee, inheriting from the `Person` class.
 * It contains information about the graduate students department, dissertation, supervisor, and class.
 *
 * author C0535365 Justin Milner
 * version 1.0
 * since 2023-06-14
 */
public class GraduateStudent extends Student {
        
    String department;
    private String dissertation;
    private Person supervisor;
    private String gradClass; 

     /**
     * Constructs a graduate student object with the specified first name and last name.
     *
     * @param firstname the first name of the graduate student
     * @param lastname  the last name of the graduate student
     */
    public GraduateStudent(String firstname, String lastname) {
        super(firstname, lastname);
    }

    /**
     * Constructs a graduate student object with the specified first name, last name, department,
     * dissertation, and supervisor.
     *
     * @param firstname    the first name of the graduate student
     * @param lastname     the last name of the graduate student
     * @param department   the department of the graduate student
     * @param dissertation the dissertation topic of the graduate student
     * @param supervisor   the supervisor of the graduate student
     */
    public GraduateStudent(String firstname, String lastname, String department, String dissertation, Person supervisor) {
        super(firstname, lastname);
        this.department = department;
        this.dissertation = dissertation;
        this.supervisor = supervisor;
    }

    /**
     * Adds a class to the graduate student's schedule.
     *
     * @param cls the class to be added
     */
    public void addClass(String cls) {
        this.gradClass = cls;
    }

    /**
     * Simulates the graduate student writing their final exam for the current graduate class.
     */
    public void writeFinalExam() {
        System.out.printf("%s is writing the %s Final Exam%n", super.firstName, this.gradClass);
    }

    /**
     * Overrides the `addGrades` method to print the graduate student's grade percentage.
     *
     * @param grades the grade percentage of the graduate student
     */
    @Override
    public void addGrades(double grades) {
        System.out.printf("%s's grade is %s%%%n", super.firstName, grades);
    }

}
    
