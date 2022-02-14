import database.DBUtiles;
import database.MySql;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
	// write your code here

        DBUtiles db=new MySql();

       // db.insert("insert into users (username,password,first_name,last_name)"+
             //   "values('haroon','12589','haroon','naem')");
       /* db.insert("users",
                new String[]{"usergit remote add origin https://github.com/AyatHasa/project-x.gitname", "password", "first_name", "last_name"},
                new String[]{"saed", "25874", "saed", "hamdoni"});
        db.query("select * from users");*/



        Scanner i = new Scanner(System.in);
        System.out.print("Please Enter Username : ");
        String username = i.next();

        if (db.checkUserIfExist(username)) {
            String query = String.format("delete from users where username = '%s'", username);
            db.delete(username,query);
            System.out.println("---------------------------------------------");
            db.query("select * from users");
        } else {
            System.out.println("User does not  exist.");
            System.out.println("---------------------------------------------");

            db.query("select * from users");

        }



    }}
