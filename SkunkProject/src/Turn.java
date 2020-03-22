
public class Turn {
	private int Score;
	//private Dice Dice;
	
	public Turn()
	{
		this.Score = 0;
		//this.rollDice();
	}
	
	public void setScore(int Score)
	{
		this.Score = Score;
	}
	
	/*public void setDiceRoll(int RollValue)
	{
		this.Dice.setLastRoll(RollValue);
	}*/
	
	public int getScore()
	{
		return this.Score;
	}
	
	public void addScore(int rollValue)
	{
		this.Score += rollValue;
	}
	
	/*public int getDiceRoll()
	{
		int value = this.Dice.getLastRoll();
		return value;
	}
	
	public void rollDice()
	{
		this.Dice.roll();
	}*/
}
