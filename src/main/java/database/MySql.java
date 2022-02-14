package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySql extends DBUtiles{

    private Connection con;
    private Statement stmt;


    public Statement con()  {

        System.out.println("My Sql Connect");
        con=null;
        stmt=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_4",
                    "root","");
            stmt =con.createStatement();

            return stmt;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        }

    @Override
    public void discon() {
        try {
            con.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}



