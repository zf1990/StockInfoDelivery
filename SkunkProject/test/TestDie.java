import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

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

}