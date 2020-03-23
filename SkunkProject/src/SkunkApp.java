import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.princeton.cs.introcs.StdOut;

/*Main App*/
public class SkunkApp {

	public static void main(String[] args) {
		StdOut.println("Welcome to Skunk App");
		
		//Initialize Number of Player and Player List object
		int number_of_player;
		List<Player> player_list = new ArrayList<Player>();
		
		//Initialize the UI object
		SkunkUI skunkUI = new SkunkUI();
		
		//Get Number of Player
		number_of_player = skunkUI.getNumberofPlayer();
		
		//Get List of Player Name from UI and add to player List
		for(int i = 0; i < number_of_player; i++)
		{
			//Retrieve Player Name from GUI object
			String player_name_temp = skunkUI.getPlayerList(i+1);
			
			//Initialize Player object
			Player player_temp = new Player();
			player_temp.setPlayerName(player_name_temp);
			
			player_list.add(player_temp);
		}
		
		//Original Chip Count
		int user_original_chips;
		
		//Go through turns for each player
		for(Player temp_player : player_list)
		{
			boolean turn_cont; //for continue the turn
			Turn player_turn = new Turn(); //initialize for each player turn
			Dice dice = new Dice();
			user_original_chips = temp_player.getChipCount();
			
			//Loop for Player to continue turn
			do
			{
				//Roll the Dice
				dice.roll();
				
				//Get value for each Die
				int die1_value = dice.getLastRolldie1();
				int die2_value = dice.getLastRolldie2();
				
				//Record the roll value to Player
				temp_player.recordRollValue(die1_value, die2_value);
				
				//Check if the roll contain Skunk/Skunk Deuce/Double Skunk (This may be moved to other Classes)
				String skunkClassification = dice.SkunkClassification();
				
				if(skunkClassification.equals("DoubleSkunk") || skunkClassification.equals("SkunkDeuce") || skunkClassification.equals("Skunk"))
				{
					//Update user Chip
					temp_player.deductChips(4);
					
					//Update Player Score
					player_turn.setScore(0);
					
					//Print out the Player name with the roll die value
					skunkUI.printUserRollValue(temp_player.getPlayerName(), die1_value, die2_value, skunkClassification);
					break;
				}
				else
				{
					//Print out the Player name with the roll die value
					skunkUI.printUserRollValue(temp_player.getPlayerName(), die1_value, die2_value, "");
					
					//Add the roll to turn score
					player_turn.addScore(dice.getLastRoll());
				
				}
					
				//Print out the total turn Score for each player
				skunkUI.printUserTurnScore(player_turn.getScore());
				
				//Ask User to continue the turn or not
				turn_cont = skunkUI.userRollContinue();
				
			}while(turn_cont);
			
			//Add the Turn Score to Player Score
			temp_player.addScore(player_turn.getScore());
			
			//Print out User Full turn Information
			skunkUI.printUserFullTurnInfo(temp_player.getPlayerName(), temp_player.getGameScore(), temp_player.getChipCount(), (user_original_chips - temp_player.getChipCount()), temp_player.getRollAudit());
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
