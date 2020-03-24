import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.princeton.cs.introcs.StdOut;

/*Main App*/
public class SkunkApp {
	
	UI gameUI;
	ArrayList<Player> player_list;
	
	
	public SkunkApp() {
		gameUI = new UI();
		StartGame();
	}
	
	public void StartGame() {
		player_list = gameUI.getPlayerInformation();
		onegame();
		
	}

	public void onegame() {		
		
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
				int die1_value = dice.getLastRolldie1();
				int die2_value = dice.getLastRolldie2();
				
				//Record the roll value to Player
				temp_player.recordRollValue(die1_value, die2_value);
				
				//Check if the roll contain Skunk/Skunk Deuce/Double Skunk (This may be moved to other Classes)
				String skunkClassification = dice.SkunkClassification();
				
				if(skunkClassification.equals("DoubleSkunk"))
				{
					//Update user Chip
					temp_player.deductChips(4);
					
					//Update Player Score
					temp_player.setGameScore(0);
					
					
					gameUI.printUserRollValue(temp_player.getPlayerName(), die1_value, die2_value, skunkClassification);
					break;
				}
				else if (skunkClassification.equals("SkunkDeuce"))
				{
					//Update user Chip
					temp_player.deductChips(2);
					
					//Update Turn Score
					playerTurn.setScore(0);
					
					gameUI.printUserRollValue(temp_player.getPlayerName(), die1_value, die2_value, skunkClassification);
					break;
				}
				else if (skunkClassification.equals("Skunk"))
				{
					//Update user Chip
					temp_player.deductChips(1);
					
					//Update Turn Score
					playerTurn.setScore(0);
					
					gameUI.printUserRollValue(temp_player.getPlayerName(), die1_value, die2_value, skunkClassification);
					break;
				}
				else
				{
					gameUI.printUserRollValue(temp_player.getPlayerName(), die1_value, die2_value, "");
					
					//Add the roll to turn score
					playerTurn.addScore(dice.getLastRoll());
				}
				
				
				//Print out the total turn Score
				gameUI.showMessage("Current turn score: " + playerTurn.getScore());
				
				//Ask User to continue the turn or not
				gameUI.showMessage("Continue roll dice (yes/no)? ");
				turnCont = gameUI.getInput(new String[] {"Yes", "No"});
			};
			
			//Add the Turn Score to Player Score
			temp_player.addScore(playerTurn.getScore());
			
			//Print out User Full turn Information
			gameUI.printUserFullTurnInfo(temp_player.getPlayerName(), temp_player.getGameScore(), temp_player.getChipCount(), (user_original_chips - temp_player.getChipCount()), temp_player.getRollAudit());
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
