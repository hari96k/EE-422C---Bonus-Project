/* Sahil Shah and Hari Kosuru
 * ss63683 and hk8663
 * EE 422C - Bonus
 */

package bonus;

import java.util.Random;

class Board {

	private String[]code = new String[4];
	private String[]colors = {"B", "G", "O", "P", "R", "Y"};
	private boolean winFlag = false;

	Board(){
		code = createCode();
	}

	//creates the random code
    private String[]createCode(){
		String[]code = new String[4];
		Random r = new Random();
		int number = 0;
		for (int i = 0; i<4;i++){
			number = r.nextInt(5);
			code[i] = colors[number];
		}
		return code;
	}

	//checks whether the input guess is valid
    boolean validGuess(String input){
		boolean flag = true;
		char[]array = input.toCharArray();
		if(array.length !=4){
			return false;
		}
		for (int i = 0; i<4;i++){
			if ("BGOPRY".indexOf(array[i]) == -1){
				return false;
			}
		}
		return true;
	}

	//assigns pegs
    String checkGuess(String input){
		int black = 0;
		int white = 0;
		String []array = input.split("");
		
	    boolean[] blackPeg = new boolean[code.length];
	    boolean[] whitePeg = new boolean[array.length];

		for (int i = 0; i<4;i++){
			if (array[i].equals(code[i])){
				black = black + 1;
				blackPeg[i] = whitePeg[i] = true;
			}
		}

	    for (int m = 0; m < 4; m++) {
	        for (int n = 0; n < 4; n++) {
	            if (!blackPeg[m] && !whitePeg[n] && code[m].equals(array[n])) {
	                white++;
	                blackPeg[m] = whitePeg[n] = true;
	                break;
	            }
	        }
	    }

		return formatOutput(black,white);
	}

	//formats the string to be returned
    private String formatOutput(int black, int white){
		if (black == 0 && white == 0){
			return "-> Result: No pegs";
		}
		else if (black > 0 && white == 0){
			if (black == 4){
				winFlag = true;
				return "-> Result: 4 black pegs!! You win !!";
			}
			else{
				return "-> Result: " + black + " black peg";
			}

		}
		else if (white > 0 && black == 0){
			return "-> Result: " + white + " white peg";
		}
		else{
			return "-> Result: " + black + " black peg and " + white + " white peg";
		}
	}

	//takes the random code and makes it into a string
    String getcode(){
		String codeString = "";
		for (int i = 0; i < 4; i++){
			codeString = codeString + code[i];
		}
		return codeString;
	}
}
