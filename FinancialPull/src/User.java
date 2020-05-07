import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
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
	private String[] Interested_Stock_Symbols;
	
	private Map<String, Double> user_stock; 

	//Constructor
	public User(String user_email)
	{
		this.email_Address = user_email;
		this.user_stock = new HashMap<String, Double>();
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
	
	//Get + Set for User Stock
	public void setUserStock(Map<String, Double> user_stock)
	{
		this.user_stock = user_stock;
	}
	
	public String getUserStock()
	{
		String stock_list = "";
		for (Map.Entry<String, Double> entry : user_stock.entrySet()) {
		    String key = entry.getKey();
		    Double val = entry.getValue();
		    
		    stock_list = stock_list + key + ": " + val + "\n";
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
			}
		}
		
		//Add new stock if the stock does not exists
		//IN addition to update the existing stock_price
		user_stock.put(stock_name, stock_price);		
	}
}
