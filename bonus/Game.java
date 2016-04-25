/* Sahil Shah and Hari Kosuru
 * ss63683 and hk8663
 * EE 422C - Bonus
 */

package bonus;

import java.util.ArrayList;

public class Game {

	private boolean gameState = false;
	private ArrayList<String[]> guesses = new ArrayList<String[]>();
	private int numberofGuesses;
	
	public Game(boolean state){
		gameState = state;
		numberofGuesses = 0;
	}
	
	public void runGame(){
		if(gameState){
			Board game = new Board();
			String guess = "RGBO";
			if(game.validGuess(guess)){
				System.out.print(game.getcode());
				String output = game.checkGuess(guess);
				System.out.print(output);
				
			}
			else{
				//invalid input
			}
			
		}
	}
}
