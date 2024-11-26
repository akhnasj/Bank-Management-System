package BMS;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1, button2, button3;

    Login() {
        super("Bank Management System");

        // Set up the image and logo on the login page
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(360, 10, 100, 100);
        add(image);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icons/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(630, 350, 100, 100);
        add(iimage);

        // Welcome message
        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.DARK_GRAY);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 38));
        label1.setBounds(230, 125, 450, 40);
        add(label1);

        // Card number input
        label2 = new JLabel("Card Number: ");
        label2.setForeground(Color.DARK_GRAY);
        label2.setFont(new Font("Ralway", Font.BOLD, 18));
        label2.setBounds(150, 200, 375, 30);
        add(label2);

        textField2 = new JTextField(15);
        textField2.setBounds(325, 200, 230, 30);
        textField2.setFont(new Font("Arial", Font.BOLD, 16));
        add(textField2);

        // PIN input
        label3 = new JLabel("PIN: ");
        label3.setForeground(Color.DARK_GRAY);
        label3.setFont(new Font("Ralway", Font.BOLD, 18));
        label3.setBounds(151, 250, 375, 30);
        add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(325, 250, 230, 30);
        passwordField3.setFont(new Font("Arial", Font.BOLD, 16));
        add(passwordField3);

        // Sign in button
        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(300, 300, 100, 30);
        button1.addActionListener(this);
        add(button1);

        // Clear button
        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial", Font.BOLD, 14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(430, 300, 100, 30);
        button2.addActionListener(this);
        add(button2);

        // Sign up button
        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial", Font.BOLD, 14));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(300, 350, 230, 30);
        button3.addActionListener(this);
        add(button3);

        // Background image
        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icons/bg.jpg"));
        Image iii2 = iii1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0, 0, 850, 480);
        add(iiimage);

        setLayout(null);
        setSize(850, 480);
        setLocation(300, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == button1) {
                Conn c = new Conn();
                String cardno = textField2.getText();
                String pin = passwordField3.getText();

                // Use prepared statement to avoid SQL injection
                String query = "SELECT * FROM login WHERE card_no = ? AND pin = ?";
                PreparedStatement stmt = c.connection.prepareStatement(query);
                stmt.setString(1, cardno);
                stmt.setString(2, pin);

                ResultSet resultset = stmt.executeQuery();

                if (resultset.next()) {
                    setVisible(false);
                    new Main(pin); // Navigate to Main class with pin
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Card Number or PIN", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (e.getSource() == button2) {
                textField2.setText("");
                passwordField3.setText("");
            } else if (e.getSource() == button3) {
                new Signup1();
                setVisible(false);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
