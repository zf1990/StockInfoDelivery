import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPlayer {

	@Test
	public void test_player_get_player_name()
	{
		Player test_player = new Player();
		test_player.setPlayerName("TestPlayer123");
		String expected = "TestPlayer123";
		assertThat(test_player.getPlayerName(), is(expected));
	}
	
	@Test
	public void test_player_get_player_score()
	{
		Player test_player = new Player();
		test_player.setGameScore(55);
		int expected = 55;
		assertThat(test_player.getGameScore(), is(expected));
	}

	@Test
	public void test_player_get_chip_count()
	{
		Player test_player = new Player();
		test_player.setChipCount(50);
		int expected = 50;
		assertThat(test_player.getChipCount(), is(expected));
	}
	
	/*@Test
	public void test_player_setDiceRoll()
	{
		Player test_player = new Player();
		test_player.setRollValue(50);
		int expected = 50;
		assertThat(test_player.getRollValue(), is(expected));
	}*/
	
}
