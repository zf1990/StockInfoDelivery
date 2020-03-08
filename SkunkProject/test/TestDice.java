import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;


public class TestDice {

	//Test with pre-defined value of dice1 as 6
	@Test
	public void test_getdice1value_6() {
		Die d1 = new Die(6);
		Die d2 = new Die();
		Dice d = new Dice(d1, d2);
		Die d1_test = d.getdie1();
		int expected = 6;
		assertThat(d1_test.getLastRoll(), is(expected));
	}
	
	//Test with pre-defined value of dice2 as 7
		@Test
		public void test_getdice1value_7() {
			Die d1 = new Die();
			Die d2 = new Die(7);
			Dice d = new Dice(d1, d2);
			Die d2_test = d.getdie2();
			int expected = 7;
			assertThat(d2_test.getLastRoll(), is(expected));
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
		Die d1 = d.getdie1();
		Die d2 = d.getdie2();
		int expected = d1.getLastRoll() + d2.getLastRoll();
		assertThat(d.getLastRoll(), is(expected));
	}

}
