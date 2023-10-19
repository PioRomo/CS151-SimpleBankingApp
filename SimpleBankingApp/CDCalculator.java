package SimpleBankingApp;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

import javax.swing.*;


public class CDCalculator implements PropertyChangeListener{

  private double amount; 
  private double interest; 
  private int length; 
  
  private JFrame mainFrame;
  private JFormattedTextField amountField;
  private JFormattedTextField interestField; 
  private JFormattedTextField lengthField; 
  private JFormattedTextField totalField; 
  private JFormattedTextField accruedField; 

  private JLabel amountLabel; 
  private JLabel interestLabel; 
  private JLabel lengthLabel; 
  private JLabel totalLabel; 
  private JLabel accruedLabel; 

  private NumberFormat amountFormat; 
  private NumberFormat interestFormat; 
  private NumberFormat lengthFormat; 
  private NumberFormat totalFormat; 
 
 

  public CDCalculator() {
     
	//Create and initialize the mainframe
    setFormats();
    mainFrame = new JFrame("CD Calculator");
    mainFrame.setVisible(true);
    mainFrame.setSize(500, 300);
    mainFrame.setFont(new Font("Arial",Font.BOLD,18));
    mainFrame.setLayout(new FlowLayout());
    
   
    //Setting up the buttons and fields
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
   
    amountLabel = new JLabel("CD Amount: ");
    interestLabel = new JLabel("Interest: ");
    lengthLabel = new JLabel("Months: ");
    totalLabel = new JLabel("Total: ");
    accruedLabel = new JLabel("Interest Accrued: ");
  

    //Lay out the labels in a panel.
    JPanel labelPane = new JPanel(new GridLayout(0,1));
    labelPane.add(amountLabel);
    labelPane.add(interestLabel);
    labelPane.add(lengthLabel);
    labelPane.add(totalLabel);
    labelPane.add(accruedLabel);

    //Layout the text fields in a panel.
    JPanel fieldPane = new JPanel(new GridLayout(0,1));
    fieldPane.add(amountField);
    fieldPane.add(interestField);
    fieldPane.add(lengthField);
    fieldPane.add(totalField);
    fieldPane.add(accruedField);
    
    //Add our components to the mainFrame
    labelPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    mainFrame.add(labelPane, BorderLayout.CENTER);
    mainFrame.add(fieldPane, BorderLayout.LINE_END);

    mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  public void propertyChange(PropertyChangeEvent e) {
        Object source = e.getSource();
        if (source == amountField) {
            amount = ((Number)amountField.getValue()).doubleValue();
            //counter++; 
        } else if (source == interestField) {
            interest = ((Number)interestField.getValue()).doubleValue();
            //counter++; 
        } else if (source == lengthField) {
            length = ((Number)lengthField.getValue()).intValue();
            //counter++; 
        }

        double payment = getPayment(amount, interest, length);
        totalField.setValue(payment);
        double accrual = getAccrual(payment, amount);
        accruedField.setValue(accrual); 
        
        
    }

  double getAccrual(double p, double a){
    return p - a; 
  }

  double getPayment(double a, double i, int l){
    double num = 1 + (i/12); 
    System.out.println("Num: " + num);
    double pow = (double) l/12; 
    System.out.println("pow: " + pow);
    double sum = a * Math.pow(num, pow);
    System.out.println("sum: " + sum);
    return sum; 
  }

  private void setFormats(){
    amountFormat = NumberFormat.getNumberInstance(); 

    interestFormat = NumberFormat.getNumberInstance(); 
    interestFormat.setMinimumFractionDigits(3);

    lengthFormat = NumberFormat.getNumberInstance(); 

    totalFormat = NumberFormat.getCurrencyInstance();
  }

}
