/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Lab1;

/**
 * This class represents a Doctor, which is a type of Employee.
 * It inherits the properties and methods from the Employee class.
 */
public class Doctor extends Employee{
    public String specialty;
    
    /**
     * Constructs a Doctor object with the specified unit, specialty, given name, and surname.
     * The annual salary is set to 250,000 by default.
     *
     * @param unit the unit of the Doctor
     * @param specialty the specialty of the Doctor
     * @param givenName the given name of the Doctor
     * @param surname the surname of the Doctor
     */
    public Doctor(String unit, String specialty, String givenName, String surname, int salary) {
        super(unit, givenName, surname, salary);
        this.specialty = specialty;
    }
    
    /**
     * Returns a string representation of the Doctor object.
     *
     * @return a string representation of the Doctor object
     */
    @Override
    public String toString() {
        return String.format("Dr. %s %s (ID# %d) (%s)", super.givenName, super.surname, super.ID, this.specialty);
    }
}
