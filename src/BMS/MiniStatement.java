package BMS;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame implements ActionListener{
    String pinno;
    JButton b1;

    MiniStatement(String pinno){
    
        this.pinno = pinno;

        setSize(400,600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      

        JLabel label1 = new JLabel();
        label1.setBounds(20,140,400,20);
        add(label1);

        JLabel label2 = new JLabel();
        label2.setBounds(150,20,200,20);
        label2.setFont(new Font("System",Font.BOLD,15));
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(150,80,300,20);
        label3.setFont(new Font("System",Font.BOLD,15));
        add(label3);

        JLabel label4 = new JLabel();
        label4.setBounds(20,400,300,20);
        label4.setFont(new Font("System",Font.BOLD,15));
        add(label4);

        try{ 
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from login where pinno='"+pinno+"'");
            while(rs.next()){
                label3.setText("CardNumber: "+rs.getString("cardno".substring(0,4) +"XXXXXXXXX"+rs.getString("cardno").substring(12)));
            }

        }catch(Exception E){

        }

        try{

            int balance = 0;
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pinno = '"+pinno+"'");
            
            while(resultSet.next()){
                label1.setText(label1.getText() + "<html>" +resultSet.getString("date") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+ "<br><br><br></html>");

                if(resultSet.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(resultSet.getString("amount"));
                }else{
                    balance-=Integer.parseInt(resultSet.getString("amount"));
                }
            }

            label4.setText("Your Total Balance is Rs. "+balance);

        }catch(Exception e){
            e.printStackTrace();
        }

        b1 = new JButton("Exit");
        b1.setBounds(20,500,100,25);
        add(b1);

        setLayout(null);
        setVisible(true);       
    }

    public static void main(String[] args){
        new MiniStatement(" ");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
}