package Lab5;

import Lab1.Doctor;
import Lab1.Employee;
import Lab1.Patient;
import Lab2.Rational;
import Lab1.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 * This class demonstrates various operations on different types of data.
 * It includes methods to find smallest valued elements, sort lists, and perform custom sorting.
 * @author C0535365 Justin Milner
 */
public class Main {

    /**
     * The main method where different operations are demonstrated.
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        
        // Given a list of Rational objects, find the smallest valued element.
        List<Rational> rationalList = new ArrayList<>();
        rationalList.add(new Rational(7, 4));
        rationalList.add(new Rational(3, 5));
        rationalList.add(new Rational(1, 2));
        rationalList.add(new Rational(2, 7));
        rationalList.add(new Rational(4, 9));
        
        Rational smallestRational = smallestRational(rationalList);
        System.out.println("Smallest rational value: " + smallestRational);
        System.out.println();
        
        
        // Given a list of String values, find the one that is last in lexicographic order.
        List<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("grape");
        stringList.add("cherry");
        stringList.add("pear");
        
        String lastLexicographic = lastLexicographic(stringList);
        System.out.println("Last lexicographic string: " + lastLexicographic);
        System.out.println();
        
        
        // Given an array of Double values, find the maximum.
        Double[] doubleArray = { 3.14, 2.718, 1.618, 0.577, 1.414 };
        
        Double maxDouble = findMax(doubleArray);
        System.out.println("Maximum double value: " + maxDouble);
        System.out.println();
        
        
        //Given a list of Person objects, sort them by surname in lexicographic order.
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Ron", "Weasley"));
        personList.add(new Person("Harry", "Potter"));
        personList.add(new Person("Hermione", "Granger"));
        personList.add(new Person("Severus", "Snape"));
        personList.add(new Person("Albus", "Dumbledore"));
        
        sortBySurname(personList);
        for (Person person : personList) {
            System.out.println(person.getSurname() + ", " + person.givenName);
        }
        System.out.println();
        
        
        // Given a list of Employee objects, sort them by their salaries (lowest first), 
        // and then sort groups of employees with the same salary by surname in lexicographic order.
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("", "Evan", "Garcia", 50000));
        employeeList.add(new Employee("", "Fred", "Norquist", 60000));
        employeeList.add(new Employee("", "Aniol", "Serrasolses", 45000));
        employeeList.add(new Employee("", "Ben", "Marr", 60000));
        employeeList.add(new Employee("", "Rush", "Struges", 50000));
        
        sortEmployees(employeeList);
        
        for (Employee employee : employeeList) {
            System.out.println(employee.getSalary() + " - " + employee.surname + ", " + employee.givenName);
        }
        System.out.println();
        
        
        // Given a list of Employee objects, find the one with the highest salary. 
        // In case of a tie, return the one whose surname comes first in lexicographic order.
        sortEmployees(employeeList);
        Employee highestPaid = employeeList.get(0);
        System.out.println("Highest paid employee: " + highestPaid.surname + ", " + highestPaid.givenName);
        System.out.println();
        
        
        // Given a list of Patient objects, find a patient that does not have an assigned physician (ie. physician is null). 
        // If there is more than one, return the one whose surname comes first in lexicographic order.
        Doctor phil = new Doctor(null, null, "Bill", "Phil", 100000);
        Doctor brown = new Doctor(null, null, "Bob", "Brown", 100000);
        Doctor johnson = new Doctor(null, null, "Jim", "Johnson", 100000);
        
        List<Patient> patientList = new ArrayList<>();
        patientList.add(new Patient("John", "Smith", null));
        patientList.add(new Patient("Alice", "Wonderland", phil));
        patientList.add(new Patient("Bob", "Marley", null));
        patientList.add(new Patient("Kanye", "West", brown));
        patientList.add(new Patient("Rick", "James", johnson));
        
        Patient patientWithoutPhysician = findPatientWithoutPhysician(patientList);
        if (patientWithoutPhysician != null) {
            System.out.println("Patient without physician: " + patientWithoutPhysician);
        } else {
            System.out.println("No patient without physician found.");
        }
        System.out.println();
        
        
        // Custom algorithm to bubblesort patientList moving patients without a physician 
        // assigned to them to the front of the list
        customSort(patientList);
        
        for (Patient patient : patientList) {
            System.out.println("ID: " + patient.ID + " | Physician: " + patient.getPhysician());
        }
        System.out.println();
        
        
        // List where the data is almost sorted by ID, the bubble sort will be faster 
        // than a solution using Collections#sort(List, Comparator) because it will require fewer swaps
        // to bring elements to their correct positions
        List<Patient> patientsTemp1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            patientsTemp1.add(new Patient("FirstName" + i, "Surname" + i, null));
        }
        Collections.shuffle(patientsTemp1); // Randomize the order of the first 5
        for (int i = 5; i < 100; i++) {
            patientsTemp1.add(new Patient("FirstName" + i, "Surname" + i, null));
        }
        customSort(patientsTemp1);
        System.out.println();
        
        
        // List where the data is in reverse order by ID, bubble sort will be slower 
        // than a solution using Collections#sort(List, Comparator) 
        List<Patient> patientsTemp2 = new ArrayList<>();
        for (int i = 99; i >= 0; i--) {
            patientsTemp2.add(new Patient("FirstName" + i, "Surname" + i, null));
        }
        customSort(patientsTemp2);
        System.out.println();
    }
    
    /**
     * Finds the smallest Rational object from a list.
     * @param rationalList The list of Rational objects to search
     * @return The smallest Rational object
     */
    public static Rational smallestRational(List<Rational> rationalList) {
        return Collections.min(rationalList, Comparator.comparingDouble(Rational::doubleValue));
    }
    
    /**
     * Finds the last lexicographic string from a list.
     * @param stringList The list of String values to search
     * @return The last lexicographic string
     */
    public static String lastLexicographic(List<String> stringList) {
        return Collections.max(stringList);      
    }
    
    /**
     * Finds the maximum value from an array of Double values.
     * @param doubleArray The array of Double values
     * @return The maximum Double value
     * @throws IllegalArgumentException if the array is empty
     */
    public static Double findMax(Double doubleArray []) {
        if (doubleArray.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        List<Double> doubleList = Arrays.asList(doubleArray);
        return Collections.max(doubleList);
    }
    
    /**
     * Sorts a list of Person objects by surname in lexicographic order.
     * @param personList The list of Person objects to sort
     */
    public static void sortBySurname(List<Person> personList) {
        Collections.sort(personList, Comparator.comparing(Person::getSurname));
    }
    
    /**
     * Sorts a list of Employee objects by salary (lowest first), then by surname in lexicographic order.
     * @param employeeList The list of Employee objects to sort
     */
    public static void sortEmployees(List<Employee> employeeList) {
        Comparator<Employee> salaryComparator = Comparator.comparingDouble(Employee::getSalary);
        Comparator<Employee> surnameComparator = Comparator.comparing(Employee::getSurname);
        
        employeeList.sort(salaryComparator.reversed().thenComparing(surnameComparator));
    }
    
    /**
     * Finds a patient without an assigned physician, prioritizing lexicographic order of surnames.
     * @param patientList The list of Patient objects to search
     * @return The patient without an assigned physician, or null if none found
     */
    public static Patient findPatientWithoutPhysician(List<Patient> patientList) {
        Comparator<Patient> surnameComparator = Comparator.comparing(Patient::getSurname);
        
        return patientList.stream().filter(patient -> patient.getPhysician() == null).min(surnameComparator).orElse(null);
    }
    
    /**
     * Custom sorting algorithm for a list of Patient objects, moving patients without physicians to the front.
     * @param patients The list of Patient objects to sort
     * @param <T> Type parameter indicating the type of Patient (or its subclass)
     */
    public static <T extends Patient> void customSort(List<T> patients) {
        int n = patients.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                T patient1 = patients.get(j);
                T patient2 = patients.get(j + 1);
                
                boolean swap = (patient1.getPhysician() != null && patient2.getPhysician() == null) ||
                               (patient1.getPhysician() == null && patient2.getPhysician() == null && patient1.getId() > patient2.getId());
                if (swap) {
                    patients.set(j, patient2);
                    patients.set(j + 1, patient1);
                }
            }
        }
    }
}
