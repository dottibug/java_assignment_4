// -------------------------------------------------------------------------------------------
// Author: Tanya Woodside
// COMP 1131 Assignment 4, Question 1
//
// Represents a monkey on a vine at a point between 0 and 100 ft (inclusive) and climbing
// either up or down.
// -------------------------------------------------------------------------------------------
import java.util.Random;

public class Monkey {
    private static final Random random = new Random();
    private enum Direction {
        up, down
    }
    private final int initialPosition;
    private final Direction initiaDirection;
    private int currentPosition;
    private Direction currentDirection;
  
    // -------------------------------------------------------------------------------------------
    // Constructor: Sets up a monkey at an initial random point between 0 and 100 (inclusive) and
    // randomly sets the monkey's direction.
    // -------------------------------------------------------------------------------------------
    public Monkey() {
        initialPosition = getRandomVinePosition();
        initiaDirection = getRandomClimbDirection();

        currentPosition = initialPosition; 
        currentDirection = initiaDirection; 
    }

    // -------------------------------------------------------------------------------------------
    // Get the monkey's initial random starting position on the vine
    // -------------------------------------------------------------------------------------------
    private static int getRandomVinePosition() {
        final int VINE_MAX = 101;
        return random.nextInt(VINE_MAX);
    }

    // -------------------------------------------------------------------------------------------
    // Get the monkey's initial random climbing direction
    // -------------------------------------------------------------------------------------------
    private static Direction getRandomClimbDirection() {
        final int DIR_MAX = 2;
        int direction = random.nextInt(DIR_MAX);
        return direction == 0 ? Direction.down : Direction.up;
    }

    // -------------------------------------------------------------------------------------------
    // Moves the monkey 1 foot in the current direction. If the monkey is at 100 ft and climbing
    // up or at 0 ft and climbing down, the monkey will switch direction before moving 1 ft.
    // -------------------------------------------------------------------------------------------
    public void climb() {
        final int VINE_START = 0;
        final int VINE_END = 100;

        // Monkey is climbing down
        if (currentDirection == Direction.down) {
            // Change direction to up if monkey is at 0 ft
            if (currentPosition == VINE_START) {
                currentDirection = Direction.up;
                currentPosition += 1;
                return;
            } else {
                currentPosition -= 1;
            }
        }
        // Monkey is climbing up
        if (currentDirection == Direction.up) {
            // Change direction to down if monkey is at 100 ft
            if (currentPosition == VINE_END) {
                currentDirection = Direction.down;
                currentPosition -= 1;
            } else {
                currentPosition += 1;
            }
        }
    }

    // -------------------------------------------------------------------------------------------
    // Switches monkey direction.
    // -------------------------------------------------------------------------------------------
    public void swap() {
        currentDirection = currentDirection == Direction.up ? Direction.down : Direction.up;
    }

    // -------------------------------------------------------------------------------------------
    // Prints monkey's initial position and direction.
    // -------------------------------------------------------------------------------------------
    public String initial() {
        return "The monkey started at " + initialPosition + " ft, climbing "
                + (initiaDirection == Direction.up ? "up." : "down.");
    }

    // -------------------------------------------------------------------------------------------
    // Monkey says bye.
    // -------------------------------------------------------------------------------------------
    public String talk() {
        return "Ee-eee Oo-ooo";
    }

    // -------------------------------------------------------------------------------------------
    // Returns the monkey's current position and direction as a string.
    // -------------------------------------------------------------------------------------------
    public String toString() {
        return "The monkey is at " + currentPosition + " ft and climbing "
                + (currentDirection == Direction.up ? "up." : "down.");
    }
}