import java.util.ArrayList;
import java.util.HashSet;

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
	
	public void addUsers(String emailAddress, HashSet<String> InterestedSymbols, HashSet<StockAttributes> Attributes) {
		User New_user = new User(emailAddress, InterestedSymbols, Attributes);
		userList.add(New_user);
	}
	
	public void PopulateAndConstructUsers() {
		
	}
	
	public void saveUsersToFile() {
		
	}
	
	
	
	
	
	

}
