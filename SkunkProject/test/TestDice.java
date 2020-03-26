import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;


public class TestDice {

	//Test with pre-defined value of dice1 as 6
	@Test
	public void test_get_dice_1_value_6() {
		Die d1 = new Die(6);
		Die d2 = new Die();
		Dice d = new Dice(d1, d2);
		int expected = 6;
		assertThat( d.getLastRolldie1(), is(expected));
	}
	
	//Test with pre-defined value of dice2 as 7
		@Test
		public void test_get_dice_1_value_7() {
			Die d1 = new Die();
			Die d2 = new Die(7);
			Dice d = new Dice(d1, d2);
			int expected = 7;
			assertThat(d.getLastRolldie2(), is(expected));
		}
	
	//Test with pre-defined value dice as 4 and 5
	@Test
	public void test_dice_roll_4_5() {
		Die d1 = new Die(4);
		Die d2 = new Die(5);
		Dice d = new Dice(d1, d2);
		int expected = 9;
		assertThat(d.getLastRoll(), is(expected));
	}
	
	//Test with random value for dice
	@Test
	public void test_dice_roll_random() {
		Dice d = new Dice();
		int expected = d.getLastRolldie1() + d.getLastRolldie2();
		assertThat(d.getLastRoll(), is(expected));
	}
	
	//Test with set LastRoll value
		@Test
		public void test_set_last_roll() {
			Dice d = new Dice();
			d.setLastRoll(10);
			int expected = 10;
			assertThat(d.getLastRoll(), is(expected));
		}
		
	//Test for skunk int
		@Test
		public void test_skunk_roll() {

			Die d1 = new Die(1);
			Die d2 = new Die(1);
			Dice d = new Dice(d1, d2);
			int expected = d.getLastRolldie1() + d.getLastRolldie2();
			assertThat(d.getLastRoll(), is(expected));
		}	
		
	//Test for skunk output
		@Test
		public void test_skunk_roll_output() {

				Die d1 = new Die(1);
				Die d2 = new Die(1);
				Dice d = new Dice(d1, d2);

				String expected = d.SkunkClassification();
				assertThat("DoubleSkunk", is(expected));
					
		}	
				
	//Test for Skunk Deuce output
		@Test
		public void test_deuce_skunk_roll_output() {

				Die d1 = new Die(1);
				Die d2 = new Die(2);
				Dice d = new Dice(d1, d2);

				String expected = d.SkunkClassification();
				assertThat("SkunkDeuce", is(expected));
					
		}


}
