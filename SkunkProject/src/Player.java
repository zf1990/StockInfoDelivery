import java.util.ArrayList;
import java.util.List;

public class Player {
	private String player_name;
	private int game_score;
	private int chip_count;
	List<String> roll_audit = new ArrayList<String>();
	//private Turn turn;
	
	//Constructor default with game_score = 0 and chip_count = 50
	public Player() {
		this.game_score = 0;
		this.chip_count = 50;
	}
	
	//Get Player Name
	public String getPlayerName()
	{
		return this.player_name;
	}
	
	//Get Player Score
	public int getGameScore()
	{
		return this.game_score;
	}
	
	//Get Chip Count
	public int getChipCount()
	{
		return this.chip_count;
	}
	
	//Set Player Name
	public void setPlayerName(String player_name)
	{
		this.player_name = player_name;
	}
	
	//Set Player Score
	public void setGameScore(int game_score)
	{
		this.game_score = game_score;
	}
	
	//Set Chip Count
	public void setChipCount(int chip_count)
	{
		this.chip_count = chip_count;
	}
	
	//Add Score after turn
	public void addScore(int score)
	{
		game_score += score;
	}
	
	//Add Chips to Player
	public void addChips(int chips_amount)
	{
		chip_count += chips_amount;
	}
	
	//Deduct Chips from Player
	public void deductChips(int chips_amount)
	{
		chip_count -= chips_amount;
	}
	
	//Record the rolls history
	public void recordRollValue(int die1Value, int die2Value)
	{
		String RollsValue = "(" + die1Value + ","+ die2Value + ")";
		roll_audit.add(RollsValue);
	}
	
	//Get the list of all the rolls outcome
	public String getRollAudit()
	{
		String fullRollAudit = "";
		for(String temp_str : roll_audit)
		{
			fullRollAudit = fullRollAudit + " " + temp_str;
		}
		
		return fullRollAudit;
	}
	
	//Player take turn
	/*public void takeTurn()
	{
		dice.roll();
	}*/
}
