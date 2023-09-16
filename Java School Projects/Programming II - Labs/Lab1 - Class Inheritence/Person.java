/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Lab1;

/**
 * This class represents a Person.
 * It holds information about a person's ID, given name, and surname.
 */
public class Person {
    static int IdCounter = 1;
    public int ID;
    public String givenName;
    public String surname;
    
    /**
     * Constructs a Person object with the specified given name and surname.
     * It assigns a unique ID to each Person object.
     *
     * @param givenName the given name of the Person
     * @param surname the surname of the Person
     */
    public Person(String givenName, String surname) {
        this.givenName = givenName;
        this.surname = surname;
        this.ID = IdCounter;
        IdCounter++;
    }
    
    /**
     * Returns a string representation of the Person object.
     *
     * @return a string representation of the Person object
     */
    @Override
    public String toString(){
        return String.format("%s %s (ID# %d)", this.givenName, this.surname, this.ID);
    }
    
    public String getSurname() {
        return this.surname;
    }
    
}
