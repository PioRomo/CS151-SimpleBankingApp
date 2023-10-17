package SimpleBankingApp; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainMenu implements ActionListener {
  //Initialize our variables here
  private JFrame mainFrame;
  private JTextField inputField;
  private JLabel manageLabel; 
  private JTable accountTable; 
 
  private int balance = 0;

  public MainMenu() {

	  
	//Create and initialize the mainframe
    mainFrame = new JFrame("Simple Bank Application");
    mainFrame.setVisible(true);
    mainFrame.setSize(400, 400);
    mainFrame.setFont(new Font("Arial",Font.BOLD,18));
    mainFrame.setLayout(new FlowLayout());
    
    //Setting up the table 
    DefaultTableModel model = new DefaultTableModel(); 
    accountTable = new JTable(model);
    model.addColumn("Name");
    model.addColumn("ID");
    model.addColumn("Type");
    model.addColumn("Balance");
   
    //Setting up the ability to manage accounts 
    manageLabel = new JLabel("Manage Accounts");
    JButton addAccountButton = new JButton("Add");
    JButton deleteAccountButton = new JButton("Delete");
    
    //Add our components to the mainFrame
    mainFrame.add(accountTable);
    mainFrame.add(manageLabel);
    mainFrame.add(addAccountButton);
    mainFrame.add(deleteAccountButton);
    mainFrame.add(new JScrollPane(accountTable));
   
    //adding action listeners to the buttons
    addAccountButton.addActionListener(this);
    deleteAccountButton.addActionListener(this);

    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    //int amount = Integer.parseInt(inputField.getText());
    if (e.getActionCommand().equals("Add")) {
    	
    	System.out.println("Add account here! ");
    } 
    else if (e.getActionCommand().equals("Delete")) {
    	System.out.println("Delete Account here!");
    }
  
  }

  public static void main(String[] args) {
    new MainMenu();
  }
}