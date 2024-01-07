package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    
    String pinnumber;
    JButton back;
    
    BalanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        int bal=0;
        Conn c = new Conn();
        try{
            String query1 = "select * from bank where pin='"+pinnumber+"';";
            ResultSet rs = c.s.executeQuery(query1);
            while(rs.next()){
                if(rs.getString("type").equals("Deposit"))
                    bal += Integer.parseInt(rs.getString("amount"));
                else
                    bal-= Integer.parseInt(rs.getString("amount"));
            }
        } catch(Exception e){
            System.out.println(e);
        }
        
        JLabel text = new JLabel("Your current account balance is Rs "+bal);
        text.setForeground(Color.white);
        text.setBounds(170, 300, 400, 30);
        image.add(text);
        
        setSize(900, 900);
        setLocation(560, 10);
        //setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
}
