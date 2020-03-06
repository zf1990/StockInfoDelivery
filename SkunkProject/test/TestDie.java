import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestDie
{

	@Test
	public void test()
	{
		Die d = new Die();
		int expected = 3;
		assertThat(d.getLastRoll(), is(expected));
	}

}
