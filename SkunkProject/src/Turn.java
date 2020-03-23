
public class Turn {
	private int Score;
	
	public Turn()
	{
		this.Score = 0;
	}
	
	public void setScore(int Score)
	{
		this.Score = Score;
	}
	
	public int getScore()
	{
		return this.Score;
	}
	
	public void addScore(int rollValue)
	{
		this.Score += rollValue;
	}
}
