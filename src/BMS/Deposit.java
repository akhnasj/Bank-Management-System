package BMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    TextField textField;
    JButton b1, b2;

    Deposit(String pin) {
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

        // Label for deposit prompt
        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(460, 225, 400, 35);
        l3.add(label1);

        // TextField for amount input
        textField = new TextField();
        textField.setBackground(new Color(65, 125, 128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460, 270, 320, 25);
        textField.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.add(textField);

        // Deposit button
        b1 = new JButton("DEPOSIT");
        b1.setBounds(700, 357, 150, 35);
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        // Back button
        b2 = new JButton("BACK");
        b2.setBounds(700, 415, 150, 35);
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
            if (e.getSource() == b1) {
                if (amount.equals("") || !isNumeric(amount)) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid amount to deposit");
                } else {
                    // Format date
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String formattedDate = dateFormat.format(date);

                    // Connect to the database and insert deposit
                    Conn c = new Conn();
                    String query = "INSERT INTO transactions (pin, date, type, amount) " +
                                   "VALUES ('" + pin + "', '" + formattedDate + "', 'Deposit', '" + amount + "')";
                    System.out.println("Executing query: " + query);  // Debugging query
                    c.statement.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully");
                    setVisible(false); // Close deposit screen after deposit
                }
            } else if (e.getSource() == b2) {
                // Go back to the Main screen
                new Main(pin); // Pass pin to Main page
                setVisible(false); // Close the current Deposit screen
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while processing the deposit: " + ex.getMessage());
        }
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str); // Check if input is a valid number
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        new Deposit(""); // Pass a sample pin or use an empty string for testing
    }
}
