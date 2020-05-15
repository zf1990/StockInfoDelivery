import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void test_Constructor_with_email() {
		String test_email = "test@testing.com";
		List<StockAttributes> test_attr = new ArrayList<StockAttributes>();
		List<String> test_symb = new ArrayList<String>();

		int currentUserNumber = User.getNumberOfUsers();
		
		User user = new User(test_email);
		
		assertEquals(currentUserNumber+1,User.getNumberOfUsers());
	}
	
	@Test
	void test_Constructor_with_email_Stock_and_attributes() {
		String test_email = "test@testing.com";
		List<StockAttributes> test_attr = new ArrayList<StockAttributes>();
		List<String> test_symb = new ArrayList<String>();
		
		test_attr.add(StockAttributes.CHANGE);
		test_attr.add(StockAttributes.PRICE);
		test_attr.add(StockAttributes.MARKETCAP);
		
		test_symb.add("MSFT");
		int currentUserNumber = User.getNumberOfUsers();
		
		User user = new User(test_email, test_symb, test_attr);
		
		assertEquals(currentUserNumber+1,User.getNumberOfUsers());
	}
	
	@Test
	void test_set_user_email() {
		String test_email = "test@testing.com";
		
		User user = new User(test_email);
		
		assertEquals(test_email,user.getUserEmail());
	}
	
	@Test
	void test_add_interested_stock() {
		String test_email = "test@testing.com";
		
		User user = new User(test_email);
		
		ArrayList<String> Test_Interested_Stock_Symbols = new ArrayList<String>(Arrays.asList("Test_1", "Test_2"));
		
		user.addInterestedStock(Test_Interested_Stock_Symbols);
		
		assertEquals(Test_Interested_Stock_Symbols,user.getInterested_Stock_Symbols());
	}
	
	@Test
	void test_add_interested_attributes() {
		String test_email = "test@testing.com";
		
		User user = new User(test_email);
		
		String Test_StockAttributes = "PRICE";
		StockAttributes Test_StockAttributes_enum = StockAttributes.valueOf(Test_StockAttributes);
		
		List<StockAttributes> Test_StockAttributes_enum_list = new ArrayList<StockAttributes>();
		Test_StockAttributes_enum_list.add(Test_StockAttributes_enum);
		
		user.addInterestedProperties(Test_StockAttributes);
		
		assertEquals(Test_StockAttributes_enum_list,user.getStockAttributes());
	}
	
	@Test
	void test_set_stock_attributes() {
		String test_email = "test@testing.com";
		
		User user = new User(test_email);
		
		String Test_StockAttributes = "PRICE";
		StockAttributes Test_StockAttributes_enum = StockAttributes.valueOf(Test_StockAttributes);
		
		List<StockAttributes> Test_StockAttributes_enum_list = new ArrayList<StockAttributes>();
		Test_StockAttributes_enum_list.add(Test_StockAttributes_enum);
		
		user.setStockAttributes(Test_StockAttributes_enum_list);
		
		assertEquals(Test_StockAttributes_enum_list,user.getStockAttributes());
	}
	
	@Test
	void test_Constructor_with_email_Stock() {
		String test_email = "test@testing.com";
		List<String> test_symb = new ArrayList<String>();
		
		test_symb.add("MSFT");
		int currentUserNumber = User.getNumberOfUsers();
		
		User user = new User(test_email, test_symb);
		
		assertEquals(currentUserNumber+1,User.getNumberOfUsers());
	}

	@Test
	void test_Adding_Stock_to_Interested_Stock_List() {
		String test_email = "test@testing.com";
		List<StockAttributes> test_attr = new ArrayList<StockAttributes>();
		List<String> test_symb;
		
		test_attr.add(StockAttributes.CHANGE);
		test_attr.add(StockAttributes.PRICE);
		test_attr.add(StockAttributes.MARKETCAP);
		
		test_symb = (new ArrayList<String> (
				Arrays.asList("V","MMM","UAL")));
		
		User user = new User(test_email, test_symb, test_attr);
		
		user.addInterestedStock("MSFT");
		
		int sizeOfList = user.getInterested_Stock_Symbols().size();
		
		assertEquals(sizeOfList, 4);
	}

	@Test
	void test_Set_User_Email() {
		String org_email = "test@testing.com";
		String new_email = "new_test@testing.com";
		
		User user = new User(org_email);
		
		user.setUserEmail(new_email);
		
		assertEquals(new_email, user.getEmail_Address());
	}
	
	@Test
	void testAddInterestedProperties() {
		String test_email = "test@testing.com";
		List<StockAttributes> test_attr = new ArrayList<StockAttributes>();
		List<String> test_symb = new ArrayList<String>();
		
		test_attr.add(StockAttributes.CHANGE);
		test_attr.add(StockAttributes.PRICE);
		test_attr.add(StockAttributes.MARKETCAP);
		
		test_symb = (new ArrayList<String> (
				Arrays.asList("V","MMM","UAL")));
		
		User user = new User(test_email, test_symb, test_attr);
		
		user.addInterestedProperties(StockAttributes.CHANGEPERCENTAGE);
		
		assertEquals(user.getStockAttributes().size(),4);
	}

	@Test
	void testGetEmail_Address() {
		String test_email = "test@testing.com";
		List<StockAttributes> test_attr = new ArrayList<StockAttributes>();
		List<String> test_symb = new ArrayList<String>();
		
		test_attr.add(StockAttributes.CHANGE);
		test_attr.add(StockAttributes.PRICE);
		test_attr.add(StockAttributes.MARKETCAP);
		
		test_symb = (new ArrayList<String> (
				Arrays.asList("V","MMM","UAL")));
		
		User user = new User(test_email, test_symb, test_attr);
		
		String email = user.getEmail_Address();
		
		
		assertEquals(email, test_email);
	}

	@Test
	void testSetEmail_Address() {
		String test_email = "test@testing.com";
		List<StockAttributes> test_attr = new ArrayList<StockAttributes>();
		List<String> test_symb = new ArrayList<String>();
		
		test_attr.add(StockAttributes.CHANGE);
		test_attr.add(StockAttributes.PRICE);
		test_attr.add(StockAttributes.MARKETCAP);
		
		test_symb = (new ArrayList<String> (
				Arrays.asList("V","MMM","UAL")));
		
		User user = new User(test_email, test_symb, test_attr);
		
		String newEmail = "fzvibe@yahoo.com";
		
		user.setEmail_Address(newEmail);
		
		assertEquals(user.getUserEmail(), newEmail);
	}

	@Test
	void test_SetInterested_Stock_Symbols() {
		String test_email = "test@testing.com";
		List<StockAttributes> test_attr = new ArrayList<StockAttributes>();
		List<String> test_symb = new ArrayList<String>();
		
		test_attr.add(StockAttributes.CHANGE);
		test_attr.add(StockAttributes.PRICE);
		test_attr.add(StockAttributes.MARKETCAP);
		
		test_symb = (new ArrayList<String> (
				Arrays.asList("V","MMM","UAL")));
		
		User user = new User(test_email, test_symb, test_attr);
		
		List<String> newStocks = (Arrays.asList((new String[] {"GOOG", "MSFT", "UAL"})));
		
		user.setInterested_Stock_Symbols(newStocks);
		
		assertSame(user.getInterested_Stock_Symbols(), newStocks);

	}
	

}
