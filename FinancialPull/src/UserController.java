import java.util.*;

public class UserController {
	private HashSet<User> userList; //A list of users.
	private HashMap<String, User> userDict; //Just another way to get to the user object using their email as the key.
	private final String userFileName = "UserList.csv"; //Stores a list of users and their information.
	//private UI UIDisplay; //Don't know if this is still needed.
	CSVWriter writer;
	List<String> StockFileNames;
	public HashMap<String, String> UserStockFileNames; //Stores user email and their file name
	
	public UserController() {
		userList = new HashSet<User>();
		userDict = new HashMap<String,User>();
		//UI Display = new UI();
		writer = new CSVWriter();
		StockFileNames = new ArrayList<String>();
		UserStockFileNames = new HashMap<String, String>();
		readAndLoadUsers();
		
	}

	public void addUsers(String emailAddress, List<String> InterestedSymbols, List<StockAttributes> Attributes) {
		User New_user = new User(emailAddress, InterestedSymbols, Attributes);
		userList.add(New_user);
		userDict.put(emailAddress, New_user);
	}
	
	public void editUser(String emailAddress, List<String> InterestedSymbols, List<StockAttributes> Attributes) {
		User one = userDict.get(emailAddress);
		one.setInterested_Stock_Symbols(InterestedSymbols);
		one.setStockAttributes(Attributes);
	}
	
	public void editUser(String oldEmailAddress, String newEmailAddress, List<String> InterestedSymbols, List<StockAttributes> Attributes) {
		User one = userDict.get(oldEmailAddress);
		one.setEmail_Address(newEmailAddress);
		one.setInterested_Stock_Symbols(InterestedSymbols);
		one.setStockAttributes(Attributes);
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
		String userStockFile = user_Email.substring(0,4) + " Stock Info.csv";
		UserStockFileNames.put(user_Email, userStockFile);
		User an_User = userDict.get(user_Email);
		List<StockAttributes> attrs = an_User.getStockAttributes();
		
		List<String> attributes = new ArrayList<String>();
		attributes.add("NAME");
		attributes.add("SYMBOL");
		
		String headerRow = "";
		headerRow += "NAME,SYMBOL,";
		
		for(StockAttributes i: attrs) {
			headerRow+=i.toString() + ",";
			attributes.add(i.toString());
		}
		headerRow=headerRow.substring(0,headerRow.length()-1); //removing the extra period at the end.
		
		List<String> rows = new ArrayList<String>();
		rows.add(headerRow); //Add the header row.
		
		for(HashMap<String,String> j: infoList) {
			String newRow="";
			for(String key: attributes) {
				if(key.equals("NAME")) { //Some company names contain period and it may screw up the output in the csv file.
					String companyaName = j.get(key).replace(",","");
					newRow += companyaName + ",";
				} else {
					newRow += j.get(key) + ",";
				}
			}
			newRow = newRow.substring(0,newRow.length()-1); //Removing the extra period at the end.
			rows.add(newRow);
		}
		
		CSVWriter.writeFile(userStockFile, rows);
		
	}
	
	//Get all the information from StockAPI and save it as a dictionary before passing it to WriteStockInfo methods to 
	public void getAllStocksInformation() {
		
		APIRepository[] APIs = new APIRepository[userList.size()];
		
		int index = 0;
		
		for(User user: userList) { //Go through every user in the list...
			
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
	
	public void sendEmails() {
		for(Map.Entry<String, String> entry : UserStockFileNames.entrySet()) {
			//Constructor invoked is (fileName, receiver_Email)
			EmailSender email = new EmailSender(entry.getValue(), entry.getKey());
		}
	}
	
	public void CheckStockAndSendEmail() {
		getAllStocksInformation();
		sendEmails();
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
