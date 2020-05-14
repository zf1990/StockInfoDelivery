import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

class UserControllerTest {

	@Test
	void testAddUsers() {
		UserController controller = new UserController();
		int origUserSize = controller.getUserList().size();
		
		String email = "testing@test.com";
		List<String> stocks = (new ArrayList<String>(Arrays.asList("V", "MMM", "UAL")));
		List<StockAttributes> test_attr = new ArrayList<StockAttributes>();

		test_attr.add(StockAttributes.CHANGE);
		test_attr.add(StockAttributes.PRICE);
		test_attr.add(StockAttributes.MARKETCAP);

		controller.addUsers(email, stocks, test_attr);
		int newSize = controller.getUserList().size();

		assertTrue(newSize==(origUserSize+1));
	}

	@Test
	void testSaveUsersToFile() {
		UserController controller = new UserController();
		String email = "testing@test.com";
		List<String> stocks = (new ArrayList<String>(Arrays.asList("V", "MMM", "UAL")));
		List<StockAttributes> test_attr = new ArrayList<StockAttributes>();

		test_attr.add(StockAttributes.CHANGE);
		test_attr.add(StockAttributes.PRICE);
		test_attr.add(StockAttributes.MARKETCAP);

		controller.addUsers(email, stocks, test_attr);
		
		controller.saveUsersToFile();
		//Be sure to delete this dummy user from the file.
	}
	
	@Test
	void testAPIRepository() {
		UserController controller = new UserController();
		
		controller.getAllStocksInformation();
		
		assertFalse(controller.getAPI_response_Dict().isEmpty());
	}

}
