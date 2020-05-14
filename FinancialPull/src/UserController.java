import java.util.*;

public class UserController {
	private HashSet<User> userList;
	private final String userFileName = "UserList.csv";
	//private UI UIDisplay; //Don't know if this is still needed.
	CSVWriter writer;
	List<String> StockFileNames;
	
	public UserController() {
		userList = new HashSet<User>();
		//UI Display = new UI();
		writer = new CSVWriter();
		StockFileNames = new ArrayList<String>();
		readAndLoadUsers();
		
	}

	public void addUsers(String emailAddress, List<String> InterestedSymbols, List<StockAttributes> Attributes) {
		User New_user = new User(emailAddress, InterestedSymbols, Attributes);
		userList.add(New_user);
	}
	
	public void saveUsersToFile() {
		ArrayList<String> rows = new ArrayList<String>();
		String columnHeader = "User Email,Interested Stocks,Interested Properties"; //Important: Don't put spaces after period
		rows.add(columnHeader);
		
		for(User user: userList) {
			String email = user.getEmail_Address(); //This is a csv file, write the next field.
			List<String> stockList = user.getInterested_Stock_Symbols();
			String stocks = String.join("-", stockList);
			List<StockAttributes> attributeList = user.getStockAttributes();
			List<String> attributeStringList = new ArrayList<String>();
			
			for(StockAttributes attr : attributeList) {
				attributeStringList.add(attr.toString());
			}
			
			String attributes = String.join("-", attributeStringList);
			
			String row = email + "," + stocks + "," + attributes;
			rows.add(row);
		}
		
		CSVWriter.writeFile(userFileName, rows);
		
		
	}

	//Read and load a list of users.
	public void readAndLoadUsers() {
		CSVReader reader = new CSVReader(userFileName);
		ArrayList<String> rows = reader.ReadFile();
		
		String headerRow = rows.get(0).replace("﻿", ""); //Somehow this is added to the start of csv.  Not sure why.  Just replacing it and making sure everything else work.
		
		List<String> columnHeaders = Arrays.asList(headerRow.split(",")); //Turning this into a list because Java does not seem to have a natural find or indexOf method in array.
		//Not sure why csv started with a weird symbol that was failing the first line of code.
		int emailIndex = columnHeaders.indexOf("User Email"); //These should be exact and should obtain the index.  The reason why I did not use 0,1,2 directly is due to coupling concerns.
		
		int userStockIndex = columnHeaders.indexOf("Interested Stocks");
		int AttributeIndex = columnHeaders.indexOf("Interested Properties");
		
		//Reading each user and add them to the userList HashSet
		for(int i=1; i<rows.size(); i++) { //Starting at 2nd row because that's where the data actually lives.
			String row = rows.get(i);
			String[] userInfo = row.split(",");
			String userEmail = userInfo[emailIndex]; //Email Should be within the first column.
			List<String> userStocks = Arrays.asList(userInfo[userStockIndex].split("-")); //Get the list of stocks the user is interested in.
			String[] userAttributeArray = userInfo[AttributeIndex].toUpperCase().split("-"); //Get the list of Attributes the user is interested in.  Stored in the 3rd Column
			ArrayList<StockAttributes> userAttributes = new ArrayList<StockAttributes>();
			for(String j : userAttributeArray) {
				userAttributes.add(StockAttributes.valueOf(j)); //Turn it into the enum and add them to the list.
			}
			addUsers(userEmail, userStocks, userAttributes); //Add the user to the collection.
		}
	}
	
	//Method to write stock information csv files.
	public void WriteStockInfo(String user_Email, List<HashMap<String, String>> infoList) {
		
	}
	
	//Get all the information from StockAPI and save it as a dictionary before passing it to WriteStockInfo methods to 
	public void getAllStocksInformation() {
		
		APIRepository[] APIs = new APIRepository[userList.size()];
		
		int index = 0;
		
		for(User user: userList) {
			
			List<String> stocks = user.getInterested_Stock_Symbols();
			String[] symbols = new String[stocks.size()];
			stocks.toArray(symbols);
			List<StockAttributes> attrs = user.getStockAttributes();
			
			APIs[index] = new APIRepository(symbols, attrs);
			APIs[index].sendAndParseResponse();
			
			List<HashMap<String, String>> userInfo = APIs[index].getInfoArray();
			WriteStockInfo(user.getEmail_Address(), userInfo);
			
		}
	}
	
	public HashSet<User> getUserList() {
		return userList;
	}

	public void setUserList(HashSet<User> userList) {
		this.userList = userList;
	}

	public String getUserFileName() {
		return userFileName;
	}
	
	
	


}
