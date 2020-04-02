import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

//Class for testing Turn

public class TestTurn {
	
	@Test
	public void test_turn_set1_score()
	{
		Turn test_score = new Turn();
		test_score.setScore(25);
		int expected = 25;
		assertThat(test_score.getScore(), is(expected));
	}
	
	@Test
	public void test_turn_set_score30()
	{
		Turn test_score = new Turn();
		test_score.setScore(30);
		int expected = 30;
		assertThat(test_score.getScore(), is(expected));
	}

	@Test
	public void test_turn_add_score10()
	{
		Turn test_score = new Turn();
		test_score.addScore(10);
		int expected = 10;
		assertThat(test_score.getScore(), is(expected));
	}
	
	@Test
	public void test_play_turn()
	{
		Turn test_turn = new Turn();
		
		test_turn.addScore(10);
		
		int expected = 10;
		assertThat(test_turn.getScore(), is(expected));
	}
	
	@Test
	public void test_set_current_player()
	{
		Turn test_turn = new Turn();
		
		Player expected = new Player();

		test_turn.setCurrentPlayer(expected);
		
		test_turn.setCurrentPlayer(expected);

		assertThat(test_turn.getCurrentPlayer(), is(expected));
	}
	
	@Test
	public void test_set_dice()
	{
		Turn test_turn = new Turn();
		
		Dice expected = new Dice();

		test_turn.setDice(expected);

		assertThat(test_turn.getDice(), is(expected));
	}
	
	

}
