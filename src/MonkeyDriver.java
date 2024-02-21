//--------------------------------------------------------------------------------------------
// Author: Tanya Woodside
// COMP 1131 Assignment 4, Question 1
//
// MonkeyDriver constructs a monkey at a random point on a vine (between 0 and 100 ft, inclusive)
// climbing either up or down. The user can control the monkey with various commands, allowing
// the monkey to climb up or down, switch direction, print the monkey's initial and current
// state, and talk.
//--------------------------------------------------------------------------------------------

import java.util.Scanner;
public class MonkeyDriver {

    // -------------------------------------------------------------------------------------------
    // Prints the list of possible commands to control the monkey.
    // -------------------------------------------------------------------------------------------
      private static String commands() {
        return "p \tPrint monkey's current position and direction.\n" +
                "c \tThe monkey climbs 1 ft in the current direction.\n" +
                "\tIf the monkey reaches the very top or bottom of the vine,\n" +
                "\tit will switch direction before moving.\n" +
                "s \tSwitch the monkey's direction (does not move the monkey).\n" +
                "i \tPrint the monkey's initial position and direction.\n" +
                "t \tThe monkey says \"bye\" (exit the program).\n";
    }

    // -------------------------------------------------------------------------------------------
    // Constructs a Monkey at a random point on a vine between 0 and 100 feet and randomly sets the
    // monkey's initial direction (up or down).
    // -------------------------------------------------------------------------------------------
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);

        // Instantiate the monkey
        Monkey monkey = new Monkey();

        // Print possible commands
        System.out.println("MONKEY ON A VINE\n");
        System.out.println(commands());

        // Error message
        String errorMsg = "\nOops! You must enter one of these commands:";

        // Control monkey loop
        boolean onVine = true;

        while (onVine) {
            System.out.print("Enter a command: ");
            String command = scan.next().toLowerCase();

                switch (command) {
                    case "p":
                        System.out.println(monkey);
                        break;
                    case "c":
                        monkey.climb();
                        break;
                    case "s":
                        monkey.swap();
                        break;
                    case "i":
                        System.out.println(monkey.initial());
                        break;
                    case "t":
                        System.out.println("The monkey says \"" + monkey.talk() + "\" (Bye)!");
                        onVine = false;
                        break;
                    default:
                        System.out.println(errorMsg);
                        System.out.println(commands());
            }
        }
    }
}
