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

import com.fasterxml.jackson.databind.ObjectMapper;

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
import java.util.ArrayList;
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
		
 		//Stock example: SNBR,SPWR,OKTA,MSFT

		//Create new User
		ArrayList<User> User_list = new ArrayList<User>();
		
		//Load the user from the existing JSON File
		//TO-DO
		
		//Menu
		int a = 1;
		while(a < 3)
		{
			//getting information for User
			StdOut.println("Please Enter your Email:");
			String user_email = StdIn.readLine();
			
			StdOut.println("Specify list of Stock:");
			String stock_list = StdIn.readLine();
			
			StdOut.println("Specify list of attribute:");
			String attribute_list = StdIn.readLine();
			
			//Inititlize user
			User user = new User(user_email);
			
			//Adding Stock and attribute to User
			//SNBR,SPWR,OKTA,MSFT
			//price, open, change
			user.addInterestedStock(stock_list);
			user.addInterestedProperties(attribute_list);
			
			//Add User to the user list
			User_list.add(user);
			
			a++;
		}
		
		//Convert the user to JSON string for storing
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(User_list);
		System.out.println("ResultingJSONstring = " + jsonString);

		
		//SAMPLE CODE
		/*int a = 1;
		while(a < 3)
		{
			a++;
			//Testing out the User class
			StdOut.println("Please input Email:");
			String input_email = StdIn.readLine();
			
			User user = new User(input_email);
			
			
			
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
			
			//Showing current stock
			StdOut.println("Currently registered stock:");
			String user_stock_list = (user.getUserStock() != "") ? user.getUserStock() : "None";
			StdOut.println(user_stock_list);
			
			User_list.add(user);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		  String jsonString = mapper.writeValueAsString(User_list);
		  System.out.println("ResultingJSONstring = " + jsonString);
		  //System.out.println(json);
		
		StdOut.println("\n");*/
		//SAMPLE CODE
	}
}
