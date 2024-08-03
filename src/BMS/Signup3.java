package BMS;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Signup3 extends JFrame implements ActionListener {
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6;
    JButton s, c;

    String formNo;

    Signup3(String formNo) {
         // Image 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(30, 15, 100, 100);
        add(image);

        // Page 3
        JLabel l1 = new JLabel("Page 3");
        l1.setFont(new Font("Raleway", Font.BOLD, 18));
        l1.setBounds(380, 30, 400, 40);
        add(l1);

        JLabel l2 = new JLabel("Account Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        l2.setBounds(330, 60, 400, 40);
        add(l2);

        // Form No:
        this.formNo = formNo;

        JLabel l3 = new JLabel("Form No :");
        l3.setFont(new Font("Raleway", Font.BOLD, 14));
        l3.setBounds(700, 10, 100, 30);
        add(l3);

        JLabel l4 = new JLabel();
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(760, 10, 60, 30);
        add(l4);

        // Account Type
        JLabel l5 = new JLabel("Account Type: ");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));
        l5.setBounds(100, 140, 200, 30);
        add(l5);

        r1 = new JRadioButton("Savings");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(new Color(215, 252, 252));
        r1.setBounds(100, 180, 150, 30);
        add(r1);

        r2 = new JRadioButton("Current");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(new Color(215, 252, 252));
        r2.setBounds(350, 180, 150, 30);
        add(r2);

        r3 = new JRadioButton("Fixed Deposit");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(new Color(215, 252, 252));
        r3.setBounds(100, 220, 150, 30);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(new Color(215, 252, 252));
        r4.setBounds(350, 220, 200, 30);
        add(r4);

        ButtonGroup acc = new ButtonGroup();
        acc.add(r1);
        acc.add(r2);
        acc.add(r3);
        acc.add(r4);

        // Card Number
        JLabel l6 = new JLabel("Card Number: ");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));
        l6.setBounds(100, 300, 200, 30);
        add(l6);

        JLabel l7 = new JLabel("(Your 16-digit Card Number)");
        l7.setFont(new Font("Raleway", Font.BOLD, 12));
        l7.setBounds(100, 330, 200, 20);
        add(l7);
        
        JLabel l8 = new JLabel("XXXX-XXXX-XXXX-4841");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(330, 300, 250, 30);
        add(l8);
        
        JLabel l9 = new JLabel("(It would appear on atm card/cheque Book and Statements)");
        l9.setFont(new Font("Raleway", Font.BOLD, 12));
        l9.setBounds(330, 330, 500, 20);
        add(l9);

        // PIN
        JLabel l10 = new JLabel("PIN:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        l10.setBounds(100, 370, 200, 20);
        add(l10);

        JLabel l11 = new JLabel("(4-digit password)");
        l11.setFont(new Font("Raleway", Font.BOLD, 12));
        l11.setBounds(100, 400, 200, 20);
        add(l11);

        JLabel l12 = new JLabel("XXXX");
        l12.setFont(new Font("Raleway", Font.BOLD, 18));
        l12.setBounds(330, 370, 200, 20);
        add(l12);

        // Services Required
        JLabel l13 = new JLabel("Services Required:");
        l13.setFont(new Font("Raleway", Font.BOLD, 18));
        l13.setBounds(100, 450, 200, 20);
        add(l13);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(new Color(215, 252, 252));
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(new Color(215, 252, 252));
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(new Color(215, 252, 252));
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("E-mail Alerts");
        c4.setBackground(new Color(215, 252, 252));
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(new Color(215, 252, 252));
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(new Color(215, 252, 252));
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 600, 200, 30);
        add(c6);

        JCheckBox c7 = new JCheckBox("I, hereby, declare that the above entered details are correct to the best of my knowledge.",true);
        c7.setBackground(new Color(215, 252, 252));
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 650, 800, 20);
        add(c7);

        // Submit
        s = new JButton("SUBMIT");
        s.setFont(new Font("Raleway", Font.BOLD, 14));
        s.setBackground(Color.BLACK);
        s.setForeground(Color.WHITE);
        s.setBounds(250, 690, 100, 30);
        s.addActionListener(this);
        add(s);

        // Cancel
        c = new JButton("CANCEL");
        c.setFont(new Font("Raleway", Font.BOLD, 14));
        c.setBackground(Color.BLACK);
        c.setForeground(Color.WHITE);
        c.setBounds(420, 690, 100, 30);
        c.addActionListener(this);
        add(c);

        getContentPane().setBackground(new Color(215, 252, 252));
        setSize(850, 800);
        setLayout(null);
        setLocation(350, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String acctype = null;
       if (r1.isSelected()){
            acctype = "Savings"; 
       }else if (r2.isSelected()){
            acctype = "Current";
       }else if (r3.isSelected()){
            acctype = "Fixed Deposit";
       }else if (r4.isSelected()){
            acctype = "Recurring Deposit";
       }

       Random ran = new Random();
       long first7 = (ran.nextLong() % 90000000L) + 1409963000000000L;
       String cardNo = "" + Math.abs(first7);

       long first3 = (ran.nextLong() % 9000L) + 1000L;
       String pin = "" + Math.abs(first3);

       String service = "";
       if (c1.isSelected()){
            service += "ATM Card";
       }else if (c2.isSelected()){
            service += "Internet Banking";
       }else if (c3.isSelected()){
            service += "Mobile Banking";
       }else if (c4.isSelected()){
            service += "E-mail Alerts";
       }else if (c5.isSelected()){
            service += "Cheque Book";
       }else if (c6.isSelected()){
            service += "E-Statement";
       }

       try{
            if (e.getSource() == s){
                if (acctype.equals("")){
                        JOptionPane.showMessageDialog(null, "Fill all the fields");
                }else { 
                    Conn c1 = new Conn();
                    String q1 = "insert into signup_three values ('"+formNo+"', '"+acctype+"', '"+cardNo+"', '"+pin+"', '"+service+"')";
                    String q2 = "insert into login values ('"+formNo+"', '"+cardNo+"', '"+pin+"')";
                    c1.statement.executeUpdate(q1);
                    c1.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number : "+cardNo+"\n Pin : "+pin);
                    new Deposit(pin);
                    setVisible(false);
                }
            }else if (e.getSource() == c){
                System.exit(0);
            }
       }catch (Exception E){
            E.printStackTrace();
       }

    }

    public static void main(String[] args) {
        new Signup3("");
    }
}
