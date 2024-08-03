package BMS;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Signup2 extends JFrame implements ActionListener {
    JComboBox comboBox1, comboBox2, comboBox3, comboBox4, comboBox5;
    JTextField textPAN, textAadhar;
    JRadioButton r1, r2, e1, e2;
    JButton next;

    String formNo;
    Signup2(String first) {
        super("APPLICATION FORM");
        
         // Image 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(30, 15, 100, 100);
        add(image);

        this.formNo = first;

        // Page 2
        JLabel l1 = new JLabel("Page 2");
        l1.setFont(new Font("Raleway", Font.BOLD, 18));
        l1.setBounds(380, 30, 600, 40);
        add(l1);

        JLabel l2 = new JLabel("Additional Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        l2.setBounds(330, 60, 600, 40);
        add(l2);

        // Form No:
        JLabel l3 = new JLabel("Form No :");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(700, 10, 100, 30);
        add(l3);

        JLabel l4 = new JLabel(formNo);
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(760, 10, 60, 30);
        add(l4);

        // Religion
        JLabel l5 = new JLabel("Religion :");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));
        l5.setBounds(100, 140, 100, 30);
        add(l5);

        String[] Religion = {"Hindu", "Muslim", "Sikh", "Christian", "Others"};
        comboBox1 = new JComboBox<>(Religion);
        comboBox1.setBackground(new Color(252, 208, 76));
        comboBox1.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox1.setBounds(350, 140, 320, 30);
        add(comboBox1);

        // Category
        JLabel l6 = new JLabel("Category :");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));
        l6.setBounds(100, 190, 100, 30);
        add(l6);

        String[] Category = {"General", "OBC", "SC", "ST", "Others"};
        comboBox2 = new JComboBox<>(Category);
        comboBox2.setBackground(new Color(252, 208, 76));
        comboBox2.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox2.setBounds(350, 190, 320, 30);
        add(comboBox2);

        // Income
        JLabel l7 = new JLabel("Income :");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        l7.setBounds(100, 240, 100, 30);
        add(l7);

        String[] Income = {"NULL", "<1,50,00", "<2,50,00", "<5,00,00", "<10,00,000", "Above 10,00,000"};
        comboBox3 = new JComboBox<>(Income);
        comboBox3.setBackground(new Color(252, 208, 76));
        comboBox3.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox3.setBounds(350, 240, 320, 30);
        add(comboBox3);

        // Educational Details
        JLabel l8 = new JLabel("Education :");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(100, 290, 150, 30);
        add(l8);

        String[] Education = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        comboBox4 = new JComboBox<>(Education);
        comboBox4.setBackground(new Color(252, 208, 76));
        comboBox4.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox4.setBounds(350, 290, 320, 30);
        add(comboBox4);

        // Occupation
        JLabel l9 = new JLabel("Occupation :");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));
        l9.setBounds(100, 340, 150, 30);
        add(l9);

        String[] Occupation = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        comboBox5 = new JComboBox<>(Occupation);
        comboBox5.setBackground(new Color(252, 208, 76));
        comboBox5.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox5.setBounds(350, 340, 320, 30);
        add(comboBox5);

        // PAN Number
        JLabel l10 = new JLabel("PAN Number :");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        l10.setBounds(100, 390, 150, 30);
        add(l10);

        textPAN = new JTextField();
        textPAN.setFont(new Font("Raleway", Font.BOLD, 14));
        textPAN.setBounds(350, 390, 320, 30);
        add(textPAN);

        // Aadhar Number
        JLabel l11 = new JLabel("Aadhar Number :");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));
        l11.setBounds(100, 440, 150, 30);
        add(l11);

        textAadhar = new JTextField();
        textAadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        textAadhar.setBounds(350, 440, 320, 30);
        add(textAadhar);
         
        // Senior Citizen
        JLabel l12 = new JLabel("Senior Citizen :");
        l12.setFont(new Font("Raleway", Font.BOLD, 18));
        l12.setBounds(100, 490, 150, 30);
        add(l12);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(new Color(252, 208, 76));
        r1.setBounds(350, 490, 100, 30);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(new Color(252, 208, 76));
        r2.setBounds(460, 490, 100, 30);
        add(r2);

        ButtonGroup sc = new ButtonGroup();
        sc.add(r1);
        sc.add(r2);

        // Existing Account
        JLabel l13 = new JLabel("Existing Account :");
        l13.setFont(new Font("Raleway", Font.BOLD, 18));
        l13.setBounds(100, 540, 180, 30);
        add(l13);

        e1 = new JRadioButton("Yes");
        e1.setFont(new Font("Raleway", Font.BOLD, 14));
        e1.setBackground(new Color(252, 208, 76));
        e1.setBounds(350, 540, 100, 30);
        add(e1);

        e2 = new JRadioButton("No");
        e2.setFont(new Font("Raleway", Font.BOLD, 14));
        e2.setBackground(new Color(252, 208, 76));
        e2.setBounds(460, 540, 100, 30);
        add(e2);

        ButtonGroup ea = new ButtonGroup();
        ea.add(e1);
        ea.add(e2);

        // Next
        next = new JButton("NEXT");
        next.setBounds(370, 620, 80, 30);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        
        setLayout(null);
        setSize(850, 750);
        setLocation(350, 40);
        getContentPane().setBackground(new Color(252, 208, 76));
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String religion = (String) comboBox1.getSelectedItem();
        String category = (String) comboBox2.getSelectedItem();
        String income = (String) comboBox3.getSelectedItem();
        String education = (String) comboBox4.getSelectedItem();
        String occupation = (String) comboBox5.getSelectedItem();

        String PAN = textPAN.getText();
        String aadhar = textAadhar.getText();

        String sc = "";
        if(r1.isSelected()){
            sc = "Yes";
        }else if (r2.isSelected()){
            sc = "No";
        }

        String ea = "";
        if(e1.isSelected()){
            ea = "Yes";
        }else if (e2.isSelected()){
            ea = "No";
        }

        try {
            if (textPAN.getText().equals("") || textAadhar.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            } else {
                Conn c1 = new Conn();
                String q = "insert into signup_two values('"+formNo+"', '"+religion+"', '"+category+"', '"+income+"', '"+education+"', '"+occupation+"', '"+PAN+"', '"+aadhar+"', '"+sc+"', '"+ea+"')";
                c1.statement.executeUpdate(q);
                new Signup3(formNo);
                setVisible(false);
            }
            
        } catch (Exception E) {
            E.printStackTrace();
        }
     
    }



    public static void main(String[] args) {
        new Signup2("");
    }
}
