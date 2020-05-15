import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

class UserControllerTest {

	@Test
	void testAddUsers() {
		UserController controller = new UserController();
		int origUserSize = controller.getUserList().size();
		
		String email = "zheng612@umn.edu";
		List<String> stocks = (new ArrayList<String>(Arrays.asList("OKTA", "WLDN", "BABA", "TWLO", "COST", "ZM")));
		List<StockAttributes> test_attr = new ArrayList<StockAttributes>();

		test_attr.add(StockAttributes.CHANGE);
		test_attr.add(StockAttributes.PERATIO);
		test_attr.add(StockAttributes.PRICE);
		test_attr.add(StockAttributes.MARKETCAP);

		controller.addUsers(email, stocks, test_attr);
		int newSize = controller.getUserList().size();

		assertTrue(newSize==(origUserSize+1));
	}

	@Test
	void testSaveUsersToFile() {
		UserController controller = new UserController();

		String email = "zfang1216@gmail.com";
		List<String> stocks = (new ArrayList<String>(Arrays.asList("DIS", "TSLA", "AMZN", "ICLN")));
		List<StockAttributes> test_attr = new ArrayList<StockAttributes>();

		test_attr.add(StockAttributes.CHANGE);
		test_attr.add(StockAttributes.PERATIO);
		test_attr.add(StockAttributes.PRICE);
		test_attr.add(StockAttributes.MARKETCAP);

		controller.addUsers(email, stocks, test_attr);
		
		controller.saveUsersToFile();
		//Be sure to delete this dummy user from the file.
	}
	
	@Test
	void test_getting_stocks_and_sned_emails() { //Nothing really to test
		UserController controller = new UserController();
		controller.getAllStocksInformation();
		controller.sendEmails();
	}

}
