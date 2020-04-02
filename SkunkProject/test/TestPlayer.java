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
	public void test_player_add_player_score()
	{
		Player test_player = new Player();
		test_player.setGameScore(55);
		test_player.addScore(10);
		int expected = 65;
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
	
	@Test
	public void test_player_deduct_chip()
	{
		Player test_player = new Player();
		test_player.setChipCount(50);
		test_player.deductChips(5);
		int expected = 45;
		assertThat(test_player.getChipCount(), is(expected));
	}
	
	@Test
	public void test_player_add_chip()
	{
		Player test_player = new Player();
		test_player.setChipCount(50);
		test_player.addChips(5);
		int expected = 55;
		assertThat(test_player.getChipCount(), is(expected));
	}
	
	@Test
	public void test_player_recordroll()
	{
		Player test_player = new Player();
		test_player.recordRollValue(1,2);
		String expected = "\nTurn: 1\t\t Score: (1,2)\n";
		
		assertThat(test_player.getRollAudit(), is(expected));
	}
	//added 4/1
	@Test
	public void test_player_get_player()
	{
		Player test_set_player = new Player();
		test_set_player.setPlayerName("Player1");
		String expected = "Player1";
		
		assertThat(test_set_player.getPlayerName(), is(expected));
	}
}
