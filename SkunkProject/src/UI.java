import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.princeton.cs.introcs.StdOut;



public class UI {
	
	Scanner scanner = new Scanner(System.in);
	
	public UI () {
		displayWelcomeMessage();
	}
	
	public void displayWelcomeMessage() {
		StdOut.println("Welcome to Skunk App");
	}
	
	public void showMessage (String message) {
		StdOut.println(message);
	}
	
	public String getInput(String[] validAnswers) {
		
		Boolean validInput = false;
		String input = "";
		
		while (!validInput) {
			input = scanner.nextLine();
			validInput = checkString(input, validAnswers);
			if (validInput == false) {
				StdOut.println("You have entered a invalid answer.  Please try again!");
			}
		}
		
		return input;
		
	}
	
	public String getInput() {
		String input = scanner.nextLine();
		return input;
		
	}
	
	
	private boolean checkString(String inputString, String[] validAnswers) {
		boolean validInput = false;
		
		for(String i : validAnswers) {
			if (inputString.toLowerCase().equals(i.toLowerCase())) {
				validInput = true;
				validInput = true;
				break;
			}
		}
		
		return validInput;
		
	}
	
	
	public ArrayList<Player> getPlayerInformation() {
		ArrayList<Player> returning_Players = new ArrayList<Player>();
		String question = "Please enter the number of players";
		
		int number_of_players = IntegerVerification(question, 2, 10);
		Scanner scanner = new Scanner(System.in);
		
		for(int i = 0; i < number_of_players; i++)
		{
			//Getting Player Name from user
			StdOut.print("Please fill in Player " + (i+1) + " Name: ");
			String player_name = scanner.nextLine();
			
			//Create new Player instance and add to the player_list
			Player player_temp = new Player();
			player_temp.setPlayerName(player_name);
			returning_Players.add(player_temp);
		}
		
		return returning_Players;
		
	}
	
	private int IntegerVerification(String s) { //Verify whether the input is actually a number, based on a certain question.
		boolean Invalid_Number = true;
		Scanner scan = new Scanner(System.in);
		int returningNumber = -1; //Initialize it to a dummy value.
		
		while(Invalid_Number) {
			StdOut.println(s);
			try {
				String inputNumber = scan.nextLine();
				returningNumber = Integer.parseInt(inputNumber);
				Invalid_Number = false;
			} catch (NumberFormatException e) {
				StdOut.println("You have entered a invalid number, please try again!");
			}
		}
		return returningNumber;
	}
	
	private int IntegerVerification(String s, int minValue, int maxValue) { //Verify whether the input is actually within a certain range.
		int returning_number = IntegerVerification(s);
		Boolean Invalid_Number = true;
		
		while (Invalid_Number) {
			if (returning_number >= minValue && returning_number <= maxValue) {
				Invalid_Number = false;
			} else {
				StdOut.println("You did not provide a number within the accetable range, please enter a number between " + minValue + " and " + maxValue + ".");
				returning_number = IntegerVerification(s);
			}
		}
		
		return returning_number;
	}
	
	

}
