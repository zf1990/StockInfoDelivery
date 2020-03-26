import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

//Class for testing Turn

public class TestTurn {
	
	@Test
	public void test_turn_se_score()
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

}
