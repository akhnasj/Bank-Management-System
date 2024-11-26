package BMS;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Balance extends JFrame implements ActionListener {
    String pin;
    JLabel label2;
    JButton b1;

    Balance(String pin) {
        this.pin = pin; // Store pin number passed to this constructor

        // Set frame size and layout
        setSize(1550, 1080);
        setLayout(null);
        setLocation(0, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set background image
        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        JLabel l3 = new JLabel(backgroundImage);
        l3.setBounds(0, 0, 1550, 1080); // Ensure full frame coverage
        add(l3);


        // Add label to show the current balance
        JLabel label1 = new JLabel("YOUR CURRENT BALANCE IS: ");
        label1.setForeground(Color.white);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(430, 235, 700, 35);
        l3.add(label1);

        // Label to display the balance amount
        label2 = new JLabel();
        label2.setForeground(Color.white);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(430, 270, 700, 35);
        l3.add(label2);

        // Back button to go to the main screen
        b1 = new JButton("BACK");
        b1.setBounds(700, 357, 150, 35);
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        // Calculate the balance by checking the deposits and withdrawals from the transactions database
        int balance = 0;
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from transactions where pin = '" + pin + "'");
            while (resultSet.next()) {
                if (resultSet.getString("type").equals(("Deposit"))) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Display balance in label2
        label2.setText("₹" + balance);

        // Set layout and frame properties
        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    // Action performed when the back button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            // Navigate back to the main screen
            new Main(pin); // Pass pin to Main screen
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Balance("1234"); // Example PIN number for testing
    }
}
