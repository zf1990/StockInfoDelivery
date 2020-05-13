import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Controller {
	public APIRepository APIHandler = new APIRepository();
	public HashSet<User> userList;
	public UI UIDisplay;
	CSVWriter writer;
	
	public Controller() {
		userList = new HashSet<User>();
		UI Display = new UI();
		writer = new CSVWriter();
	}

	public void addUsers(String emailAddress, List<String> InterestedSymbols, List<StockAttributes> Attributes) {
		User New_user = new User(emailAddress, InterestedSymbols, Attributes);
		userList.add(New_user);
	}
	
	public void PopulateAndConstructUsers() {
		
	}
	
	public void saveUsersToFile() {
		
	}
	
	public void readAndLoadUsers() {
		CSVReader reader = new CSVReader("UserList.csv");
		ArrayList<String> rows = reader.ReadFile();
		
		String headerRow = rows.get(0);
		List<String> columnHeaders = Arrays.asList(headerRow.split(",")); //Turning this into a list because Java does not seem to have a natural find or indexOf method in array.
		int emailIndex = columnHeaders.indexOf("User Email"); //These should be exact and should obtain the index.  The reason why I did not use 0,1,2 directly is due to future scalability issue
		int userStockIndex = columnHeaders.indexOf("Interested Stocks");
		int AttributeIndex = columnHeaders.indexOf("Interested Properties");
		
		for(int i=1; i<rows.size(); i++) { //Starting at 2nd row because that's where the data actually lives.
			String row = rows.get(i);
			String[] userInfo = row.split(",");
			String userEmail = userInfo[emailIndex]; //Email Should be within the first column.
			List<String> userStocks = Arrays.asList(userInfo[userStockIndex].split("-")); //Get the list of stocks the user is interested in. Stored in the 2nd column of the UserList.csv file.
			String[] userAttributeArray = userInfo[AttributeIndex].split("-"); //Get the list of Attributes the user is interested in.  Stored in the 3rd Column
			ArrayList<StockAttributes> userAttributes = new ArrayList<StockAttributes>();
			for(String j : userAttributeArray) {
				userAttributes.add(StockAttributes.valueOf(j)); //Turn it into the enum and add them to the list.
			}
			addUsers(userEmail, userStocks, userAttributes); //Add the user to the collection.
		}
	}
	
	
	
	
	
	
	
	
	
	

}
