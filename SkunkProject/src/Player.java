import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
	private String player_name;
	private int game_score;
	private int chip_count;
	private HashMap roll_audits = new HashMap<Integer, String>();
	List<String> roll_audit = new ArrayList<String>();
	private int turnCounter;
	//private Turn turn;
	
	//Constructor default with game_score = 0 and chip_count = 50
	public Player() {
		this.game_score = 0;
		this.chip_count = 50;
		turnCounter=0;
		
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
	public void recordRollValue(int die1Value, int die2Value) //I would consider changing this to a dictionary.
	{
		turnCounter++;
		String RollsValue = "(" + die1Value + ","+ die2Value + ")";
		roll_audit.add(RollsValue);
		roll_audits.put(turnCounter, RollsValue);
	}
	
	//Get the list of all the rolls outcome
	public String getRollAudit()
	{
		String fullRollAudit = "\n";
//		for(String temp_str : roll_audit)
//		{
//			fullRollAudit = fullRollAudit + " " + temp_str;
//		}
		
		for(int i = 1; i<=roll_audits.size(); i++) {
			fullRollAudit += "Turn: " + i + "\t\t Score: " + roll_audits.get(i) + "\n";
		}
		
		
		return fullRollAudit;
	}
	
	//Player take turn
	/*public void takeTurn()
	{
		dice.roll();
	}*/
}
