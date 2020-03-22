import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.princeton.cs.introcs.StdOut;

/*Main App*/
public class SkunkApp {

	//Function for getting number of Player from user
	public static int getNumberofPlayer()
	{
		//Initilize the scanner for user input
		Scanner scanner = new Scanner(System.in);
		
		//Get Input for number of Player from user
		int number_of_player;
		do
		{
			StdOut.print("Please put in a valid number of Player (> 0 and < 10): ");
			number_of_player = scanner.nextInt();
		
		}
		while(number_of_player <= 0 || number_of_player > 10); //ensure user only input a valid number
		
		return number_of_player;
	}
	
	//Function for getting List of Player with Player Name
	public static List<Player> getPlayerList(int number_of_player)
	{
		//Initilize the scanner for user input
		Scanner scanner = new Scanner(System.in);
				
		//Initialize a list of Player with the input number
		List<Player> player_list = new ArrayList<Player>(number_of_player);
		
		//Getting Player Name for each Player
		for(int i = 0; i < number_of_player; i++)
		{
			//Getting Player Name from user
			StdOut.print("Please fill in Player " + (i+1) + " Name: ");
			String player_name = scanner.nextLine();
			
			//Create new Player instance and add to the player_list
			Player player_temp = new Player();
			player_temp.setPlayerName(player_name);
			player_list.add(player_temp);
		}
		
		return player_list;
	}
	
	public static void main(String[] args) {
		StdOut.println("Welcome to Skunk App");
		
		Scanner scanner = new Scanner(System.in);
		
		//Get Number of Player
		int number_of_player = getNumberofPlayer();
		
		//Get List of Player with Player Name
		List<Player> player_list = getPlayerList(number_of_player);
		
		//Original Chip Count
		int user_original_chips;
		
		//Go through turns for each player
		for(Player temp_player : player_list)
		{
			String turnCont = "yes"; //for continue the turn
			Turn playerTurn = new Turn(); //initilize for each player turn
			Dice dice = new Dice();
			user_original_chips = temp_player.getChipCount();
			
			//Loop for Player to continue turn
			while(turnCont.equals("yes"))
			{
				//Roll the Dice
				dice.roll();
				
				//Get value for each Die
				int die1Value = dice.getLastRolldie1();
				int die2Value = dice.getLastRolldie2();
				
				//Record the roll value to Player
				temp_player.recordRollValue(die1Value, die2Value);
				
				//Check if the roll contain Skunk/Skunk Deuce/Double Skunk (This may be moved to other Classes)
				String skunkClassification = dice.SkunkClassification();
				
				if(skunkClassification.equals("DoubleSkunk"))
				{
					//Update user Chip
					temp_player.deductChips(4);
					
					//Update Player Score
					temp_player.setGameScore(0);
					
					StdOut.println("Player " + temp_player.getPlayerName() + " rolled " + die1Value + " and " + die2Value + ": " + "Double Skunk");
					break;
				}
				else if (skunkClassification.equals("SkunkDeuce"))
				{
					//Update user Chip
					temp_player.deductChips(2);
					
					//Update Turn Score
					playerTurn.setScore(0);
					
					StdOut.println("Player " + temp_player.getPlayerName() + " rolled " + die1Value + " and " + die2Value + ": " + "Skunk Deuce");
					break;
				}
				else if (skunkClassification.equals("Skunk"))
				{
					//Update user Chip
					temp_player.deductChips(1);
					
					//Update Turn Score
					playerTurn.setScore(0);
					
					StdOut.println("Player " + temp_player.getPlayerName() + " rolled " + die1Value + " and " + die2Value + ": " + "Skunk");
					break;
				}
				else
					StdOut.println("Player " + temp_player.getPlayerName() + " rolled " + die1Value + " and " + die2Value + ": " + dice.getLastRoll());
				
				//Add the roll to turn score
				playerTurn.addScore(dice.getLastRoll());
				
				//Print out the total turn Score
				StdOut.println("Current turn score: " + playerTurn.getScore());
				
				//Ask User to continue the turn or not
				StdOut.print("Continue roll dice (yes/no)? ");
				turnCont = scanner.nextLine();
			};
			
			//Add the Turn Score to Player Score
			temp_player.addScore(playerTurn.getScore());
			
			//Empty Line
			StdOut.println("");
			
			//Print out the Player Score after their turn
			StdOut.println("Player " + temp_player.getPlayerName() + " TOTAL SCORE after this turn is: " + temp_player.getGameScore());
			
			//Print out the Player Chip lost their turn
			StdOut.println("Player " + temp_player.getPlayerName() + " lost: " + (user_original_chips - temp_player.getChipCount())  +  " chips");
			
			//Print out the Player Chip after their turn
			StdOut.println("Player " + temp_player.getPlayerName() + " TOTAL CHIPS after this turn is: " + temp_player.getChipCount());
			
			//Print out Complete roll history of Player
			StdOut.println("Player " + temp_player.getPlayerName() + " rolls history: " + temp_player.getRollAudit());
		}
		
		
		//Testing section
		/*for(Player player_t : player_list)
		{
			StdOut.println(player_t.getPlayerName());
		}*/
		//Testing section
		
		//Create new Dice instance 
		//Dice dice = new Dice();
		
		//Print out last roll
		//StdOut.println(dice.toString());
	}
	
	
}
