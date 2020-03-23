import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkUI {
	private int number_of_player;
	private String player_name;
	
	//Constructor
	public SkunkUI()
	{
		number_of_player = 0;
		player_name = "";
	}
	
	//Function for getting number of Player from user
	public int getNumberofPlayer()
	{
		//Get Input for number of Player from user
		int number_of_player;
		do
		{
			StdOut.print("Please put in a valid number of Player (> 0 and < 2): ");
			number_of_player = StdIn.readInt();
		
		}
		while(number_of_player <= 0 || number_of_player > 10); //ensure user only input a valid number
		
		return number_of_player;
	}
		
	//Function for getting List of Player with Player Name
	public String getPlayerList(int player_number)
	{	
		StdOut.print("Please fill in Player " + player_number + " Name: ");
		String player_name = StdIn.readString();
		return player_name;
	}
	
	//Function for asking user whether they want to continue or not
	public boolean userRollContinue()
	{
		String user_input;
		
		do
		{
			//Ask User to continue the turn or not
			StdOut.print("Continue roll dice (yes/no)? ");
			user_input = StdIn.readString();
		}
		while(!(user_input.equals("yes") || user_input.equals("YES") || user_input.equals("no") || user_input.equals("NO")));
		
		//Return true or false depend on user input
		if(user_input.equals("yes") || user_input.equals("YES"))
			return true;
		else
			return false;
	}
	
	//Function for printing out user total current player turn score
	public void printUserTurnScore(int score)
	{
		//Print out the total turn Score
		StdOut.println("Current turn score: " + score);
	}
	
	//Function for print out user roll values and total roll value
	public void printUserRollValue(String player_name, int die1_value, int die2_value, String skunk_class)
	{
		//Check if skunk_class is empty
		if(!skunk_class.equals(""))
			StdOut.println("Player " + player_name + " rolled " + die1_value + " and " + die2_value + ": " + skunk_class);
		else
			StdOut.println("Player " + player_name + " rolled " + die1_value + " and " + die2_value + ": " + (die1_value + die2_value));
			
	}
	
	public void printUserFullTurnInfo(String player_name, int player_score, int player_chips, int player_chips_lost, String player_roll_audit)
	{
		//Empty Line
		StdOut.println("");
		
		//Print out the Player Score after their turn
		StdOut.println("Player " + player_name + " TOTAL SCORE after this turn is: " + player_score);
		
		//Print out the Player Chip lost their turn
		StdOut.println("Player " + player_name + " lost: " + player_chips_lost  +  " chips");
		
		//Print out the Player Chip after their turn
		StdOut.println("Player " + player_name + " TOTAL CHIPS after this turn is: " + player_chips);
		
		//Print out Complete roll history of Player
		StdOut.println("Player " + player_name + " rolls history: " + player_roll_audit);
	}
}
