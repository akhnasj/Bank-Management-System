package BMS;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5, b6, b7;
    String pinno;

    Main(String pin) {

        super("Transactions");
        this.pinno = pin;

        // Set frame size and layout
        setSize(1550, 1080);
        setLayout(null);
        setLocation(0, 0);

        // Add background image
        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png")); // Ensure atm.png is in the project directory
        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 1550, 1080);
        add(background);

        // Label for asking transactions
        JLabel label1 = new JLabel("PLEASE SELECT YOUR TRANSACTIONS");
        label1.setForeground(Color.white);
        label1.setBounds(420, 210, 400, 35);
        label1.setFont(new Font("System", Font.BOLD, 18));
        label1.setForeground(Color.WHITE); // Make text stand out on the background
        background.add(label1);

        // First row of buttons (Deposit, Withdraw, Fast Cash)
        b1 = new JButton("DEPOSIT");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65, 125, 128));
        b1.setBounds(350, 280, 230, 50); // Button for deposit
        b1.setFont(new Font("System", Font.BOLD, 20));
        b1.addActionListener(this);
        background.add(b1);

        b2 = new JButton("WITHDRAW");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65, 125, 128));
        b2.setBounds(610, 280, 230, 50); // Button for withdraw
        b2.setFont(new Font("System", Font.BOLD, 20));
        b2.addActionListener(this);
        background.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65, 125, 128));
        b3.setBounds(350, 350, 230, 50); // Button for fast cash
        b3.setFont(new Font("System", Font.BOLD, 20));
        b3.addActionListener(this);
        background.add(b3);

        b4 = new JButton("PIN CHANGE");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65, 125, 128));
        b4.setBounds(610, 350, 230, 50); // Button for pin change
        b4.setFont(new Font("System", Font.BOLD, 20));
        b4.addActionListener(this);
        background.add(b4);

        b5 = new JButton("BALANCE");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65, 125, 128));
        b5.setBounds(350, 420, 230, 50); // Button for balance enquiry
        b5.setFont(new Font("System", Font.BOLD, 20));
        b5.addActionListener(this);
        background.add(b5);

        // Second row of buttons (Mini Statement, Balance, PIN Change)
        b6 = new JButton("MINI STATEMENT");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65, 125, 128));
        b6.setBounds(610, 420, 230, 50); // Button for mini statement
        b6.setFont(new Font("System", Font.BOLD, 20));
        b6.addActionListener(this);
        background.add(b6);

        // Button for exit placed at the bottom of the screen
        b7 = new JButton("EXIT");
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(65, 125, 128));
        b7.setBounds(350, 490, 490, 50); // Exit button in the center
        b7.setFont(new Font("System", Font.BOLD, 20));
        b7.addActionListener(this);
        background.add(b7);

        // Make frame visible
        setVisible(true);
    }

    // Button styling helper method
    private void styleButton(JButton button) {
        button.setFocusable(false);
        button.setFont(new Font("System", Font.PLAIN, 20));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b7) {
            System.exit(0); // Exit action
        }else if (e.getSource() == b1) {
            new Deposit(pinno); // Go to Deposit screen
            setVisible(false);
        }else if (e.getSource() == b2) {
            new Withdraw(pinno); // Go to Withdraw screen
            setVisible(false);
        } else if (e.getSource() == b3) {
            new FastCash(pinno); // Go to Fast Cash screen
            setVisible(false);
        } else if (e.getSource() == b4) {
            new Pin(pinno); // Go to PIN change screen
            setVisible(false);
        }else if (e.getSource() == b5) {
            new Balance(pinno); // Go to Balance screen
            setVisible(false);
        }else if (e.getSource() == b6) {
            new MiniStatement(pinno); // Go to Mini Stateme screen
            setVisible(false);
        } 
    }

    public static void main(String[] args) {
        new Main(" ");
    }
}
