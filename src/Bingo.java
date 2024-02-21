// -------------------------------------------------------------------------------------------
// Author: Tanya Woodside
// COMP 1131 Assignment 4, Question 2
//
// Represents a bingo call, which can be randomly constructed without parameters or called with
// parameters. If invalid arguments are used for the parameters, the bingo call will be "N, FREE"
// -------------------------------------------------------------------------------------------

import java.util.Random;
public class Bingo {
    private static final Random random = new Random();
    private enum Letter {B, I, N, G, O};
    private Letter bingoLetter;
    private int bingoNumber;

    // -------------------------------------------------------------------------------------------
    // Constructs a random Bingo call
    // -------------------------------------------------------------------------------------------
    public Bingo() {
        final int MAX = 5;
        int randomNumber = random.nextInt(MAX); // 0, 1, 2, 3, 4

        switch (randomNumber) {
            case 0:
                bingoLetter = Letter.B;
                bingoNumber = random.nextInt(1, 16); // 1 to 15
                break;
            case 1:
                bingoLetter = Letter.I;
                bingoNumber = random.nextInt(16, 31); // 16 to 30
                break;
            case 2:
                bingoLetter = Letter.N;
                bingoNumber = random.nextInt(31, 46); // 31 to 45
                break;
            case 3:
                bingoLetter = Letter.G;
                bingoNumber = random.nextInt(46, 61); // 46 to 60
                break;
            case 4:
                bingoLetter = Letter.O;
                bingoNumber = random.nextInt(61, 75); // 61 to 75
                break;
            default: 
                bingoLetter = Letter.N;
                bingoNumber = 0;
        }
    }

    // -------------------------------------------------------------------------------------------
    // Constructs a Bingo call from given parameters (letter and number). Letters may be
    // uppercase or lowercase. If either parameter is invalid, bingoLetter is set to N and
    // bingoNumber to 0 (0 prints as "FREE" in toString()).
    // -------------------------------------------------------------------------------------------
    public Bingo(String letter, int number) {
        setBingoLetter(letter);
        setBingoNumber(number);
    }

    // -------------------------------------------------------------------------------------------
    // Get bingoLetter
    // -------------------------------------------------------------------------------------------
    public String getBingoLetter() {
        return bingoLetter.toString();
    }

    // -------------------------------------------------------------------------------------------
    // Set bingoLetter (defaults to N if the parameter is an invalid letter).
    // -------------------------------------------------------------------------------------------
    private void setBingoLetter(String letter) {
        // Check and set the letter
        letter = letter.toUpperCase();
        switch (letter) {
            case "B", "I", "N", "G", "O":
                bingoLetter = Letter.valueOf(letter);
                break;
            default:
                bingoLetter = Letter.N;
        }
    }

    // -------------------------------------------------------------------------------------------
    // Get bingoNumber
    // -------------------------------------------------------------------------------------------
    public int getBingoNumber() {
        return bingoNumber;
    }

    // -------------------------------------------------------------------------------------------
    // Set bingoNumber
    // -------------------------------------------------------------------------------------------
    private void setBingoNumber(int number) {
        // Check that the number falls within the correct range of the letter
        boolean isValidNumber;
        switch (bingoLetter) {
            case B:
                isValidNumber = number >= 1 && number <= 15;
                break;
            case I:
                isValidNumber = number >= 16 && number <= 30;
                break;
            case N:
                isValidNumber = number >= 31 && number <= 45;
                break;
            case G:
                isValidNumber = number >= 46 && number <= 60;
                break;
            case O:
                isValidNumber = number >= 61 && number <= 75;
                break;
            default:
                isValidNumber = false;
        }

        // Set bingoNumber if valid; 0 otherwise
        // If bingoNumber is invalid, set bingoLetter to N
        bingoNumber = isValidNumber ? number : 0;
        if (!isValidNumber) bingoLetter = Letter.N;
    }

    // -------------------------------------------------------------------------------------------
    // Print the bingo call
    // -------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return bingoLetter + ", " + (bingoNumber == 0 ? "FREE" : bingoNumber);
    }
}
