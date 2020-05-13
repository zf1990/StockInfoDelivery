///https://financialmodelingprep.com/developer/docs/#Stock-Price --API
///https://mkyong.com/webservices/jax-rs/restfull-java-client-with-java-net-url/ --Code
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/*import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;*/

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONObject;

//import jdk.nashorn.internal.parser.JSONParser;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.miginfocom.swing.MigLayout;

public class Main {
	
	
	private String user_email;
    private String stock_code;
    //private String[] stock_symbols;

	public static void main(String[] args) throws Exception { 
		
//EXP for UI
		 
		 
		 /*EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                try {
	                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
	                    ex.printStackTrace();
	                }
	
	                System.out.println("Before Window");
	                UI u = new UI();
	                System.out.println("After Window");
	               // System.out.println(u.getUserEmail() + u.getStockCode());
	                
	                
	                //Convert Stock list from String to String Array
	                String[] stock_symbols = u.getStockCode().split(",");
	                
	                
	        		//Variable - example: SNBR,SPWR,OKTA,MSFT
	        		APIRepository api_repo = new APIRepository(stock_symbols);
	        		api_repo.sendGetRequest();
	                
	            }
	      });*/
//EXP for UI
		
 		//Variable - example: SNBR,SPWR,OKTA,MSFT
 		//APIRepository api_repo = new APIRepository(stock_symbols);
 		//api_repo.sendGetRequest();
 		
		//String[] symbols = new String[] {"SNBR", "SPWR", "OKTA", "MSFT"};

		
		//StdOut.println(stock_code);

		
		//Variable
		//APIRepository api_repo = new APIRepository(symbols);
		//api_repo.sendGetRequest();
		
		//Calling the API Repo to get the Real Time Price for Apple
		//String realtimeprice = api_repo.getRealTimePrice("SNBR");
		//System.out.println("Real Time Price");
		//System.out.println(realtimeprice);
		
		//Calling the API to get historical
		//String historical = api_repo.getHistoricalPrice("AAPL",30);		
		//System.out.println("Historical");
		//System.out.println(historical);
		
		//Testing out the User class
		StdOut.println("Please input Email:");
		String input_email = StdIn.readLine();

		//Create new User
		User user = new User(input_email);
		
		while(true)
		{
			//Showing current stock
			StdOut.println("Currently registered stock:");
			String user_stock_list = (user.getUserStock() != "") ? user.getUserStock() : "None";
			StdOut.println(user_stock_list);
			
			//Testing out the User class
			StdOut.println("\n");
			StdOut.println("Adding Stock Name:");
			String stock_name = StdIn.readLine();
		
			//getting Price and store it for the User
            //Convert Stock list from String to String Array
            String[] stock_symbols = stock_name.split(",");
            
    		//Variable - example: SNBR,SPWR,OKTA,MSFT
    		APIRepository api_repo = new APIRepository(stock_symbols);
    		//String response = api_repo.sendGetRequest();
    		
    		//Map Response to JSON Object
			//JSONObject stock_json = new JSONObject(api_repo.sendGetRequest());
    		JSONArray stock_json = new JSONArray(api_repo.sendGetRequest());
    		
			//Go through each Stock
			for (int i = 0; i < stock_json.length(); i++) {
				JSONObject temp_stock = stock_json.getJSONObject(i);
				
				//Insertupdate the user stock information
				user.stockInsertUpdate(temp_stock.getString("symbol"), temp_stock.getDouble("price"));
			}
    		
			StdOut.println("\n");
			//Getting Price and store it for this user
			//JSONObject stock_json = new JSONObject(api_repo.getRealTimePrice(stock_name));
			//StdOut.println(stock_json.toString());
			//StdOut.println(stock_json.getDouble("price"));
			
			//Add the Stock to current user
			//user.stockInsertUpdate(stock_name, stock_json.getDouble("price"));
			
			//Showing current stock
			//StdOut.println("Currently registeredd stock:");
			//StdOut.println(user.getUserStock());
		}
	}
}
