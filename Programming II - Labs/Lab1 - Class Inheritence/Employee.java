/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Lab1;

/**
 * This class represents an Employee, which is a type of Person.
 * It inherits the properties and methods from the Person class.
 */
public class Employee extends Person {
    
    public String unit;
    protected int salary;
    
    /**
     * Constructs an Employee object with the specified unit, given name, and surname.
     *
     * @param unit the unit of the Employee
     * @param givenName the given name of the Employee
     * @param surname the surname of the Employee
     */
    public Employee(String unit, String givenName, String surname, int salary) {
        super(givenName, surname);
        this.unit = unit;  
        this.salary = salary;
    }
    
    /**
     * Returns the annual salary of the Employee.
     *
     * @return the annual salary of the Employee
     */
    public int getSalary() {
        return this.salary;
    }
}
