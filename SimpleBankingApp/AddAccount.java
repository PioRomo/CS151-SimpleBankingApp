package SimpleBankingApp;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AddAccount implements ActionListener {
	// Our variables for AddAccount
	private static final int charLimit = 20;
	private static final String startBalance = "0";
	private String name;
	private String[] types = {"Checkings", "Savings"};
	private String type; 
	
	// Our JFrame variables
	private JFrame mainFrame;
	private JTextField nameText;
	@SuppressWarnings("unchecked")
	private JComboBox typeDropdown = new JComboBox(types);
	private JLabel nameLabel;
	private JLabel nameCharLimLabel;
	private JLabel nameEmptyLabel;
	private JLabel typeLabel;
	private JButton addAccountButton;
	
	
	public AddAccount() {
		
		// setting up JFrame
	    mainFrame = new JFrame("Add Account");
	    mainFrame.setVisible(true);
	    mainFrame.setSize(500, 300);
	    mainFrame.setFont(new Font("Arial",Font.BOLD,18));
	    mainFrame.setLayout(null);
	    
    
	    //Setting up the labels for fields and warning messages
	    nameLabel = new JLabel("Name: ");
	    nameLabel.setBounds(10, 40, 80, 25);
	    
	    nameCharLimLabel = new JLabel("Name over 20 characters not allowed.");
	    nameCharLimLabel.setFont(new Font("Arial",Font.BOLD,10));
	    nameCharLimLabel.setBounds(100, 60, 300, 25);
	    nameCharLimLabel.setVisible(false);
	    
	    nameEmptyLabel = new JLabel("Name is empty");
	    nameEmptyLabel.setFont(new Font("Arial",Font.BOLD,10));
	    nameEmptyLabel.setBounds(100, 60, 300, 25);
	    nameEmptyLabel.setVisible(false);
	    
	    typeLabel = new JLabel("Type: ");
	    typeLabel.setBounds(10, 100, 80, 25);
	    
	    
	    //Setting up user inputs (text field, dropdown selection, and button)
	    nameText = new JTextField(25);
	    nameText.setBounds(100, 40, 165, 25);
	    
	    typeDropdown.setBounds(100, 100, 90, 25);
	    typeDropdown.addActionListener(this);
	    
	    addAccountButton = new JButton("Add Account");
	    addAccountButton.setBounds(160, 180, 165, 25);
	    addAccountButton.addActionListener(this);
	    
	    // Add all components to the frame
	    mainFrame.add(nameLabel);
	    mainFrame.add(nameText);
	    mainFrame.add(nameCharLimLabel);
	    mainFrame.add(nameEmptyLabel);
	    mainFrame.add(typeLabel);
	    mainFrame.add(typeDropdown);
	    mainFrame.add(addAccountButton);
	 
	    
	    //When we close the window, it won't close the app
	    mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	    
	 // When add account button is pressed   
	 @Override
	  public void actionPerformed(ActionEvent e) {
		// set error labels to not visible
		 nameEmptyLabel.setVisible(false);
		 nameCharLimLabel.setVisible(false);

		// get user input from text field and dropdown
		 name = nameText.getText();
		 type = (String)typeDropdown.getSelectedItem();
		 
		 if (e.getActionCommand().equals("Add Account")) {
			 // if name field is blank, return error message
			 if (name.length() == 0) {
				 nameEmptyLabel.setVisible(true);
			 }
		         // if name is over 20 chars, return error message
			 else if (name.length() > charLimit) {
				 nameCharLimLabel.setVisible(true);
			 }
			 // valid inputs, set up user id, put all account info into array row and add it to main menu jtable
			 // increment id counter and close this frame 	
			 else {
				 String idFormat = String.format("%04d", MainMenu.idCounter);
				 String data[] = {name, idFormat, type, startBalance};
				 MainMenu.AddAccountToJTable(data);
				 MainMenu.idCounter++;
				 mainFrame.dispose();
			 }
		 }
	 }
	    
	    
	   
}
