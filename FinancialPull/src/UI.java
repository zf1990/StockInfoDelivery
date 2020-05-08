import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;


public class UI extends JDialog {


    private JButton btnNewButton;
    private JPanel panel;
    private JTextField emailField;
    private JTextField stockCodeField;
    private String user_email;
    private String stock_code;

    public UI() {

        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //this.setSize(370, 150);
        this.setSize(500, 500);
        this.setForeground(new Color(192, 192, 192));
        this.setTitle("Stock Market Price Lookup");
        this.setResizable(false);

        panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        //panel.setLayout(new MigLayout("", "[70.00][132.00,grow][44.00][67.00,grow][61.00][]", "[19.00][34.00][]"));

        //Email section
        JLabel lblNewLabel = new JLabel("User Email:");
        panel.add(lblNewLabel, "cell 0 1,alignx trailing,aligny center");

        emailField = new JTextField();
        emailField.setColumns(13);
        panel.add(emailField, "cell 5 5,alignx center");
        
        //Stock Code section
        JLabel lblNewLabel_1 = new JLabel("Please put in Stock Code:");
        panel.add(lblNewLabel_1, "cell 0 1,alignx trailing,aligny center");

        stockCodeField = new JTextField();
        stockCodeField.setColumns(13);
        panel.add(stockCodeField, "cell 5 5,alignx center");

       // JLabel lblNewLabel_1 = new JLabel("Key");
       // panel.add(lblNewLabel_1, "cell 2 1,alignx center,aligny center");

        /*textField_1 = new JTextField();
        panel.add(textField_1, "cell 3 1,alignx left,aligny center");
        textField_1.setColumns(4);*/

        btnNewButton = new JButton("Save");
        ListenForButton listener = new ListenForButton();

        btnNewButton.addActionListener(listener);
        panel.add(btnNewButton, "cell 4 1");

        this.setVisible(true);

    }

    private class ListenForButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btnNewButton) {

                /*if (passwordField.getPassword().length < 10) {

                	stock_code = passwordField.getPassword().clone();
                }*/

            	stock_code = stockCodeField.getText();
            	user_email = emailField.getText();

            }
        }
    }

    public String getStockCode() {
        return stock_code;
    }

    public String getUserEmail() {
        return user_email;
    }

}
