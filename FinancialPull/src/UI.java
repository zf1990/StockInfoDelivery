import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
		StdOut.println("******Welcome to the financial manager******");
	}

	//For main menu
	public String mainMenu()
	{
		String user_input;
		
		//List of valid options
		var valid_list = List.of("1", "2", "3", "4");
		
		StdOut.println("Please choose one of the option below:");
		StdOut.println("1. View existing email subscriptions");
		StdOut.println("2. Add new email subscriber");
		StdOut.println("3. Send Email to all subscriber");
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

}
