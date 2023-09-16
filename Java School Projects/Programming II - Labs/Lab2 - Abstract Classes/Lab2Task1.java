package Lab2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 * Lab2Task1 class represents the main class for Lab 2 Task 1.
 * It demonstrates the usage of various objects that implement the MakesSound interface.
 * It tests the sound quality of each object and prints the results.
 */
public class Lab2Task1 {

    /**
     * The main method that demonstrates the usage of objects and tests their sound quality.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MakesSound stallion = new Horse("Stallion");

        MakesSound eBike = new Bicycle(6, false, true);

        Freezer.Size chest = Freezer.Size.CHEST;
        MakesSound deepFreeze = new Freezer(chest, true, true);

        MakesSound pipelineWave = new OceanWave("Pipeline", "Hawaii", 50);

        checkSound(pipelineWave);
        checkSound(deepFreeze);
        checkSound(eBike);
        checkSound(stallion);
    }

    /**
     * Checks the sound quality of the given object by invoking its isSoundGood method.
     *
     * @param object the object to check the sound quality of
     */
    public static void checkSound(MakesSound object) {
        object.isSoundGood();
    }

}
