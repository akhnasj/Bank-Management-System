package BMS;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Pin extends JFrame implements ActionListener {
    JTextField t1, t2;
    JButton change, back;
    String pinno;

    Pin(String pin) {
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

        JLabel label1 = new JLabel("Change Your PIN");
        label1.setForeground(Color.white);
        label1.setBounds(500, 210, 400, 35);
        label1.setFont(new Font("System", Font.BOLD, 20));
        label1.setForeground(Color.WHITE); // Make text stand out on the background
        background.add(label1);

        JLabel label2 = new JLabel("New PIN: ");
        label2.setBounds(350, 280, 230, 50); 
        label2.setForeground(Color.white);
        label2.setFont(new Font("System", Font.BOLD, 18));
        label2.setForeground(Color.WHITE); // Make text stand out on the background
        background.add(label2);

        JLabel label3 = new JLabel("Re-Enter PIN: ");
        label3.setForeground(Color.white);
        label3.setBounds(350, 350, 230, 50); 
        label3.setFont(new Font("System", Font.BOLD, 18));
        label3.setForeground(Color.WHITE); // Make text stand out on the background
        background.add(label3);

        t1 = new JTextField();
        t1.setBackground(new Color(65, 125, 128));
        t1.setForeground(Color.WHITE);
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        t1.setBounds(520, 290, 320, 37);
        background.add(t1); // Add to the background instead of JFrame

        t2 = new JTextField();
        t2.setBackground(new Color(65, 125, 128));
        t2.setForeground(Color.WHITE);
        t2.setFont(new Font("Raleway", Font.BOLD, 22));
        t2.setBounds(520, 360, 320, 37);
        background.add(t2); // Add to the background instead of JFrame

        change = new JButton("CHANGE");
        change.setBounds(470, 455, 230, 35);
        change.setForeground(Color.WHITE);
        change.setBackground(new Color(65, 125, 128));
        change.setFont(new Font("System", Font.BOLD, 20));
        change.setFocusable(false);
        change.addActionListener(this);
        background.add(change); // Add to the background instead of JFrame

        back = new JButton("BACK");
        back.setBounds(470, 510, 230, 35);
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(65, 125, 128));
        back.setFont(new Font("System", Font.BOLD, 20));
        back.setFocusable(false);
        back.addActionListener(this);
        background.add(back); // Add to the background instead of JFrame

        setVisible(true);
    }

    public static void main(String[] args) {
        new Pin(" "); // Pass a sample pin or use an empty string for testing
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String p1 = t1.getText();
            String p2 = t2.getText();

            // Check if PIN fields are empty
            if (p1.equals("") || p2.equals("")) {
                JOptionPane.showMessageDialog(null, "Both fields are required to change the PIN.");
                return;
            }

            // Check if both PINs match
            if (!p1.equals(p2)) {
                JOptionPane.showMessageDialog(null, "Entered PINs do not match.");
                return;
            }

            if (e.getSource() == change) {
                // Ensure PIN is valid (e.g., length or numeric check can be added here)
                if (p1.length() != 4) {
                    JOptionPane.showMessageDialog(null, "PIN should be 4 digits long.");
                    return;
                }

                // Update PIN in the database
                Conn c = new Conn();
                String q2 = "UPDATE login SET pinno = '" + p1 + "' WHERE pinno = '" + pinno + "'";
                String q3 = "UPDATE signupthree SET pinno = '" + p1 + "' WHERE pinno = '" + pinno + "'";

                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN updated successfully.");
                setVisible(false); // Close current window
                new Main(pinno); // Navigate to the main screen with updated PIN
            } else if (e.getSource() == back) {
                new Main(pinno); // Go back to the main screen
                setVisible(false); // Close current window
            }

        } catch (Exception E) {
            E.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while updating the PIN.");
        }
    }
}
