package SimpleBankingApp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class WithdrawBalance implements ActionListener {
    // Our variables for WithdrawBalance
    private static final int balanceColumn = 3;
    private int selectedRow;
    
    // Our JFrame variables
    private JFrame mainFrame;
    private JTextField withdrawField;
    private JLabel warningLabel;
    private JLabel insuffLabel;
    private JLabel withdrawLabel;
    private JPanel labelPane;
    private JPanel fieldPane;
    private JPanel buttonPane;
    private JPanel panel;
    private JButton withdrawButton;
    


    public WithdrawBalance() {
        selectedRow = MainMenu.accountTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            withdrawWindow();
        }
    }

    private void withdrawWindow() {
        // Setting up JFrame for Withdrawal
        mainFrame = new JFrame("Withdrawal");
        mainFrame.setSize(500,700);
        mainFrame.setFont(new Font("Arial",Font.BOLD,18));
        mainFrame.setLayout(new FlowLayout());

        // Setting up the text field
        withdrawField = new JTextField();
        withdrawField.setColumns(10);

        // Setting up the labels for the text fields
        withdrawLabel = new JLabel("Withdrawal: ");

        warningLabel = new JLabel("Withdrawal amount required.");
        warningLabel.setVisible(false);
        warningLabel.setFont(new Font("Arial",Font.BOLD,10));
        warningLabel.setBounds(100,15,160,15);

        insuffLabel = new JLabel("Insufficient funds. $25 fee issued.");
        insuffLabel.setVisible(false);
        insuffLabel.setFont(new Font("Arial",Font.BOLD,10));
        insuffLabel.setBounds(25,15,250,15);

        // Setting up the button
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(50,100,50,10);
        withdrawButton.addActionListener(this);

        // Lay out withdrawLabel in its panel
        labelPane = new JPanel(new GridLayout(0,1));
        labelPane.add(withdrawLabel);

        // Lay out the text field in its panel
        fieldPane = new JPanel(new GridLayout(0,1));
        fieldPane.add(withdrawField);

        // Lay out the button in its panel
        buttonPane = new JPanel(new GridLayout(0,1));
        buttonPane.add(withdrawButton);

        // Combine all panels into one, and add it to the JFrame
        panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
        panel.setBounds(50,100,50,50);
        panel.add(warningLabel);
        panel.add(insuffLabel);
        panel.add(labelPane, BorderLayout.CENTER);
        panel.add(fieldPane, BorderLayout.LINE_END);
        panel.add(buttonPane, BorderLayout.AFTER_LAST_LINE);
        mainFrame.add(panel);
        mainFrame.pack();

        // Set withdraw window to visible
        mainFrame.setVisible(true);

        // When window is closed, the whole app won't close
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    // Method responds to the button press in the withdrawal window
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get account balance
        String value = MainMenu.accountTable.getModel().getValueAt(selectedRow,balanceColumn).toString();

        // Get account name
        String name = MainMenu.accountTable.getModel().getValueAt(selectedRow,0).toString();

        // Get table model
        DefaultTableModel model = (DefaultTableModel) MainMenu.accountTable.getModel();

        // Account balance from string to integer
        int currentBalance = Integer.parseInt(value);

        // Warning message is displayed if text field is empty.
        if (withdrawField.getText().isEmpty()) {
            warningLabel.setVisible(true);
            insuffLabel.setVisible(false);
        }

        // Program shows a confirmation dialog box before the withdrawal is made.
        // If yes is selected, the money gets withdrawn from the selected bank account.
        else {
            warningLabel.setVisible(false);
            insuffLabel.setVisible(false);

            int confirm = JOptionPane.showConfirmDialog(null, "Do you want to withdraw $" + 
            Integer.parseInt(withdrawField.getText()) + " from " + name + "\'s account?");

            if (confirm == JOptionPane.YES_OPTION) {
                // If withdrawal amount is greater than current balance in account, user gets a $25 fee.
                if (Integer.parseInt(withdrawField.getText()) > currentBalance) {
                    insuffLabel.setVisible(true);
                    warningLabel.setVisible(false);

                    currentBalance -= 25;
                    model.setValueAt(currentBalance,selectedRow,balanceColumn);
                }
                else {
                    currentBalance -= Integer.parseInt(withdrawField.getText());
                    model.setValueAt(currentBalance,selectedRow,balanceColumn);
                }
                withdrawField.setText("");
            }
        }
    }
}
