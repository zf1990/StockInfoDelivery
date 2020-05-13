import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/*
 * Iterate over every key
 * for (String key : objects.keySet()) {
    // use the key here
}
 */

/*Go through both key and valu
 * for (Map.Entry<String, Object> entry : objects.entrySet()) {
    String key = entry.getKey();
    Object val = entry.getValue();
}
 * 
 */

public class User {
	
	private String email_Address;
	private HashSet<String> Interested_Stock_Symbols;
	private HashSet<StockAttributes> stockAttributes;
	private static int NumberOfUsers = 0;
	private static String File_Name = "UserList.csv";
	
	
	
	private Map<String, Double> user_stock = new HashMap<String, Double>(); 

	//Constructor
	public User(String user_email)
	{
		this.email_Address = user_email;
		NumberOfUsers++;
		//AddUserToList();
	}

	public User(String user_email, HashSet<String> Symbols, HashSet<StockAttributes> interestedAttributes) {
		this.email_Address = user_email;
		this.Interested_Stock_Symbols = Symbols;
		stockAttributes = interestedAttributes;
		NumberOfUsers++;
	}
	
	
	
	//Get + Set for User Email
	public void setUserEmail(String user_email)
	{
		this.email_Address = user_email;
	}
	
	public String getUserEmail()
	{
		return this.email_Address;
	}
	
	public void addInterestedStock(String stock_symbol) {
		Interested_Stock_Symbols.add(stock_symbol);
		
	}
	
	public void addInterestedProperties(StockAttributes A_StockAttributes) {
		stockAttributes.add(A_StockAttributes);
	}
	
	public String getEmail_Address() {
		return email_Address;
	}

	public void setEmail_Address(String email_Address) {
		this.email_Address = email_Address;
	}

	public HashSet<String> getInterested_Stock_Symbols() {
		return Interested_Stock_Symbols;
	}

	public void setInterested_Stock_Symbols(HashSet<String> interested_Stock_Symbols) {
		Interested_Stock_Symbols = interested_Stock_Symbols;
	}

	public HashSet<StockAttributes> getStockAttributes() {
		return stockAttributes;
	}

	public void setStockAttributes(HashSet<StockAttributes> stockAttributes) {
		this.stockAttributes = stockAttributes;
	}
	
	public int getNumberOfUsers() {
		return NumberOfUsers;
	}
	//Get + Set for User Stock
	public void setUserStock(Map<String, Double> user_stock) 
	{
		this.user_stock = user_stock;
	}
	
	public String getUserStock()
	{
		String stock_list = "";
		if(user_stock != null)
		{
			for (Map.Entry<String, Double> entry : user_stock.entrySet()) {
			    String key = entry.getKey();
			    Double val = entry.getValue();
			    
			    stock_list = stock_list + key + ": " + val + "\n";
			}
		}
		return stock_list;
	}
	
	
	
	//Add or update stock information
	public void stockInsertUpdate(String stock_name, double stock_price)
	{
		//Send out email if the new stock price is different than the current stock price
		if(user_stock.containsKey(stock_name))
		{
			if(user_stock.get(stock_name) != stock_price)
			{
				//TO-DO send out email
	    		StdOut.println("TO-DO");
			}
		}
		
		//Add new stock if the stock does not exists
		//IN addition to update the existing stock_price
		user_stock.put(stock_name, stock_price);		
	}
}
