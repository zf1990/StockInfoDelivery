import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

class APIRepositoryTest {

	@Test
	void test_Send_Get_Request() {
		
		String[] stocks = new String[] {"MSFT", "AAPL", "EA", "ATVI", "UAL"};
		List<StockAttributes> test_attr = new ArrayList<StockAttributes>();
		
		test_attr.add(StockAttributes.CHANGE);
		test_attr.add(StockAttributes.PRICE);
		test_attr.add(StockAttributes.MARKETCAP);
		
		APIRepository api = new APIRepository(stocks,test_attr);
		
		api.sendAndParseResponse();
		
		assertTrue(api.getInfoArray().size()==5);
	}

	@Test
	void test_get_symbol() {
		String[] test_symbol = new String[] {"Test"};
		APIRepository test_repo = new APIRepository(test_symbol);
		
		assertEquals(test_symbol,test_repo.getSymbols());
	}
}
