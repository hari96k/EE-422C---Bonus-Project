/* Sahil Shah and Hari Kosuru
 * ss63683 and hk8663
 * EE 422C - Bonus
 */

package bonus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

class Game {

    //private boolean gameState = false;
    private int numberOfGuesses;
    private ArrayList<String> guesses;
    Scanner s;

    Game() {
        //gameState = true;
        numberOfGuesses = 0;
        guesses = new ArrayList<String>();
        displayIntro();
        s = new Scanner(System.in);
    }

    void runGame() {
        promptToStart();
        System.out.print("\nGenerating secret code...");
        Board game = new Board();
        while (numberOfGuesses <= 12) {
            System.out.println("\n\nYou have " + (12 - numberOfGuesses) + " guesses left");
            System.out.print("What is your next guess?\nType in the characters for your guess and press enter.\nEnter " +
                    "Guess: ");
            String guess = s.next();
            guesses.add(guess);
            if (guess.equals("update")){
            	//remove the last element added to guesses
            	guesses.remove(guesses.indexOf("update"));
            	//print out elements in guesses
            	for (int i = 0; i<guesses.size(); i++){
            		System.out.println(guesses.get(i));
            	}
            }
            System.out.println("");

            if (game.validGuess(guess)) {
                numberOfGuesses++;
                System.out.print(game.getcode());
                String output = game.checkGuess(guess);
                System.out.print(output);
                if (output.equals("-> Result: 4 black pegs!! You win !!")){
                	numberOfGuesses = 13;
                }
            } else {
            	if (!guess.equals("update")){
                    System.out.println("Invalid Guess. Please try again: ");
            	}
            }
        }
    }

    private void displayIntro() {
        System.out.println("Welcome to Mastermind. Here are the rules.\n\nThis is a text version of the classic board" +
                " game Mastermind.\nThe computer will think of a secret code. The code consists of 4 colored pegs" +
                ".\nThe " +
                "pegs may be one of six colors: blue, green, orange, purple, red, or yellow. A color may appear " +
                "more\n" +
                "than once in the code. You try to guess what colored pegs are in the code and what order they are\n" +
                "in. After you make a valid guess the result (feedback) will be displayed. The result consists of a\n" +
                "black peg for each peg you have guessed exactly correct (color and position) in your guess.\nFor " +
                "each" +
                " peg in the guess that is the correct color, but is out of position, you get a white peg.\nFor each" +
                " peg, which is fully incorrect, you get no feedback.\n\nOnly the first letter of the color is" +
                " displayed. B for Blue, R for Red, and so forth.\nWhen entering guesses you only need to enter the " +
                "first character of each color as a capital letter.\n\nYou have 12 guesses to figure out the secret " +
                "code or you lose the game.\n");
    }

    private void promptToStart() {
        boolean validSelection = false;
        System.out.print("Are you ready to play? (Y/N): ");
        Scanner s = new Scanner(System.in);
        while (!validSelection) {
            char selection = s.next().charAt(0);
            if (selection == 'Y' || selection == 'y')
                validSelection = true;
            else if (selection == 'N' || selection == 'n') {
                System.out.println("Thank you for playing!");
                System.exit(0);
            } else {
                System.out.println("Invalid input, please enter a Y or N");
            }
        }
    }

}
