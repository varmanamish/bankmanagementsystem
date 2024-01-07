package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    String formno=null;
    JTextField panTextField, aadhaarTextField;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religionB, categoryB, incomeB, educationB, occupationB;
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 300, 30);
        add(additionalDetails);
        
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);
        
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionB = new JComboBox(valReligion);
        religionB.setBounds(300, 140, 400, 30);
        religionB.setBackground(Color.white);
        add(religionB);
        
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);
        
        String valCategory[] = {"General","OBC","SC","ST","Other"};
        categoryB = new JComboBox(valCategory);
        categoryB.setBounds(300, 190, 400, 30);
        categoryB.setBackground(Color.white);
        add(categoryB);
        
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);
        
        String valIncome[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        incomeB = new JComboBox(valIncome);
        incomeB.setBounds(300, 240, 200, 30);
        incomeB.setBackground(Color.white);
        add(incomeB);
                
        JLabel ed = new JLabel("Educational");
        ed.setFont(new Font("Raleway", Font.BOLD, 20));
        ed.setBounds(100, 290, 200, 30);
        add(ed);
        
        JLabel qual = new JLabel("Qualification:");
        qual.setFont(new Font("Raleway", Font.BOLD, 20));
        qual.setBounds(100, 315, 200, 30);
        add(qual);
        
        String valEducation[] = {"Non-Graduate","Graduate","Pst-Graduate","Doctrate","Others"};
        educationB = new JComboBox(valEducation);
        educationB.setBounds(300, 315, 400, 30);
        educationB.setBackground(Color.white);
        add(educationB);
        
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 390, 200, 30);
        add(occupation);
        
        String valOccupation[] = {"Salaried","Self-employed","Business","Student","Retired","Others"};
        occupationB = new JComboBox(valOccupation);
        occupationB.setBounds(300, 390, 400, 30);
        occupationB.setBackground(Color.white);
        add(occupationB);
                        
        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 440, 200, 30);
        add(pan);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Arial", Font.BOLD, 14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);
        
        JLabel aadhaar = new JLabel("Aadhaar Number:");
        aadhaar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhaar.setBounds(100, 490, 200, 30);
        add(aadhaar);
        
        aadhaarTextField = new JTextField();
        aadhaarTextField.setFont(new Font("Arial", Font.BOLD, 14));
        aadhaarTextField.setBounds(300, 490, 400, 30);
        add(aadhaarTextField);
        
        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100, 540, 200, 30);
        add(senior);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 80, 30);
        syes.setFont(new Font("Raleway", Font.ITALIC, 12));
        syes.setBackground(Color.white);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(380, 540, 100, 30);
        sno.setFont(new Font("Raleway", Font.ITALIC, 12));
        sno.setBackground(Color.white);
        add(sno);
        
        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);  
        
        JLabel account = new JLabel("Existing Account:");
        account.setFont(new Font("Raleway", Font.BOLD, 20));
        account.setBounds(100, 590, 200, 30);
        add(account);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 80, 30);
        eyes.setFont(new Font("Raleway", Font.ITALIC, 12));
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(380, 590, 100, 30);
        eno.setFont(new Font("Raleway", Font.ITALIC, 12));
        eno.setBackground(Color.white);
        add(eno);
        
        ButtonGroup accgroup = new ButtonGroup();
        accgroup.add(eyes);
        accgroup.add(eno);  
        
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.white);
        
        setSize(850,800);
        setLocation(600, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String religion = (String)religionB.getSelectedItem();
        String category = (String)categoryB.getSelectedItem();
        String income = (String)incomeB.getSelectedItem();
        String education = (String)educationB.getSelectedItem();
        String occupation = (String)occupationB.getSelectedItem();
        String pan = panTextField.getText();
        String aadhaar = aadhaarTextField.getText();
        String senior = null;
        if(eyes.isSelected())
            senior="Male";
        else if(eno.isSelected())
            senior="Female";
        
        String account = null;
        if(syes.isSelected())
            account="Male";
        else if(sno.isSelected())
            account="Female";
        
        try{
            if(pan.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            }else if(aadhaar.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            }else{
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+education+"', '"+occupation+"', '"+pan+"', '"+aadhaar+"', '"+senior+"', '"+account+"');";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String args[]){
        new SignupTwo("");
    }
}
