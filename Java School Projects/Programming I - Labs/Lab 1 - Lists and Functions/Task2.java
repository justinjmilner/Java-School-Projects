package lab5;

/**
 *
 * @author juice
 */
/**
 * A class representing students and their average grades.
 * 
 * The program stores a 2D list of students. Each list inside the list contains the students full name
 * The program stores a 2D list of grades. Each list inside the list contains the students grades
 * 
 * It contains a function that calculates the average grade for a student
 * 
 * It also contains a function that prints the students name with their average grade
 * 
 * It also includes a main method to control the flow of the program.
 * 
 * Author: Justin Milner
 */

public class Task2 {
    
    /*
    * This is a 2 dimensional array of first and last names, for each student in a class
    */
    public static final String[][] names = {
	{ "Ewell", "Nate" },
	{ "Smurthwaite", "Adelina" },
	{ "Bernollet", "Maryjane" },
	{ "Chalfain", "Karlis" },
	{ "Huckabe", "Almire" }
    };
    
    
    /*
    * This is a 2 dimensional array of grades for each student
    */
    public static final double[][] grades = {
            { 3.83, 9.21, 9.25, 0.84, 1.40, 7.90, 1.41, 5.15 },
            { 5.09, 3.66, 3.04, 3.02, 8.59, 2.34, 8.86, 7.40 },
            { 5.35, 0.85, 8.56, 7.37, 2.78, 3.19, 2.04, 5.70 },
            { 9.25, 9.62, 7.08, 7.27, 9.86, 5.88, 9.86, 9.70 },
            { 3.39, 2.75, 1.23, 1.04, 3.87, 8.72, 4.60, 6.21 }
    };
    
    
    /* 
    * This method controls the flow of the program
    *
    * It creates float classTotal for the class total grades, which will be used to calculate class average.
    * It also creates final float[] averages to hold each students average
    *
    * It calls calculate average with the students and grades array to get the get the 
    * average for each student and stores that average in averages and adds the average to classTotal.
    *
    * Then it calls calculate average with the averages array and student names. This will return the class average
    * which is stored in classAverage.
    *
    * It calls the print info function to print the student and grade average for each student.
    *
    * Finally it prints the class average.
    *
    * @param args the command line arguments
    */
    public static void main(String[] args) {
        float classTotal = 0;
        final float[] averages = new float[names.length];
        
        for (int i = 0; i < names.length; i++) {
            averages[i] = calculateAverage(i, grades);
            classTotal += averages[i];
        }
        String str = printInfo(names, averages);
        
        
        System.out.print(str);
        
        System.out.printf("%nClass average: %.2f", classTotal/names.length);
    }
    
    
    /*
    * This method takes and integer 'i' as the index for the student into the grade book
    * Then it calculates the average grade for the student and returns the floating point number
    *
    * @param student the students' index number in the grades array
    * @param grades a list of lists, each list is a number of grades for a student
    * @return the average grade for the student
    */
    public static float calculateAverage(int student, double[][] grades) {
        float totalGrade = 0;
        for (int k = 0; k < grades[student].length; k++) {
            totalGrade += grades[student][k];
        }
        return totalGrade / grades[student].length;
    }
    
    
    /*
    * This method prints the first and last name of a student and then each of that students grades
    *
    * @param names a list of students, each list inside the list contains the students full name
    * @param a list of the averages for each student
    */
    public static String printInfo (String[][] names, float[] averages) {
        
        String buff ="";
        for (int i = 0; i < names.length; i++) {
            for (int j = 1; j >= 0; j--) {
             buff+=  (names[i][j] + " ");
            }
           buff+= String.format("%.2f%n", averages[i]);
        }
        
        return buff;
    }
    
}
