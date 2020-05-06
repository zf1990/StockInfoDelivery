import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UI {

	public void setFrames() {
		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = frame.getContentPane();
		container.setLayout(new FlowLayout());

		JTextField textField = new JTextField();
		textField.setPreferredSize(new Dimension(150, 25));

		JLabel label = new JLabel("Input will appear here");

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String input = textField.getText();
				System.out.println("Input: " + input);

				label.setText(input);
			}
		});

		container.add(textField);
		container.add(okButton);
		container.add(label);

		frame.setVisible(true);
	}
}
