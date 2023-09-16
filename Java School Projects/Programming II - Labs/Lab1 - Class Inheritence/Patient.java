/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Lab1;

/**
 * This class represents a Patient, which is a type of Person.
 * It inherits the properties and methods from the Person class.
 */
public class Patient extends Person {
    
    public Doctor physician;
    
    /**
     * Constructs a Patient object with the specified given name, surname, and physician.
     *
     * @param givenName the given name of the Patient
     * @param surname the surname of the Patient
     * @param physician the physician of the Patient
     */
    public Patient(String givenName, String surname, Doctor physician) {
        super(givenName, surname);
        this.physician = physician;
    }
    
    public Doctor getPhysician() {
        return this.physician;
    }
    
    public int getId() {
        return super.ID;
    }
}
