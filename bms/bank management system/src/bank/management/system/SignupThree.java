package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    String formno=null;
    JButton cancel, submit;
    JRadioButton sacc, fdacc, cacc, rdacc;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    SignupThree(String formno){
        this.formno=formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        
        JLabel accountDetails = new JLabel("Page 3: Account Details");
        accountDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        accountDetails.setBounds(290, 80, 300, 30);
        add(accountDetails);
        
        JLabel account = new JLabel("Account Type:");
        account.setFont(new Font("Raleway", Font.BOLD, 20));
        account.setBounds(100, 140, 150, 30);
        add(account);
        
        sacc = new JRadioButton("Savings Account");
        sacc.setBounds(100, 180, 150, 30);
        sacc.setFont(new Font("Raleway", Font.ITALIC, 12));
        sacc.setBackground(Color.white);
        add(sacc);
        
        fdacc = new JRadioButton("Fixed Deposit Account");
        fdacc.setBounds(300, 180, 150, 30);
        fdacc.setFont(new Font("Raleway", Font.ITALIC, 12));
        fdacc.setBackground(Color.white);
        add(fdacc);
        
        cacc = new JRadioButton("Current Account");
        cacc.setBounds(100, 210, 150, 30);
        cacc.setFont(new Font("Raleway", Font.ITALIC, 12));
        cacc.setBackground(Color.white);
        add(cacc);
        
        rdacc = new JRadioButton("Recurring Deposit Account");
        rdacc.setBounds(300, 210, 180, 30);
        rdacc.setFont(new Font("Raleway", Font.ITALIC, 12));
        rdacc.setBackground(Color.white);
        add(rdacc);
        
        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(sacc);
        accountgroup.add(fdacc); 
        accountgroup.add(cacc);
        accountgroup.add(rdacc); 
        
        JLabel cardnumber = new JLabel("Card Number");
        cardnumber.setFont(new Font("Raleway", Font.BOLD, 20));
        cardnumber.setBounds(100, 260, 200, 30);
        add(cardnumber);
                
        JLabel subcardnumber = new JLabel("Your 14 digit Card Number");
        subcardnumber.setFont(new Font("Raleway", Font.BOLD, 11));
        subcardnumber.setBounds(100, 280, 200, 30);
        add(subcardnumber);
        
        JLabel cardno = new JLabel("XXXX-XXXX-XXXX-4184");
        cardno.setFont(new Font("Raleway", Font.BOLD, 20));
        cardno.setBounds(300, 260, 400, 30);
        add(cardno);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 320, 200, 30);
        add(pin);
        
        JLabel subpin = new JLabel("Your 4 digit Password");
        subpin.setFont(new Font("Raleway", Font.BOLD, 11));
        subpin.setBounds(100, 340, 200, 30);
        add(subpin);
        
        JLabel pinno = new JLabel("XXXX");
        pinno.setFont(new Font("Raleway", Font.BOLD, 20));
        pinno.setBounds(300, 320, 400, 30);
        add(pinno);
        
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 20));
        services.setBounds(100, 390, 200, 30);
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setBounds(100, 430, 150, 30);
        c1.setFont(new Font("Raleway", Font.BOLD, 14));
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setBounds(350, 430, 150, 30);
        c2.setFont(new Font("Raleway", Font.BOLD, 14));
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setBounds(100, 470, 150, 30);
        c3.setFont(new Font("Raleway", Font.BOLD, 14));
        add(c3);
        
        c4 = new JCheckBox("E-MAIL & SMS Alerts");
        c4.setBackground(Color.white);
        c4.setBounds(350, 470, 180, 30);
        c4.setFont(new Font("Raleway", Font.BOLD, 14));
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setBounds(100, 510, 150, 30);
        c5.setFont(new Font("Raleway", Font.BOLD, 14));
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setBounds(350, 510, 150, 30);
        c6.setFont(new Font("Raleway", Font.BOLD, 14));
        add(c6);
        
        c7 = new JCheckBox("I herby declare that the above eneterd details are correct to the best of my knowledge");
        c7.setBackground(Color.white);
        c7.setBounds(150, 600, 600, 30);
        add(c7);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(300, 650, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(450, 650, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        getContentPane().setBackground(Color.white);
        
        setSize(850,800);
        setLocation(600, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==submit){
            String accountType = "";
            if(sacc.isSelected())
                accountType="Savings Account";
            else if(fdacc.isSelected())
                accountType="Fixed Deposit Account";
            else if(cacc.isSelected())
                accountType="Current Account";
            else if(rdacc.isSelected())
                accountType="Recurring Depost Account";
            
            Random random = new Random();
            String cardnumber =""+Math.abs(random.nextLong())%9000000000000000L;
            String pinnumber = ""+Math.abs(random.nextLong() % 9000L + 1000L);
            
            String facility ="";
            if(c1.isSelected())
                facility+=" ATM Card";
            else if(c2.isSelected())
                facility+=" Internet Banking";
            else if(c3.isSelected())
                facility+=" Mobile Banking";
            else if(c4.isSelected())
                facility+=" E-MAIL & SMS Alerts";
            else if(c5.isSelected())
                facility+=" Cheque Book";
            else if(c6.isSelected())
                facility+=" E-Statement";
            
            try{
                if(accountType.equals(""))
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                else{
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"' ,'"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"');";
                    String query2 = "insert into login values('"+formno+"' ,'"+cardnumber+"', '"+pinnumber+"');";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: "+cardnumber+"\n Pin: "+pinnumber);
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new SignupThree("");
    }
}
