/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Lab1;

/**
 * This class represents a Nurse, which is a type of Employee.
 * It inherits the properties and methods from the Employee class.
 */
public class Nurse extends Employee {
    public static final int SHIFT_A = 80000;
    public static final int SHIFT_B = 85000;
    public static final int SHIFT_C = 90000;
    private int shift;
    
    /**
     * Constructs a Nurse object with the specified unit, given name, and surname.
     * The default shift is set to SHIFT_A.
     *
     * @param unit the unit of the Nurse
     * @param givenName the given name of the Nurse
     * @param surname the surname of the Nurse
     */
    Nurse(String unit, String givenName, String surname) {
        super(unit, givenName, surname);
        this.shift = SHIFT_A;
    }
    
    /**
     * Sets the shift of the Nurse.
     *
     * @param shift the shift value to set
     */
    public void setShift(int shift) {
        this.shift = shift;
    }
    
    /**
     * Returns the shift of the Nurse.
     *
     * @return the shift value of the Nurse
     */
    public int getShift() {
        return this.shift;
    }
    
    /**
     * Returns a string representation of the Nurse object.
     *
     * @return a string representation of the Nurse object
     */
    @Override
    public String toString() {
        int shiftNumber;
        if (this.shift == SHIFT_A) {
            shiftNumber = 1;
        }
        if (this.shift == SHIFT_A) {
            shiftNumber = 2;
        }
        else {
            shiftNumber = 3;
        }
        return String.format("%s %s (ID# %d) (%s, shift %d)", super.givenName, super.surname, super.ID, super.unit, shiftNumber);
    }
    
}
