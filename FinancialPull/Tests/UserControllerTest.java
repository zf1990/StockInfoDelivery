import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

class UserControllerTest {

	@Test
	void test_Add_Users() {
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
	void test_edit_user() {
		UserController controller = new UserController();
		
		String email = "test_org@test.test";
		List<String> org_stocks = (new ArrayList<String>(Arrays.asList("OKTA", "WLDN", "BABA", "TWLO", "COST", "ZM")));
		List<StockAttributes> org_test_attr = new ArrayList<StockAttributes>();

		org_test_attr.add(StockAttributes.CHANGE);
		org_test_attr.add(StockAttributes.PERATIO);

		controller.addUsers(email, org_stocks, org_test_attr);
		
		List<String> new_stocks = (new ArrayList<String>(Arrays.asList("OKTA", "WLDN")));
		List<StockAttributes> new_test_attr = new ArrayList<StockAttributes>();
		new_test_attr.add(StockAttributes.CHANGE);
		
		controller.editUser(email, new_stocks, new_test_attr);
		
		User test_user = new User(email, new_stocks, new_test_attr);

		assertEquals(test_user.getInterested_Stock_Symbols(),controller.getUser(email).getInterested_Stock_Symbols());
	}
	
	@Test
	void test_get_filename() {
		UserController controller = new UserController();
		
		String userFileName = "UserList.csv"; 
		
		assertEquals(userFileName,controller.getUserFileName());
	}
	
	@Test
	void test_set_user_list() {
		UserController controller = new UserController();
		
		User test_user = new User("test@test.test");
		
		HashSet<User> userList = new HashSet<User>();
		userList.add(test_user);
		
		controller.setUserList(userList);
		
		assertEquals(userList,controller.getUserList());
	}

	@Test
	void test_Save_Users_To_File() {
		UserController controller = new UserController();

		String email = "zheng612@umn.edu";
		List<String> stocks = (new ArrayList<String>(Arrays.asList("OKTA", "WLDN", "BABA", "TWLO", "COST", "ZM","DIS", "TSLA", "AMZN")));
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
		controller.CheckStockAndSendEmail();
	}

}
