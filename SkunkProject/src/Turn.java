
public class Turn {
	private int Score;
	private Player current_player;
	private Dice dice;
	
	public Turn()
	{
		this.Score = 0;
	}
	
	public void setScore(int Score)
	{
		this.Score = Score;
	}
	
	public void setCurrentPlayer(Player input_player)
	{
		this.current_player = input_player;
	}
	
	public void setDice(Dice d)
	{
		this.dice = d;
	}
	
	public int getScore()
	{
		return this.Score;
	}
	
	public Player getCurrentPlayer()
	{
		return this.current_player;
	}
	
	public Dice getDice()
	{
		return this.dice;
	}
	
	public void addScore(int rollValue)
	{
		this.Score += rollValue;
	}
	
	public void playTurn()
	{
		dice = new Dice();
		
		//chip deduct amount
		int chip_deduct = 0;
		
		//Roll the Dice
		dice.roll();
		
		//Get value for each Die
		int die1_value = dice.getLastRolldie1();
		int die2_value = dice.getLastRolldie2();
		
		//Record the roll value to Player
		current_player.recordRollValue(die1_value, die2_value);
		
		//Check if the roll contain Skunk/Skunk Deuce/Double Skunk (This may be moved to other Classes)
		String skunkClassification = dice.SkunkClassification();
		
		if(skunkClassification.equals("DoubleSkunk"))
		{
			//Update user Chip
			chip_deduct = 4;
			
			//Update Turn Score
			this.setScore(0);
			
			//Update Player Score
			current_player.setGameScore(0);
		}
		else if (skunkClassification.equals("SkunkDeuce"))
		{
			//Update user Chip
			chip_deduct = 2;
			
			//Update Turn Score
			this.setScore(0);
		}
		else if (skunkClassification.equals("Skunk"))
		{
			//Set deduct chip amount
			chip_deduct = 1;
			
			//Update Turn Score
			this.setScore(0);
		}
		else
		{
			//Add the roll to turn score
			this.addScore(dice.getLastRoll());
		}
		
		//Update user Chip
		current_player.deductChips(chip_deduct);
	}
}
