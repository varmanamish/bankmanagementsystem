package bank.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){
        try{
            //Step-1 Create the Driver
            //Class.forName(com.mysql.cj.jdbc.Driver);
            //Step-2 Create connection
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "kushi");
            //Step-3 Create Statement
            s=c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
