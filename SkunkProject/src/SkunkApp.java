import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
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
		
		//check for winner
		boolean is_winner = false;
		
		List<Player> winner_list = new ArrayList<Player>();
		
		//Play until there is a winner
		while(!is_winner)
		{
			//Go through turns for each player
			for(Player temp_player : player_list)
			{
				
				Turn playerTurn = new Turn(); //initilize for each player turn
				
				//Original Chip Count
				int user_original_chips = temp_player.getChipCount();
				
				//Set current player for the turn
				
				playerTurn.setCurrentPlayer(temp_player);
				gameUI.showMessage("Current player: " + temp_player.getPlayerName());
				gameUI.showMessage("Would you like to roll? (\"Yes\"/\"No\")");
				String turnCont = gameUI.getInput(new String[] {"Yes", "No"}); //for continue the turn

				
				//Loop for Player to continue turn
				while(turnCont.equals("yes"))
				{
					//Play Turn
					playerTurn.playTurn();
					
					//Get the Dice rolled from Turn
					Dice player_turn_dice = playerTurn.getDice();
					
					//Print out User Roll Value
					gameUI.printUserRollValue(temp_player.getPlayerName(), player_turn_dice.getLastRolldie1() , player_turn_dice.getLastRolldie2(), player_turn_dice.SkunkClassification());
					
					//Print out the total turn Score
					gameUI.showMessage("Current turn score: " + playerTurn.getScore());
					
					//Check to see if Dice rolled is Skunk Dice
					if(!player_turn_dice.SkunkClassification().equals(""))
						break;
					
					//Ask User to continue the turn or not
					gameUI.showMessage("Continue roll dice (yes/no)? ");
					turnCont = gameUI.getInput(new String[] {"Yes", "No"});
				};
				
				//Add the Turn Score to Player Score
				temp_player.addScore(playerTurn.getScore());
				
				//Print out User Full turn Information
				gameUI.printUserFullTurnInfo(temp_player.getPlayerName(), temp_player.getGameScore(), temp_player.getChipCount(), (user_original_chips - temp_player.getChipCount()), temp_player.getRollAudit());
				
				//Check to see if this Player Score is 100 or above
				if(temp_player.getGameScore() >= 100)
				{
					is_winner = true;
					
					if(winner_list.isEmpty())
					{
						winner_list.add(temp_player);
					}
					else
					{
						//Check if temp_player score is more than the current winner score
						if(temp_player.getGameScore() > winner_list.get(0).getGameScore())
						{
							winner_list.clear();
							winner_list.add(temp_player);
						}
						else if(temp_player.getGameScore() == winner_list.get(0).getGameScore())
						{
							winner_list.add(temp_player);
						}
					}
				}
			}
		}
		
		//Showing the list of Winner and their total score
		for(Player win_player : winner_list)
		{
			gameUI.showMessage("");
			gameUI.showMessage("Player " + win_player.getPlayerName() + " won with total score of " + win_player.getGameScore());
		}
	}
	
	
}
