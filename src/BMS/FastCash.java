package BMS;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements  ActionListener{
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pinno;

    FastCash(String pinno){
        this.pinno=pinno;

        setSize(1000,800);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setBackground(Color.white);

        JLabel label = new JLabel("SELECT WITHDRAWAL AMOUNT");
        label.setBounds(230,80,700,35);
        label.setBackground(Color.BLACK);
        label.setFont(new Font("System",Font.BOLD,28));
        add(label);

        b1 = new JButton("Rs.100");
        b1.setBounds(100,250,230,35);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFocusable(false);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Rs.500");
        b2.setBounds(530,250,230,35);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFocusable(false);
        b2.addActionListener(this);
        add(b2);


        b3 = new JButton("Rs.1000");
        b3.setBounds(100,350,230,35);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setFocusable(false);
        b3.addActionListener(this);
        add(b3);

        b4 = new JButton("Rs.2000");
        b4.setBounds(530,350,230,35);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setFocusable(false);
        b4.addActionListener(this);
        add(b4);


        b5 = new JButton("Rs.5000");
        b5.setBounds(100,450,230,35);
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setFocusable(false);
        b5.addActionListener(this);
        add(b5);


        b6 = new JButton("Rs.10000");
        b6.setBounds(530,450,230,35);
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.setFocusable(false);
        b6.addActionListener(this);
        add(b6);

        b7 = new JButton("BACK");
        b7.setBounds(530,550,230,35);
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.setFocusable(false);
        b7.addActionListener(this);
        add(b7);

        setLayout(null);
        setVisible(true);

    }

    @Override
   public void  actionPerformed(ActionEvent e){
    if(e.getSource()==b7){
        setVisible(false);
        new Main(pinno);
    }else {
        String amount = ((JButton)e.getSource()).getText().substring(4);//e.getSource returns an object
        Conn c= new Conn();
        Date date = new Date();
        try{

            ResultSet resultSet = c.statement.executeQuery("select * from bank where pinno = '"+pinno+"'");
            int balance =0;
            while(resultSet.next()){
                if(resultSet.getString("type").equals("Deposit")){

                    balance+=Integer.parseInt(resultSet.getString("amount"));

                }else{
                    balance-=Integer.parseInt(resultSet.getString("amount"));

                }
            }
            String num = "17";

            if(e.getSource()!=b7 && balance < Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;

            }

            c.statement.executeUpdate("insert into bank values('"+pinno+"','"+date+"','withdrawal','"+amount+"')");

            JOptionPane.showMessageDialog(null, "Rs. "+amount+ "Debited Successfully");
        
        }
    catch(Exception E){
            E.printStackTrace();
        }

        setVisible(false);
        new Main(pinno);

    }

   }


   public static void main(String[] args){
    new FastCash(" ");

   }
    
}