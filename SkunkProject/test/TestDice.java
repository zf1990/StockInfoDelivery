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
//		@Test
//		public void test_get_dice_1_value_7() {
//			Die d1 = new Die();
//			Die d2 = new Die();
//			Dice d = new Dice(d1, d2);
//			int expected = 7;
//			assertThat(d.getLastRolldie2(), is(expected));
//		}
//	
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
			d.setLastRoll(5,5);
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
		
	//Test for skunk output with die 1
		@Test
		public void test_skunk_roll_die1_output() {

				Die d1 = new Die(1);
				Die d2 = new Die(8);
				Dice d = new Dice(d1, d2);

				String expected = d.SkunkClassification();
				assertThat("Skunk", is(expected));
					
		}
	
	//Test for skunk output with die 2
		@Test
		public void test_skunk_roll_die2_output() {

				Die d1 = new Die(9);
				Die d2 = new Die(1);
				Dice d = new Dice(d1, d2);

				String expected = d.SkunkClassification();
				assertThat("Skunk", is(expected));
					
		}
				
	//Test for Double skunk output
		@Test
		public void test_double_skunk_roll_output() {

				Die d1 = new Die(1);
				Die d2 = new Die(1);
				Dice d = new Dice(d1, d2);

				String expected = d.SkunkClassification();
				assertThat("DoubleSkunk", is(expected));
					
		}	
				
	//Test for Skunk Deuce with die1 = 1 and die2 = 2 output
		@Test
		public void test_deuce_skunk_roll_d11_d22_output() {

				Die d1 = new Die(1);
				Die d2 = new Die(2);
				Dice d = new Dice(d1, d2);

				String expected = d.SkunkClassification();
				assertThat("SkunkDeuce", is(expected));
					
		}
	
	//Test for Skunk Deuce with die1 = 1 and die2 = 2 output
		@Test
		public void test_deuce_skunk_roll_d12_d21_output() {

				Die d1 = new Die(2);
				Die d2 = new Die(1);
				Dice d = new Dice(d1, d2);

				String expected = d.SkunkClassification();
				assertThat("SkunkDeuce", is(expected));
					
		}
		
	//Test for No Skunk output
		@Test
		public void test_no_skunk_roll_output() {

				Die d1 = new Die(5);
				Die d2 = new Die(3);
				Dice d = new Dice(d1, d2);

				String expected = d.SkunkClassification();
				assertThat("", is(expected));
					
		}
	
	//Test for No Skunk output
		@Test
		public void test_to_string() {
	
				Die d1 = new Die(5);
				Die d2 = new Die(3);
				Dice d = new Dice(d1, d2);
	
				String expected = d.toString();
				assertThat("Dice with last roll: 8 => Die 1: 5 + Die 2: 3", is(expected));
					
		}



}
