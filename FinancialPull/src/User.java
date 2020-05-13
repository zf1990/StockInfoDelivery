import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
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
	private List<String> Interested_Stock_Symbols;
	private List<StockAttributes> stockAttributes;
	private static int NumberOfUsers = 0;
	
	private Map<String, Double> user_stock = new HashMap<String, Double>(); 


	//Constructor
	public User(String user_email)
	{
		this.email_Address = user_email;
		Interested_Stock_Symbols = new ArrayList<String>();
		stockAttributes = new ArrayList<StockAttributes>();
		NumberOfUsers++;
	}

	public User(String user_email, List<String> Symbols, List<StockAttributes> interestedAttributes) {
		this.email_Address = user_email;
		this.Interested_Stock_Symbols = Symbols;
		stockAttributes = interestedAttributes;
		NumberOfUsers++;
	}
	
	public User(String user_email, List<String> Symbols) {
		this.email_Address = user_email;
		this.Interested_Stock_Symbols = Symbols;
		stockAttributes = new ArrayList<StockAttributes>();
		stockAttributes.add(StockAttributes.PRICE);
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
		//Split the String to a String Array
		String[] stock_temp = stock_symbol.split(",");
	
		// for each loop to get and insert stock symbol
        for (String str_temp : stock_temp)  
        { 
    		Interested_Stock_Symbols.add(str_temp);
        } 
		
	}
	

	public void addInterestedStock(ArrayList<String> stocks_symbols) {
		Interested_Stock_Symbols.addAll(stocks_symbols);
	}
	
	public void addInterestedProperties(StockAttributes A_StockAttributes) {
		stockAttributes.add(A_StockAttributes);
	}
	
	public void addInterestedProperties(String A_StockAttributes) {
		//Split the String to a String Array
		String[] prop_temp = A_StockAttributes.split(",");
		
		// for each loop to get the enum of each attributes
        for (String str_temp : prop_temp)  
        { 
        	StockAttributes attribute_enum = StockAttributes.valueOf(str_temp.toUpperCase());
        	stockAttributes.add(attribute_enum);
        } 
		
	}
	
	public String getEmail_Address() {
		return email_Address;
	}

	public void setEmail_Address(String email_Address) {
		this.email_Address = email_Address;
	}

	public List<String> getInterested_Stock_Symbols() {
		return Interested_Stock_Symbols;
	}

	public void setInterested_Stock_Symbols(List<String> interested_Stock_Symbols) {
		Interested_Stock_Symbols = interested_Stock_Symbols;
	}

	public List<StockAttributes> getStockAttributes() {
		return stockAttributes;
	}

	public void setStockAttributes(List<StockAttributes> stockAttributes) {
		this.stockAttributes = stockAttributes;
	}
	
	public static int getNumberOfUsers() {
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
