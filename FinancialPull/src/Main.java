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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

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
	
    private static HashSet<User> user_list;
    private static UI ui;
    private static UserController user_controller;
	
	public static void main(String[] args) throws Exception{ 
		//Stock example: SNBR,SPWR,OKTA,MSFT
		//Initialize
		String option_input;
		
		user_controller = new UserController();
		user_list = new HashSet<User>();
		ui = new UI();
		
		//Getting the list of user from CSV
		user_list = user_controller.getUserList();
		
		//FINAL CODE
		
		//While loop for showing the main menu
		do
		{
			option_input = ui.mainMenu();
			//StdOut.println(user_list);
			if(option_input.equals("1")) //View the current list of user
			{
				ui.subscribedUser(user_summary());
			}
			else if(option_input.equals("2")) //Add or update the user
			{
				addUpdateUser();
			}
			else if(option_input.equals("3"))
			{
				//TODO - call the send email to send out email
				
				//TODO - call the send email to send out email
				ui.printout("\n");
				ui.printout("Email is sent to all subscribed users!\n\n");
				ui.printout("Moving back to main menu");
				int sec = 3;
				while(sec > 0)
				{
					ui.printout(".");
					TimeUnit.SECONDS.sleep(1);
					sec--;
				}
				ui.printout("\n");
			}
		
		}
		while(!option_input.equals("4"));
	}
	
	//Function to prepare user subscribed summary 
	public static String user_summary()
	{
		String output_string = "\n";

		//Get information for each user
		 for (User user : user_list) 
		 {
			 String user_email = user.getEmail_Address();
			 List<String> user_stock = user.getInterested_Stock_Symbols();
			 List<StockAttributes> user_att = user.getStockAttributes();
			 
			 //Construct the output String
			 output_string = output_string + "User Email: " + user_email + "\n"; //Add Email
			 
			 //Add Email
			 output_string += "Interested Stock: ";
			 
			 //Iterate through stock list
			 for (String stock_temp : user_stock) 
			 {
				 output_string += stock_temp + " ";
			 }
			 
			 output_string += "\n";
			 
			 //Iterate through attribute
			 output_string += "Subscribed Attributes: ";
			 
			//Iterate through stock list
			 for (StockAttributes att_temp : user_att) 
			 {
				 output_string += att_temp.name() + " ";
			 }
			 
			 output_string+="\n\n";
		 }
		 
		 return output_string;
	}
	
	//Function to Get the Email, Stock info, and attribute list then add/update user list
	public static void addUpdateUser() throws Exception
	{
		//check if exist flag
		boolean existing_flag = false;
		
		String[] new_user_info = ui.getNewUser(); //0 - Email, 1 - Stock, 2 - Attribute
		
		String user_email = new_user_info[0];
		
		//Convert user_stock to list of string type
		List<String> new_user_stock = new ArrayList<String>();
		//new_user_stock = Arrays.asList(new_user_info[1].split(","));
		
		String[] temp_stock_list = new_user_info[1].toUpperCase().split(",");
		
		for(String j : temp_stock_list)
		{
			new_user_stock.add(j.trim());
		}

		//Convert user_attribute to list of string type
		List<StockAttributes> user_attribute_list = new ArrayList<StockAttributes>();
		
		String[] temp_attribute_list = new_user_info[2].toUpperCase().split(",");
		
		for(String j : temp_attribute_list)
		{
			StockAttributes temp_attribute = StockAttributes.valueOf(j.trim());
			user_attribute_list.add(temp_attribute);
		}
			
		//Check to see if this email already exist in the system
		for (User user : user_list) 
		{
			//If found, then replace the current information with the new information
			if(user.getEmail_Address().toUpperCase().equals(user_email.toUpperCase()))
			{
				user.setInterested_Stock_Symbols(new_user_stock);
				user.setStockAttributes(user_attribute_list);
				existing_flag = true;
				break;
			}
		}
		
		//If not found, then add new user to the list
		if(!existing_flag)
		{
			User new_user = new User(user_email, new_user_stock, user_attribute_list);
			user_list.add(new_user);
		}
		
		//TO-DO UPDATE THE CSV WITH THE NEW LIST --TODO
		
		//Delay before moving back to Main Menu after 3 seconds
		ui.printout("\n");
		ui.printout("Add/Update completed. Moving back to main menu");
		int sec = 3;
		while(sec > 0)
		{
			ui.printout(".");
			TimeUnit.SECONDS.sleep(1);
			sec--;
		}
		ui.printout("\n");
	}
}
