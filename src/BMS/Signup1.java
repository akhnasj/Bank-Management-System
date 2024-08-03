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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class Signup1 extends JFrame implements ActionListener {

    JRadioButton r1, r2, ms1, ms2, ms3;
    JButton next;
    JTextField textName, textFname, textEmail, textAdd, textCity, textPin, textState;
    JDateChooser dateChooser;

    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);

    Signup1(){
        super("Application Form"); 

        // Image 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25, 10, 100, 100);
        add(image);

        // Application Form
        JLabel label1 = new JLabel("APPLICATION FORM NO. " + first);
        label1.setBounds(160, 20, 600, 40);
        label1.setFont(new Font("Raleway", Font.BOLD, 34));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setBounds(350, 70, 600, 30);
        label2.setFont(new Font("Raleway", Font.BOLD, 22));
        add(label2);
        
        JLabel label3 = new JLabel("Personal Details");
        label3.setBounds(300, 100, 600, 30);
        label3.setFont(new Font("Raleway", Font.BOLD, 22));
        add(label3);


        // Name
        JLabel labelName = new JLabel("Name :");
        labelName.setBounds(100, 190, 100, 30);
        labelName.setFont(new Font("Raleway", Font.BOLD, 18));
        add(labelName);

        textName = new JTextField();
        textName.setBounds(300, 190, 400, 30);
        textName.setFont(new Font("Raleway", Font.BOLD, 14));
        add(textName);

        // Father's Name
        JLabel labelFname = new JLabel("Father's Name :");
        labelFname.setBounds(100, 240, 200, 30);
        labelFname.setFont(new Font("Raleway", Font.BOLD, 18));
        add(labelFname);

        textFname = new JTextField();
        textFname.setBounds(300, 240, 400, 30);
        textFname.setFont(new Font("Raleway", Font.BOLD, 14));
        add(textFname);

        // DOB
        JLabel DOB = new JLabel("Date of Birth :");
        DOB.setBounds(100, 340, 200, 30);
        DOB.setFont(new Font("Raleway", Font.BOLD, 18));
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105 ));
        dateChooser.setBounds(300, 340, 400, 30);
        add(dateChooser);  

        // Gender
        JLabel labelG = new JLabel("Gender :");
        labelG.setBounds(100, 290, 200, 30);
        labelG.setFont(new Font("Raleway", Font.BOLD, 18));
        add(labelG);

        r1 = new JRadioButton("Male");
        r1.setBounds(300, 290, 90, 30);
        r1.setBackground(new Color(222, 255, 228));
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(450, 290, 90, 30);
        r2.setBackground(new Color(222, 255, 228));
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        add(r2);

        ButtonGroup g = new ButtonGroup();
        g.add(r1);
        g.add(r2);

        // E-mail
        JLabel labelEmail = new JLabel("E-mail address :");
        labelEmail.setBounds(100, 390, 200, 30);
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 18));
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setBounds(300, 390, 400, 30);
        textEmail.setFont(new Font("Raleway", Font.BOLD, 14));
        add(textEmail);

        // Marital Status
        JLabel labelMS = new JLabel("Marital Status :");
        labelMS.setBounds(100, 440, 400, 30);
        labelMS.setFont(new Font("Raleway", Font.BOLD, 18));
        add(labelMS);

        ms1 = new JRadioButton("Married");
        ms1.setBounds(300, 440, 100, 30);
        ms1.setBackground(new Color(222, 255, 228));
        ms1.setFont(new Font("Raleway", Font.BOLD, 14));
        add(ms1);

        ms2 = new JRadioButton("Unmarried");
        ms2.setBounds(440, 440, 120, 30);
        ms2.setBackground(new Color(222, 255, 228));
        ms2.setFont(new Font("Raleway", Font.BOLD, 14));
        add(ms2);

        ms3 = new JRadioButton("Others");
        ms3.setBounds(600, 440, 90, 30);
        ms3.setBackground(new Color(222, 255, 228));
        ms3.setFont(new Font("Raleway", Font.BOLD, 14));
        add(ms3);

        ButtonGroup ms = new ButtonGroup();
        ms.add(ms1);
        ms.add(ms2);
        ms.add(ms3);

        // Address
        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setBounds(100, 490, 400, 30);
        labelAdd.setFont(new Font("Raleway", Font.BOLD, 18));
        add(labelAdd);

        textAdd = new JTextField();
        textAdd.setBounds(300, 490, 400, 30);
        textAdd.setFont(new Font("Raleway", Font.BOLD, 14));
        add(textAdd);

        // City
        JLabel labelCity = new JLabel("City :");
        labelCity.setBounds(100, 540, 400, 30);
        labelCity.setFont(new Font("Raleway", Font.BOLD, 18));
        add(labelCity);

        textCity = new JTextField();
        textCity.setBounds(300, 540, 400, 30);
        textCity.setFont(new Font("Raleway", Font.BOLD, 14));
        add(textCity);

        // Pin Code
        JLabel labelPin = new JLabel("Pin Code :");
        labelPin.setBounds(100, 590, 400, 30);
        labelPin.setFont(new Font("Raleway", Font.BOLD, 18));
        add(labelPin);

        textPin = new JTextField();
        textPin.setBounds(300, 590, 400, 30);
        textPin.setFont(new Font("Raleway", Font.BOLD, 14));
        add(textPin);

        // State
        JLabel labelState = new JLabel("State :");
        labelState.setBounds(100, 640, 400, 30);
        labelState.setFont(new Font("Raleway", Font.BOLD, 18));
        add(labelState);

        textState = new JTextField();
        textState.setBounds(300, 640, 400, 30);
        textState.setFont(new Font("Raleway", Font.BOLD, 14));
        add(textState);

        // Next
        next = new JButton("NEXT");
        next.setBounds(370, 700, 80, 30);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 15);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formNo = first;
        String name = textName.getText();
        String fname = textFname.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        
        String gender = null;
        if (r1.isSelected()){
            gender = "Male";
        }else if (r2.isSelected()){
            gender = "Female";
        }

        String email = textEmail.getText();
        
        String ms = null;
        if (ms1.isSelected()){
            ms = "Married";
        }else if (ms2.isSelected()){
            ms = "Unmarried";
        }else if (ms3.isSelected()){
            ms = "Others";
        }

        String address = textAdd.getText();        
        String city = textCity.getText();
        String pincode = textPin.getText();
        String state = textState.getText();

        try{
            if (textName.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            }else {
                Conn conn1 = new Conn();
                String q = "insert into signup_one values('"+formNo+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+ms+"', '"+address+"', '"+city+"', '"+pincode+"', '"+state+"')";
                conn1.statement.executeUpdate(q);
                new Signup2(first);
                setVisible(false);
            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup1();
    }
}
