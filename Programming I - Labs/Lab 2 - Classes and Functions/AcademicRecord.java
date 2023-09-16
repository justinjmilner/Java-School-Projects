package MilnerJustin_lab7;

/**
 * Represents an academic record of a student, including their personal information, major, year, and grades.
 * Instances of this class are immutable.
 * 
 * @author C0535365 Justin Milner
 */
public class AcademicRecord {
    /**
     * The student associated with the academic record.
     */
    public final Person student;
    
    /**
     * The major of the student.
     */
    public final String major;
    
    /**
     * The year of the student.
     */
    public final short year;
    
    /**
     * The grades of the student.
     */
    public final double[] grades;
    
    /**
     * Constructs an academic record for the specified student.
     * The major is set to "undeclared", the year to 1, and the grades to an empty array.
     * 
     * @param student the student associated with the academic record
     */
    public AcademicRecord(Person student) {
        this.student = student;
        this.major = "undeclared";
        this.year = 1;
        this.grades = new double[10];
    }
   
    /**
     * Calculates the average grade from the student's grades.
     * 
     * @return the average grade rounded to the nearest long
     */
    private long calculateAverage() {
        long totalGrades = 0;
        for (int i = 0; i < this.grades.length; i++) {
            totalGrades += this.grades[i];
        }
        return Math.round(totalGrades / this.grades.length);
    }
   
    /**
     * Calculates the letter grade based on the average grade.
     * 
     * @return the letter grade based on the average grade
     */
    private String calculateLetterGrade() {
        long grade = calculateAverage();
        if (grade >= 90) {
            return "A";
        } else if (grade >= 85) {
            return "B+";
        } else if (grade >= 80) {
            return "B";
        } else if (grade >= 75) {
            return "C+";
        } else if (grade >= 70) {
            return "C";
        } else if (grade >= 65) {
            return "D+";
        } else if (grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
   
    /**
     * Returns a string representation of the academic record.
     * 
     * @return a string representation of the academic record in the format "AcademicRecord: [student.ID] [major] [letterGrade]"
     */
    @Override
    public String toString() {
        return String.format("AcademicRecord: %s %s %s%n", this.student.ID, this.major, calculateLetterGrade());
    }
}
