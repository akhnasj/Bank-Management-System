package BMS;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MiniStatement extends JFrame implements ActionListener {
    String pinno;
    JButton b1;

    MiniStatement(String pin) {
        this.pinno = pin;

        // Set frame size and layout
        setSize(1550, 1080);
        setLayout(null);
        setLocation(0, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add background image
        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png")); // Ensure atm.png is in the project directory
        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 1550, 1080); // Adjust to the frame size
        add(background);

        // Title label for the mini statement
        JLabel titleLabel = new JLabel("MINI STATEMENT");
        titleLabel.setFont(new Font("System", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(500, 190, 200, 30);
        background.add(titleLabel);

        // Card number label with masked digits
        JLabel cardNumberLabel = new JLabel();
        cardNumberLabel.setBounds(350, 220, 500, 20);
        cardNumberLabel.setFont(new Font("System", Font.BOLD, 15));
        cardNumberLabel.setForeground(Color.WHITE);
        background.add(cardNumberLabel);

        // Transaction history title
        JLabel transactionsTitle = new JLabel("Transaction History: ");
        transactionsTitle.setBounds(350, 235, 200, 20);
        transactionsTitle.setFont(new Font("System", Font.BOLD, 15));
        transactionsTitle.setForeground(Color.WHITE);
        background.add(transactionsTitle);

        // Text area to show transaction history
        JTextArea transactionArea = new JTextArea();
        transactionArea.setEditable(false);
        transactionArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        transactionArea.setBackground(new Color(240, 240, 240));
        transactionArea.setForeground(Color.BLACK);

        // Scroll for the text area
        JScrollPane scrollPane = new JScrollPane(transactionArea);
        scrollPane.setBounds(350, 260, 500, 290);
        background.add(scrollPane);

        // Label to display the balance
        JLabel balanceLabel = new JLabel();
        balanceLabel.setBounds(50, 460, 500, 20);
        balanceLabel.setFont(new Font("System", Font.BOLD, 15));
        balanceLabel.setForeground(Color.WHITE);
        background.add(balanceLabel);

        // Back/Exit Button
        b1 = new JButton("EXIT");
        b1.setBounds(550, 560, 100, 30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65, 125, 128));
        b1.setFont(new Font("System", Font.BOLD, 20));
        b1.setFocusable(false);
        b1.addActionListener(this);
        background.add(b1);

        // Retrieve and display the card number
        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM login WHERE pinno = '" + pinno + "'");
            while (rs.next()) {
                String cardNumber = rs.getString("cardno");
                // Masking the card number
                String maskedCardNumber = cardNumber.substring(0, 4) + "XXXXXXXX" + cardNumber.substring(12);
                cardNumberLabel.setText("Card Number: " + maskedCardNumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Retrieve and display transaction history and balance
        try {
            int balance = 0;
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM transactions WHERE pinno = '" + pinno + "'");

            // Iterate over the result set and build the transaction history
            while (resultSet.next()) {
                String transaction = resultSet.getString("date") + "   " +
                        resultSet.getString("type") + "   " +
                        resultSet.getString("amount");
                transactionArea.append(transaction + "\n");

                // Update balance based on transaction type (Deposit or Withdrawal)
                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }

            balanceLabel.setText("Your Total Balance is Rs. " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Make the frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            // Close the MiniStatement window and go back to the Main screen
            new Main(pinno);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new MiniStatement(""); // Example pin number for testing
    }
}
