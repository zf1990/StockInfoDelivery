
public class Die
{
	private int lastRoll;

	public Die()
	{
		this.roll();
	}
	
	//Force the die to have a specific value for last roll
	public Die(int rollNumber)
	{
		this.lastRoll = rollNumber;
	}

	public int getLastRoll() // getter or accessor method
	{

		return this.lastRoll;
	}

	public void roll() // note how this changes Die's state, but doesn't return
						// anything
	{
		this.lastRoll = (int) (Math.random() * 6 + 1);
	}
	
	public void setValue(int value) {
		if (value>=1 && value<=6)
			lastRoll=value;
	}

	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "" + this.getLastRoll();
	}

}
