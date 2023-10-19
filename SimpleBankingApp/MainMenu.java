package SimpleBankingApp; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainMenu implements ActionListener {
  //Initialize our variables here
  private JFrame mainFrame;
  private JLabel manageLabel; 
  private JTable accountTable; 
 
  private int balance = 0;

  public MainMenu() {
    
    
	  
	//Create and initialize the mainframe
    mainFrame = new JFrame("Simple Bank Application");
    mainFrame.setVisible(true);
    mainFrame.setSize(700, 700);
    mainFrame.setFont(new Font("Arial",Font.BOLD,18));
    mainFrame.setLayout(new FlowLayout());
    
    //Setting up the table 
    DefaultTableModel model = new DefaultTableModel(); 
    accountTable = new JTable(model);
    model.addColumn("Name");
    model.addColumn("ID");
    model.addColumn("Type");
    model.addColumn("Balance");
   
    //Setting up the buttons
    manageLabel = new JLabel("Manage Accounts");
    JButton addAccountButton = new JButton("Add");
    JButton deleteAccountButton = new JButton("Delete");
    JButton depositButton = new JButton("Deposit");
    JButton withdrawButton = new JButton("Withdraw");
    JButton CDCalcButton = new JButton("CD Calculator");

  
    
    //Add our components to the mainFrame
    mainFrame.add(accountTable);
    mainFrame.add(manageLabel);
    mainFrame.add(addAccountButton);
    mainFrame.add(deleteAccountButton);
    mainFrame.add(depositButton);
    mainFrame.add(withdrawButton);
    mainFrame.add(CDCalcButton);
    mainFrame.add(new JScrollPane(accountTable));
   
    //adding action listeners to the buttons
    addAccountButton.addActionListener(this);
    deleteAccountButton.addActionListener(this);
    depositButton.addActionListener(this);
    withdrawButton.addActionListener(this);
    CDCalcButton.addActionListener(this);

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
    else if (e.getActionCommand().equals("Deposit")) {
    	System.out.println("Deposit here! ");
    }
    else if (e.getActionCommand().equals("Withdraw")) {
    	System.out.println("Withdraw here!");
    }
    else if (e.getActionCommand().equals("CD Calculator")) {
    	new CDCalculator();
    }
  
  }

  public static void main(String[] args) {
    new MainMenu();
  }
}