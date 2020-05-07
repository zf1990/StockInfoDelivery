//https://financialmodelingprep.com/developer/docs/#Stock-Price --API
//https://mkyong.com/webservices/jax-rs/restfull-java-client-with-java-net-url/ --Code
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

import org.json.JSONObject;

import jdk.nashorn.internal.parser.JSONParser;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
	
	
	public static void main(String[] args) {
		
		String[] symbols = new String[] {"SNBR", "SPWR", "OKTA", "MSFT"};

		
		//Variable
		APIRepository api_repo = new APIRepository(symbols);
		api_repo.sendGetRequest();
		
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
		
		//Showing current stock
		StdOut.println("Currently registeredd stock:");
		StdOut.println(user.getUserStock());
		
		//Testing out the User class
		StdOut.println("Adding Stock Name:");
		String stock_name = StdIn.readLine();

		
		//Getting Price and store it for this user
		JSONObject stock_json = new JSONObject(api_repo.getRealTimePrice(stock_name));
		StdOut.println(stock_json.toString());
		StdOut.println(stock_json.getDouble("price"));
		
		//Add the Stock to current user
		user.stockInsertUpdate(stock_name, stock_json.getDouble("price"));
		
		//Showing current stock
		StdOut.println("Currently registeredd stock:");
		StdOut.println(user.getUserStock());
		
	}
}
