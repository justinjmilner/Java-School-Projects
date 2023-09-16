/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Lab2;

/**
 * Represents an ocean wave that makes a sound.
 * Implements the MakesSound interface.
 * Provides information about the wave's sound, safety, height, location, and name.
 */
public class OceanWave implements MakesSound {

    private int height;
    private String location;
    private String name;

    /**
     * Constructs an OceanWave object with the specified name, location, and height.
     *
     * @param name     the name of the ocean wave.
     * @param location the location of the ocean wave.
     * @param height   the height of the ocean wave.
     */
    public OceanWave(String name, String location, int height) {
        this.name = name;
        this.location = location;
        this.height = height;
    }

    /**
     * Returns the sound made by the ocean wave.
     *
     * @return the sound made by the ocean wave.
     */
    @Override
    public String sound() {
        return "WOOOSH!";
    }

    /**
     * Checks if the sound made by the ocean wave is considered good.
     * Prints a cautionary message if the sound is "WOOOSH!".
     *
     * @return true if the sound is considered good, false otherwise.
     */
    @Override
    public boolean isSoundGood() {
        boolean safeSound = true;
        String waveSound = sound();
        if ("WOOOSH!".equals(waveSound)) {
            System.out.println("Waves sound big today, take caution!");
            safeSound = false;
        }
        return safeSound;
    }
}
