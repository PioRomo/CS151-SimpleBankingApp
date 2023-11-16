package SimpleBankingApp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DepositBalance implements ActionListener {
    // Our variables for DepositBalance
    private static final int maximumDepositValue = 5000;
    private static final int balanceColumn = 3;
    private int selectedRow;

    // Our JFrame variables
    private JFrame mainFrame;
    private JTextField depositField;
    private JLabel warningLabel;
    private JLabel overMaxLabel;
    private JLabel depositLabel;
    private JPanel labelPane;
    private JPanel fieldPane;
    private JPanel buttonPane;
    private JPanel panel;
    private JButton depositButton;

    public DepositBalance() {
        selectedRow = MainMenu.accountTable.getSelectedRow();

        // Check if a row is selected. If not, user gets an error message.
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            depositWindow();
        }
    }

    private void depositWindow() {
        // Setting up JFrame for Deposit
        mainFrame = new JFrame("Deposit");
        mainFrame.setSize(500, 700);
        mainFrame.setFont(new Font("Arial", Font.BOLD, 18));
        mainFrame.setLayout(new FlowLayout());

        // Setting up the text field
        depositField = new JTextField();
        depositField.setColumns(10);

        // Setting the labels for the text fields
        depositLabel = new JLabel("Deposit: ");
        
        warningLabel = new JLabel("Deposit amount required.");
        warningLabel.setVisible(false);
        warningLabel.setFont(new Font("Arial",Font.BOLD,10));
        warningLabel.setBounds(100,15,160,15);

        overMaxLabel = new JLabel("Deposit must be $5000 or less.");
        overMaxLabel.setVisible(false);
        overMaxLabel.setFont(new Font("Arial", Font.BOLD,10));
        overMaxLabel.setBounds(50,15,160,15);

        // Setting the button
        depositButton = new JButton("Deposit");
        depositButton.setBounds(50,100,50,10);
        depositButton.addActionListener(this);

        // Lay out depositLabel in its panel
        labelPane = new JPanel(new GridLayout(0,1));
        labelPane.add(depositLabel);

        // Lay out the text field in its panel
        fieldPane = new JPanel(new GridLayout(0,1));
        fieldPane.add(depositField);

        // Lay out the button in its panel
        buttonPane = new JPanel(new GridLayout(0,1));
        buttonPane.add(depositButton);

        // Combine all panels into one, and add it to the JFrame
        panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
        panel.setBounds(50,100,50,50);
        panel.add(warningLabel);
        panel.add(overMaxLabel);
        panel.add(labelPane, BorderLayout.CENTER);
        panel.add(fieldPane, BorderLayout.LINE_END);
        panel.add(buttonPane, BorderLayout.AFTER_LAST_LINE);
        mainFrame.add(panel);
        mainFrame.pack();

        // Set deposit window visible
        mainFrame.setVisible(true);

        // When window is closed, the whole app won't close
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    // Method responds to the button press in the deposit window
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get account balance
        String value = MainMenu.accountTable.getModel().getValueAt(selectedRow, balanceColumn).toString();

        // Get account name
        String name = MainMenu.accountTable.getModel().getValueAt(selectedRow, 0).toString();

        DefaultTableModel model = (DefaultTableModel) MainMenu.accountTable.getModel();

        int currentBalance = Integer.parseInt(value);

        // Warning message is displayed if text field is empty.
        if (depositField.getText().isEmpty()) {
            warningLabel.setVisible(true);
            overMaxLabel.setVisible(false);
        }

        // Over maximum deposit value message is displayed if value is greater than $5,000.
        else if (Integer.parseInt(depositField.getText()) > maximumDepositValue) {
            overMaxLabel.setVisible(true);
            warningLabel.setVisible(false);
        }

        // Program shows a confirmation dialog before the deposit is made.
        // If yes is selected, the deposit value gets added to the selected bank account.
        else {
            warningLabel.setVisible(false);
            overMaxLabel.setVisible(false);

            int confirm = JOptionPane.showConfirmDialog(null, "Do you want to deposit $" + Integer.parseInt(depositField.getText()) 
            + " into " + name + "\'s account?");

            if (confirm == JOptionPane.YES_OPTION) {
                currentBalance += Integer.parseInt(depositField.getText());
                model.setValueAt(currentBalance,selectedRow,balanceColumn);
                depositField.setText("");
            }
        }
    }
}
