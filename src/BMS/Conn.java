package BMS;


import java.sql.*;

public class Conn {
    Connection connection;
    Statement statement;
    public Conn() {
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "toor");
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


