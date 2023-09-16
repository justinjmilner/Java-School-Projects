/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Lab2;

/**
 * MakesSound interface represents an object that can make a sound.
 * It defines methods to get the sound made and check if the sound is considered good.
 */
public interface MakesSound {

    /**
     * Returns the sound made by the object.
     *
     * @return the sound made by the object.
     */
    String sound();

    /**
     * Checks if the sound made by the object is considered good.
     *
     * @return true if the sound is considered good, false otherwise.
     */
    boolean isSoundGood();
}
