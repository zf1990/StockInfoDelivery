import edu.princeton.cs.introcs.StdOut;

/*Main App*/
public class SkunkApp {
	
	public static void main(String[] args) {
		StdOut.println("Welcome to Skunk App");
		
		//Create new Dice instance 
		Dice dice = new Dice();
		
		//Print out last roll
		StdOut.println(dice.toString());
	}
}
