import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void test_Constructor_with_email_Stock_and_attributes() {
		String test_email = "test@testing.com";
		List<StockAttributes> test_attr = new ArrayList<StockAttributes>();
		List<String> test_symb = new ArrayList<String>();
		
		test_attr.add(StockAttributes.Change);
		test_attr.add(StockAttributes.Price);
		test_attr.add(StockAttributes.Market_Cap);
		
		test_symb.add("MSFT");
		int currentUserNumber = User.getNumberOfUsers();
		
		User user = new User(test_email, test_symb, test_attr);
		
		assertEquals(currentUserNumber+1,User.getNumberOfUsers());
	}

	@Test
	void test_Adding_Stock_to_Interested_Stock_List() {
		String test_email = "test@testing.com";
		List<StockAttributes> test_attr = new ArrayList<StockAttributes>();
		List<String> test_symb;
		
		test_attr.add(StockAttributes.Change);
		test_attr.add(StockAttributes.Price);
		test_attr.add(StockAttributes.Market_Cap);
		
		test_symb = (new ArrayList<String> (
				Arrays.asList("V","MMM","UAL")));
		
		User user = new User(test_email, test_symb, test_attr);
		
		user.addInterestedStock("MSFT");
		
		int sizeOfList = user.getInterested_Stock_Symbols().size();
		
		assertEquals(sizeOfList, 4);
	}

	@Test
	void testAddInterestedProperties() {
		String test_email = "test@testing.com";
		List<StockAttributes> test_attr = new ArrayList<StockAttributes>();
		List<String> test_symb = new ArrayList<String>();
		
		test_attr.add(StockAttributes.Change);
		test_attr.add(StockAttributes.Price);
		test_attr.add(StockAttributes.Market_Cap);
		
		test_symb = (Arrays.asList((new String[] {"V", "MMM", "UAL"})));
		
		User user = new User(test_email, test_symb, test_attr);
		
		user.addInterestedProperties(StockAttributes.Change_Percentage);
		
		assertEquals(user.getStockAttributes().size(),4);
	}

	@Test
	void testGetEmail_Address() {
		String test_email = "test@testing.com";
		List<StockAttributes> test_attr = new ArrayList<StockAttributes>();
		List<String> test_symb = new ArrayList<String>();
		
		test_attr.add(StockAttributes.Change);
		test_attr.add(StockAttributes.Price);
		test_attr.add(StockAttributes.Market_Cap);
		
		test_symb = (Arrays.asList((new String[] {"V", "MMM", "UAL"})));
		
		User user = new User(test_email, test_symb, test_attr);
		
		String email = user.getEmail_Address();
		
		
		assertEquals(email, test_email);
	}

	@Test
	void testSetEmail_Address() {
		String test_email = "test@testing.com";
		List<StockAttributes> test_attr = new ArrayList<StockAttributes>();
		List<String> test_symb = new ArrayList<String>();
		
		test_attr.add(StockAttributes.Change);
		test_attr.add(StockAttributes.Price);
		test_attr.add(StockAttributes.Market_Cap);
		
		test_symb = (Arrays.asList((new String[] {"V", "MMM", "UAL"})));
		
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
		
		test_attr.add(StockAttributes.Change);
		test_attr.add(StockAttributes.Price);
		test_attr.add(StockAttributes.Market_Cap);
		
		test_symb = (Arrays.asList((new String[] {"V", "MMM", "UAL"})));
		
		User user = new User(test_email, test_symb, test_attr);
		
		List<String> newStocks = (Arrays.asList((new String[] {"GOOG", "MSFT", "UAL"})));
		
		user.setInterested_Stock_Symbols(newStocks);
		
		assertSame(user.getStockAttributes(), newStocks);

	}
	

}
