package bank.management.system;

import javax.swing.*;
import java.awt.*; //font and color
import java.awt.event.*; //action listener
import java.sql.*; //ResultSet  //Date is available in sql also
import java.util.Date; //Date has to be explicitly declared

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit, withdrawl, ministatement, pinchange, fastcash, balance, exit;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210,300,700,35);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.white);
        image.add(text);
        
        deposit = new JButton("Rs 100");
        deposit.setBounds(170, 400, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(355, 400, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170, 435, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(355, 435, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170, 470, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balance = new JButton("Rs 10000");
        balance.setBounds(355, 470, 150, 30);
        balance.addActionListener(this);
        image.add(balance);
        
        exit = new JButton("BACK");
        exit.setBounds(355, 505, 150, 30);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900, 900);
        setLocation(560, 10);
        //setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                //System.out.println(pinnumber);
                String query1 = "select * from bank where pin='"+pinnumber+"';";
                ResultSet rs = c.s.executeQuery(query1);
                int bal=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit"))
                        bal += Integer.parseInt(rs.getString("amount"));
                    else
                        bal-= Integer.parseInt(rs.getString("amount"));
                }
                if(ae.getSource() != exit && bal < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query2 = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"');";
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Rs "+amount+" withdrawn successfully");
                    
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[]){
        new FastCash("");
    }
}
