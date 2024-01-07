package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame{
    
    String pinnumber;
    
    MiniStatement(String pinnumber){
        this.pinnumber=pinnumber;
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        mini.setFont(new Font("Raleway", Font.BOLD, 14));
        add(mini);
        
        JLabel bank = new JLabel("GRIET Bank");
        bank.setBounds(120, 20, 150, 20);
        bank.setFont(new Font("Raleway", Font.BOLD, 24));
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"';");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardnumber").substring(0,4)+" XXXX XXXX "+rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("Select * from bank where pin ='"+pinnumber+"';");
            int i=0;
            while(rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br>");
                i++;
                if(i==5)
                    break;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        int bal=0;
        try{
            Conn conn = new Conn();
            String query1 = "select * from bank where pin='"+pinnumber+"';";
            ResultSet rs = conn.s.executeQuery(query1);
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
        text.setBounds(20, 400, 400, 30);
        text.setFont(new Font("Raleway", Font.BOLD, 18));
        add(text);
        
        setSize(500,600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new MiniStatement("");
    }
    
}
