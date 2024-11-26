package BMS;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pinno;

    FastCash(String pin) {
        this.pinno = pin;

        // Set frame size and layout
        setSize(1550, 1080);
        setLayout(null);
        setLocation(0, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.white);

        // Add background image
        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png")); // Ensure atm.png is in the project directory
        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 1550, 1080);
        add(background);

        JLabel label = new JLabel("SELECT WITHDRAWAL AMOUNT");
        label.setForeground(Color.white);
        label.setBounds(420, 210, 400, 35);
        label.setFont(new Font("System", Font.BOLD, 18));
        label.setForeground(Color.WHITE); // Make text stand out on the background
        background.add(label);

        // Create buttons for different withdrawal amounts
        b1 = new JButton("Rs.100");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65, 125, 128));
        b1.setBounds(350, 280, 230, 50); // Button for Rs.100
        b1.setFont(new Font("System", Font.BOLD, 20));
        b1.addActionListener(this);
        background.add(b1);

        b2 = new JButton("Rs.500");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65, 125, 128));
        b2.setBounds(610, 280, 230, 50); // Button for Rs.500
        b2.setFont(new Font("System", Font.BOLD, 20));
        b2.addActionListener(this);
        background.add(b2);

        b3 = new JButton("Rs.1000");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65, 125, 128));
        b3.setBounds(350, 350, 230, 50); // Button for Rs.1000
        b3.setFont(new Font("System", Font.BOLD, 20));
        b3.addActionListener(this);
        background.add(b3);

        b4 = new JButton("Rs.2000");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65, 125, 128));
        b4.setBounds(610, 350, 230, 50); // Button for Rs.2000
        b4.setFont(new Font("System", Font.BOLD, 20));
        b4.addActionListener(this);
        background.add(b4);

        b5 = new JButton("Rs.5000");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65, 125, 128));
        b5.setBounds(350, 420, 230, 50); // Button for Rs.5000
        b5.setFont(new Font("System", Font.BOLD, 20));
        b5.addActionListener(this);
        background.add(b5);

        b6 = new JButton("Rs.10000");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65, 125, 128));
        b6.setBounds(610, 420, 230, 50); // Button for Rs.10000
        b6.setFont(new Font("System", Font.BOLD, 20));
        b6.addActionListener(this);
        background.add(b6);

        b7 = new JButton("BACK");
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(65, 125, 128));
        b7.setBounds(350, 490, 490, 50); // Exit button in the center
        b7.setFont(new Font("System", Font.BOLD, 20));
        b7.addActionListener(this);
        background.add(b7);

        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b7) {
            setVisible(false);
            new Main(pinno); // Navigate to the Main screen
        } else {
            String amountText = ((JButton) e.getSource()).getText().substring(3); // Extract the amount from button text (e.g., "Rs.100" => "100")
            int amount = Integer.parseInt(amountText);
            Conn c = new Conn();
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = sdf.format(date);
            
            try {
                // Query to get the current balance of the user
                ResultSet resultSet = c.statement.executeQuery("SELECT SUM(CASE WHEN type = 'deposit' THEN amount ELSE -amount END) AS balance FROM transactions WHERE pin = '" + pinno + "'");
                int balance = 0;
                
                if (resultSet.next()) {
                    balance = resultSet.getInt("balance");
                }

                // Check if balance is sufficient for withdrawal
                if (balance < amount) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                // Log the transaction (withdrawal)
                c.statement.executeUpdate("INSERT INTO transactions VALUES ('" + pinno + "','" + formattedDate + "','withdraw','" + amount + "')");

                // Notify user of successful withdrawal
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error during transaction: " + ex.getMessage());
            }

            // After successful transaction, go back to the main screen
            setVisible(false);
            new Main(pinno);
        }
    }


    public static void main(String[] args) {
        new FastCash(" "); // Provide actual pinno here for testing
    }
}
