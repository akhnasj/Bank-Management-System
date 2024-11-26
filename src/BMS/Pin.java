package BMS;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Pin extends JFrame implements ActionListener{
    JTextField t1, t2;
    JButton change, back;
    String pinno;
    Pin(String pinno){

        this.pinno=pinno;
        
        setSize(1000,800);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.white);

        JLabel label1 = new JLabel("Change Your PIN");
        label1.setBounds(180,50,300,50);
        label1.setFont(new Font(null,Font.BOLD,30));
        add(label1);

        JLabel label2 = new JLabel("New PIN: ");
        label2.setBounds(230,170,200,30);
        label2.setFont(new Font(null,Font.PLAIN,20));
        add(label2);

        JLabel label3 = new JLabel("Re-Enter PIN: ");
        label3.setBounds(230,240,200,30);
        label3.setFont(new Font(null,Font.PLAIN,20));
        add(label3);

        t1 = new JTextField();
        t1.setBounds(400,170,300,30);
        add(t1);

        t2 = new JTextField();
        t2.setBounds(400,230,300,30);
        add(t2);

        change = new JButton("CHANGE");
        change.setBounds(600,500,230,35);
        change.setBackground(Color.BLACK);
        change.setForeground(Color.WHITE);
        change.setFocusable(false);
        change.addActionListener(this);
        add(change);


        back = new JButton("BACK");
        back.setBounds(600,600,230,35);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFocusable(false);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public static void main(String[] args){
        new Pin(" ");
    }

    @Override
    public void actionPerformed(ActionEvent e){
        
        try{
            String p1=t1.getText();
            String p2=t2.getText();

            if(!p1.equals(p2)){
                JOptionPane.showMessageDialog(null, "Enter pin does not match");
                return;
            }
            if(e.getSource()==change){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");

                }else if(t2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter the PIN");

                }else{
                    Conn c = new Conn();
                    //String q1="update bank set pinno = '"+p1+"' where pinno = '"+pinno+"'";
                    String q2 = "update login set pinno = '"+p1+"' where pinno='"+pinno+"'";
                    String q3 = "update signupthree set pinno ='"+p1+"' where pinno='"+pinno+'"';

                    //c.statement.executeUpdate(q1);
                    c.statement.executeUpdate(q2);
                    c.statement.executeUpdate(q3);

                    JOptionPane.showMessageDialog(null, "PIN updated successfully");
                    setVisible(false);
                    new Main(pinno);
                }
            }else if(e.getSource()==back){
                new Main(pinno);
                setVisible(false);
            }
        

        }catch(Exception E){
            E.printStackTrace();
        }
    }
}