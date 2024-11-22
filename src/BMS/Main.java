import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame implements ActionListener{

    JButton b1,b2,b3,b4,b5,b6,b7;
    String pinno;

    Main(String pinno2){

        super("Transactions");
        this.pinno=pinno2;
        /*label for asking transactions */
        JLabel label1 = new JLabel("PLEASE SELECT YOUR TRANSACTIONS");
        label1.setBounds(360,20,800,60);
        label1.setFont(new Font("System",Font.BOLD,40));
        add(label1);


        /*button for deposit */
        b1=new JButton("DEPOSIT");
        b1.setBounds(170,200,450,50);
        b1.setFocusable(false);
        b1.setFont(new Font("System",Font.PLAIN,20));
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        add(b1);

        /*button for cashwithdraw */
        b2 = new JButton("WITHDRAW");
        b2.setBounds(750,200,450,50);
        b2.setFocusable(false);
        b2.setFont(new Font("System",Font.PLAIN,20));
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        add(b2);


        /*button for FastCash */
        b3 = new JButton("FAST CASH");
        b3.setBounds(170,330,450,50);
        b3.setFocusable(false);
        b3.setFont(new Font("System",Font.PLAIN,20));
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.addActionListener(this);
        add(b3);

        /*button for mini statement */
        b4 = new JButton("MINI STATEMENT");
        b4.setBounds(750,330,450,50);
        b4.setFocusable(false);
        b4.setFont(new Font("System",Font.PLAIN,20));
        b4.setForeground(Color.WHITE);
        b4.setBackground(Color.BLACK);
        add(b4);


        /*button for balance enquiry */
        b5 = new JButton("BALANCE");
        b5.setBounds(170,460,450,50);
        b5.setFocusable(false);
        b5.setFont(new Font("System",Font.PLAIN,20));
        b5.setForeground(Color.WHITE);
        b5.setBackground(Color.BLACK);
        add(b5);

        /*button for PIN change */
        b6 = new JButton("PIN CHANGE");
        b6.setBounds(750,460,450,50);
        b6.setFocusable(false);
        b6.setFont(new Font("System",Font.PLAIN,20));
        b6.setForeground(Color.WHITE);
        b6.setBackground(Color.BLACK);
        b6.addActionListener(this);
        add(b6);

        /*button for exit */
        b7 = new JButton("EXIT");
        b7.setBounds(750,580,450,50);
        b7.setFocusable(false);
        b7.setFont(new Font("System",Font.PLAIN,20));
        b7.setForeground(Color.WHITE);
        b7.setBackground(Color.BLACK);
        b7.addActionListener(this);
        add(b7);



        /*frame settings */
        setSize(1550,1080);
        setLayout(null);
        setLocation(0,0);
        setVisible(true);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==b7){
            System.exit(0);
        }else if(e.getSource()==b6){
            new Pin(pinno);
            setVisible(false);
        }else if(e.getSource()==b3){
            new Fastcash(pinno);
            setVisible(false);
        }
    }

public static void main(String[] args){
    new Main(" ");
}
}