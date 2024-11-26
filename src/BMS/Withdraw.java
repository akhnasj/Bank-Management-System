package BMS;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Withdraw extends JFrame implements ActionListener {
    String pin;
    TextField textField;
    JButton b1, b2;

    Withdraw(String pin) { 
        this.pin = pin;

        // Set frame size and layout
        setSize(1550, 1080);
        setLayout(null);
        setLocation(0, 0);

        // Set background image
        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        JLabel l3 = new JLabel(backgroundImage);
        l3.setBounds(0, 0, 1550, 1080); // Ensure full frame coverage
        add(l3);


        // Label for maximum withdrawal limit
        JLabel label1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(475, 225, 700, 35);
        l3.add(label1);

        // Label for prompt to enter withdrawal amount
        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label2.setForeground(Color.white);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(495, 290, 700, 35);
        l3.add(label2);

        // TextField for amount input
        textField = new TextField();
        textField.setBackground(new Color(65, 125, 128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460, 330, 320, 25);
        textField.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.add(textField);

        // Withdraw button
        b1 = new JButton("WITHDRAW");
        b1.setBounds(700, 417, 150, 35);
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        // Back button
        b2 = new JButton("BACK");
        b2.setBounds(700, 472, 150, 35);
        b2.setBackground(new Color(65, 125, 128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        // JFrame setup
        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount = textField.getText();
            Date date = new Date();

            // If Withdraw button is pressed
            if (e.getSource() == b1) {
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
                } else {
                    // Checking current balance
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from transactions where pin = '" + pin + "'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }

                    // Check if balance is sufficient
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    // Insert withdrawal into database
                    c.statement.executeUpdate("insert into transactions values('" + pin + "','" + date + "', 'withdrawal', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");

                    // Close the current Withdraw screen
                    setVisible(false);
                    // Optionally, you can create a new main class to go back
                    // new Main(pin);
                }
            }
            // If Back button is pressed
            else if (e.getSource() == b2) {
                // Go back to the Main screen
                new Main(pin); // Pass pin to Main page
                setVisible(false); // Hide the current Withdraw screen
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Withdraw(""); // Pass a sample pin or use an empty string for testing
    }
}
