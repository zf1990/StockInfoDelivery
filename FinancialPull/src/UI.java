import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;


public class UI
{

	//Constructor
	public UI()
	{
		StdOut.println("****** Welcome to the Financial Manager ******");
	}

	//For main menu
	public String mainMenu()
	{
		String user_input;
		
		//List of valid options
		var valid_list = List.of("1", "2", "3", "4");
		
		StdOut.println();
		StdOut.println("**** Main Menu ****");
		StdOut.println("Please choose one of the options below:");
		StdOut.println("1. View existing email subscriptions");
		StdOut.println("2. Add/Update new email subscriber");
		StdOut.println("3. Send email to all subscribers");
		StdOut.println("4. Exit");
		
		StdOut.print("Option:");
		user_input = StdIn.readLine();
		
		while(!isValidMenuOptions(valid_list, user_input))
		{
			StdOut.println();
			StdOut.print("Please input a valid option:");
			user_input = StdIn.readLine();
		}
		
		return user_input;
	}
	
	//For viewing currently subscribed user menu
	public void subscribedUser(String user_list)
	{
		String user_input;
		
		//List of valid options
		var valid_list = List.of("1");
		
		StdOut.println();
		StdOut.println("*** User Summary ****");
		StdOut.println("Current user subscriptions:");
		StdOut.println(user_list);
		
		StdOut.print("Input 1 to go back to main menu:");
		user_input = StdIn.readLine();
		
		while(!isValidMenuOptions(valid_list, user_input))
		{
			StdOut.println();
			StdOut.print("Please input a valid option:");
			user_input = StdIn.readLine();
		}
	}
	
	//For getting new user information
	public String[] getNewUser()
	{
		String user_input;
		String user_email;
		String user_stock;
		String user_attribute;
		
		//List of valid options
		var valid_list = List.of("1");
		
		StdOut.println();
		StdOut.println("*** Adding or Updating New User ****");
		StdOut.println("NOTE: if the email already existed in the subscribed list, the record will be replaced.");
		StdOut.println();
		StdOut.print("User Email: ");
		user_email = StdIn.readLine();
		StdOut.print("List of interested stocks: ");
		user_stock = StdIn.readLine();
		StdOut.print("List of attributes: ");
		user_attribute = StdIn.readLine();
		
		String[] output_array = new String[] {user_email,user_stock,user_attribute};
		
		return output_array;
		
		/*StdOut.print("Input 1 to go back to main menu:");
		user_input = StdIn.readLine();
		
		while(!isValidMenuOptions(valid_list, user_input))
		{
			StdOut.println();
			StdOut.print("Please input a valid option:");
			user_input = StdIn.readLine();
		}*/
	}

	//Validate user input
	public boolean isValidMenuOptions(List<String> valid_options, String user_input)
	{
		//trim user input
		user_input = user_input.trim();
		
		//Check if it is valid
		if(valid_options.contains(user_input))
			return true;
		else
			return false;
	}
	
	//Function to print out
	public void printout(String str)
	{
		StdOut.print(str);
	}

}
