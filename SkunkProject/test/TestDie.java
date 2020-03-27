import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class TestDie
{
	@Test
	public void test_die_roll_3()
	{
		Die d = new Die(3);
		int expected = 3;
		assertThat(d.getLastRoll(), is(expected));
	}

	//Fixed method so test would run
	@Test
	public void test_die_roll_4()
	{
		Die d = new Die(4);
		int expected = 4;
		assertThat(d.getLastRoll(), is(expected));
	}
	
	//Added additional method
	@Test
	public void test_die_roll_6()
	{
		Die d = new Die(6);
		int expected = 6;
		assertThat(d.getLastRoll(), is(expected));
	}
	
	@Test
	public void test_for_randomness() {
		//To make sure it is a random die
		Die d = new Die();
		int[] counterArray = new int[] {0,0,0,0,0,0};
		int looper = 10000;
		
		for (int i=0; i<looper; i++) {
			d.roll();
			
			switch(d.getLastRoll()) {
				case 1:
					counterArray[0]++;
					break;
				case 2:
					counterArray[1]++;
					break;
				case 3:
					counterArray[2]++;
					break;
				case 4:
					counterArray[3]++;
					break;
				case 5:
					counterArray[4]++;
					break;
				case 6:
					counterArray[5]++;
					break;
				default:
					fail();
			}
		}
		
		boolean passed_random_test = true; 
		for(int count : counterArray) { //The probability that any one value falls outside of these range is pretty small.
			if (count<=looper/8 || count>=looper/4) {
				passed_random_test = false;
				break;
			}
		}
		
		assertTrue(passed_random_test);
	}

}