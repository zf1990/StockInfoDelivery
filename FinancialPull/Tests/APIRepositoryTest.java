import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

class APIRepositoryTest {

	@Test
	void testSendGetRequest() {
		
		String[] stocks = new String[] {"MSFT", "AAPL", "EA", "ATVI", "UAL"};
		List<StockAttributes> test_attr = new ArrayList<StockAttributes>();
		
		test_attr.add(StockAttributes.CHANGE);
		test_attr.add(StockAttributes.PRICE);
		test_attr.add(StockAttributes.MARKETCAP);
		
		APIRepository api = new APIRepository(stocks,test_attr);
		
		api.sendAndParseResponse();
		
		assertTrue(api.getInfoArray().size()==5);
	}

}
