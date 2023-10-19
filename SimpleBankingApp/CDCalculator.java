package SimpleBankingApp;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

import javax.swing.*;


public class CDCalculator implements PropertyChangeListener{

  //Our variables for CD Calculations
  private double amount; 
  private double interest; 
  private int length; 

  //Our JFrame variables
  private JFrame mainFrame;
  private JFormattedTextField amountField;
  private JFormattedTextField interestField; 
  private JFormattedTextField lengthField; 
  private JFormattedTextField totalField; 
  private JFormattedTextField accruedField; 
  private JFormattedTextField perMonthField; 
  private JLabel amountLabel; 
  private JLabel interestLabel; 
  private JLabel lengthLabel; 
  private JLabel totalLabel; 
  private JLabel accruedLabel; 
  private JLabel perMonthLabel; 

  //Our NumberFormat variables
  private NumberFormat amountFormat; 
  private NumberFormat interestFormat; 
  private NumberFormat lengthFormat; 
  private NumberFormat totalFormat; 
 
  public CDCalculator() {
     
	//Function call to set input formats
    //Initializing and setting up the basics of the JFrame
    setFormats();
    mainFrame = new JFrame("CD Calculator");
    mainFrame.setVisible(true);
    mainFrame.setSize(500, 300);
    mainFrame.setFont(new Font("Arial",Font.BOLD,18));
    mainFrame.setLayout(new FlowLayout());
    
   
    //Setting up the fields 
    amountField = new JFormattedTextField(amountFormat);
    amountField.setColumns(10);
    amountField.addPropertyChangeListener("value", this);

    interestField = new JFormattedTextField(interestFormat); 
    interestField.setColumns(10);
    interestField.addPropertyChangeListener("value", this);

    lengthField = new JFormattedTextField(lengthFormat);
    lengthField.setColumns(10);
    lengthField.addPropertyChangeListener("value", this);

    totalField = new JFormattedTextField(totalFormat);
    totalField.setColumns(10);
    totalField.setEditable(false);

    accruedField = new JFormattedTextField(totalFormat);
    accruedField.setColumns(10);
    accruedField.setEditable(false);

    perMonthField = new JFormattedTextField(totalFormat);
    perMonthField.setColumns(10);
    perMonthField.setEditable(false);
   
    //Setting the labels for the fields
    amountLabel = new JLabel("CD Amount: ");
    interestLabel = new JLabel("Interest Rate: ");
    lengthLabel = new JLabel("Months: ");
    totalLabel = new JLabel("Total: ");
    accruedLabel = new JLabel("Interest Accrued: ");
    perMonthLabel = new JLabel("Accrual Per Month: ");
  

    //Lay out the labels in their own panel
    JPanel labelPane = new JPanel(new GridLayout(0,1));
    labelPane.add(amountLabel);
    labelPane.add(interestLabel);
    labelPane.add(lengthLabel);
    labelPane.add(totalLabel);
    labelPane.add(accruedLabel);
    labelPane.add(perMonthLabel);

    //Layout the text fields in their own panel
    JPanel fieldPane = new JPanel(new GridLayout(0,1));
    fieldPane.add(amountField);
    fieldPane.add(interestField);
    fieldPane.add(lengthField);
    fieldPane.add(totalField);
    fieldPane.add(accruedField);
    fieldPane.add(perMonthField);

    //Combine both panels into one mega-panel, and add it to the frame
    JPanel panel = new JPanel(new BorderLayout()); 
    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    panel.add(labelPane, BorderLayout.CENTER);
    panel.add(fieldPane, BorderLayout.LINE_END);
    mainFrame.add(panel);
    mainFrame.pack(); 

    //When we close the window, it won't close the app
    mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  //function that listens to field inputs
  public void propertyChange(PropertyChangeEvent e) {
        Object source = e.getSource();
        if (source == amountField) {
            amount = ((Number)amountField.getValue()).doubleValue();
            
        } else if (source == interestField) {
            interest = ((Number)interestField.getValue()).doubleValue();
            
        } else if (source == lengthField) {
            length = ((Number)lengthField.getValue()).intValue();
            
        }

        /*
         * With all the fields filled, we can calculate 
         * our total number, along with the interest accrued
         * by calling helper functions within the class
         */
        double payment = getPayment(amount, interest, length);
        totalField.setValue(payment);
        double accrual = getAccrual(payment, amount);
        accruedField.setValue(accrual); 
        perMonthField.setValue(accrual / length);
    }

  //Calculates the total interest accrued. Dependent on getPayment()
  double getAccrual(double p, double a){
    return p - a; 
  }

  //Calculates the total payment. This is the inital deposit + interest
  double getPayment(double a, double i, int l){
    double num = 1 + (i/12); 
    double pow = (double) l/12; 
    double sum = a * Math.pow(num, pow);
    return sum; 
  }

  //Sets proper number formatting for our fields
  private void setFormats(){
    amountFormat = NumberFormat.getNumberInstance(); 

    interestFormat = NumberFormat.getNumberInstance(); 
    interestFormat.setMinimumFractionDigits(3);

    lengthFormat = NumberFormat.getNumberInstance(); 

    totalFormat = NumberFormat.getCurrencyInstance();
  }

}
