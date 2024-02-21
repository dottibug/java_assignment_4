//--------------------------------------------------------------------------------------------
// Author: Tanya Woodside
// COMP 1131 Assignment 4, Question 2
//
// BingoDriver runs the following tests on the Bingo class:
// •    Create and output 20 random bingo calls (duplicate calls are okay)
// •    For each bingo letter, construct 3 bingo calls using the two boundary cases, as well as one
//      within the letter's range.
// •    Create and output bingo calls using invalid letters, as well as invalid numbers for
//      each valid letter.
//--------------------------------------------------------------------------------------------
public class BingoDriver {
    public static void main (String[] args) {

        // ---------------------------------------------------------------------------------------
        // Instantiate and output 20 random bingo calls (don't worry about duplicates)
        // ---------------------------------------------------------------------------------------
        System.out.println("-- TWENTY RANDOM BINGO CALLS --");
        for (int i = 0; i < 20; i++) {
            Bingo bingo = new Bingo();
            System.out.println((i + 1) + ":\t" + bingo);
        }

        // ---------------------------------------------------------------------------------------
        // Create and output 3 cases for each letter using the second Bingo() constructor. Use
        // the two boundary cases, as well as one within the range.
        // Note all the "I" and "G" tests use lowercase letters as parameters, as the case of
        // valid letters doesn't matter.
        // ---------------------------------------------------------------------------------------
        System.out.println("\n-- BINGO CALLS WITH PARAMETERS -- ");
        // Bingo number boundaries
        int lowBoundary = 1;
        int midRange = lowBoundary + 7;
        int highBoundary = 15;

        // Test generation loop
        for (int i = 0; i < 5; i++) {
            String bingoLetter = "";

            // Set bingoLetter based on loop iteration
            switch (i) {
                case 0: bingoLetter = "B"; break;
                case 1: bingoLetter = "i"; break; // lowercase example
                case 2: bingoLetter = "N"; break;
                case 3: bingoLetter = "g"; break; // lowercase example
                case 4: bingoLetter = "O"; break;
            }

            // Construct Bingo objects
            Bingo bingo1 = new Bingo(bingoLetter, lowBoundary);
            Bingo bingo2 = new Bingo(bingoLetter, midRange);
            Bingo bingo3 = new Bingo(bingoLetter, highBoundary);

            // Call bingo objects
            System.out.println("Low: \t" + bingo1);
            System.out.println("Mid: \t" + bingo2);
            System.out.println("High: \t" + bingo3);
            System.out.println("------");
            
            // Update boundaries for next bingoLetter
            lowBoundary += 15;
            midRange += 15;
            highBoundary += 15;
        }

        // ---------------------------------------------------------------------------------------
        // Create and output Bingo objects with invalid letters, as well as invalid numbers for
        // each valid letter.
        // ---------------------------------------------------------------------------------------
        System.out.println("\n-- INVALID BINGO CALLS -- ");

        // Test invalid letters
        Bingo bingo1 = new Bingo("A", 1);
        Bingo bingo2 = new Bingo("x", 1);
        Bingo bingo3 = new Bingo("3", 1);
        Bingo bingo4 = new Bingo("&", 1);
        Bingo bingo5 = new Bingo("dog", 1);

        System.out.println("Test invalid letter (A): " + bingo1);
        System.out.println("Test invalid letter (x): " + bingo2);
        System.out.println("Test invalid letter (3): " + bingo3);
        System.out.println("Test invalid letter (&): " + bingo4);
        System.out.println("Test invalid letter (dog): " + bingo5);
        System.out.println("------");

        // Test invalid numbers
        int outOfRange = 0;

        // Test generation loop (testing invalid numbers for each bingoLetter)
        for (int i = 0; i < 5; i++) {
            String bingoLetter = "";
            // Set bingoLetter based on i
            switch (i) {
                case 0: bingoLetter = "B"; break;
                case 1: bingoLetter = "I"; break;
                case 2: bingoLetter = "N"; break;
                case 3: bingoLetter = "G"; break;
                case 4: bingoLetter = "O"; break;
            }

            // Construct Bingo objects with invalid number
            Bingo bingo6 = new Bingo(bingoLetter, (outOfRange));
            System.out.println("Test invalid number (" + (outOfRange) + ") for "
                    + bingoLetter + ": " + bingo6);

            // Update boundary for next bingo letter
            // Tests the invalid inputs B 0, I 15, N 30, G 45, and O 60
            outOfRange += 15;
        }
    }
}
