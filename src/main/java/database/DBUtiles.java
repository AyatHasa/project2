package database;

import java.sql.ResultSet;
import java.sql.Statement;

public abstract class DBUtiles {


abstract Statement con() ;
abstract void discon() ;




    public void query (String query){
        try {

            ResultSet rs =con().executeQuery(query);
            while (rs.next()){
                System.out.println("username : "+rs.getString("username"));
                System.out.println("first name : "+rs.getString("first_name"));
                System.out.println("last name : "+rs.getString("last_name"));

                System.out.println("-----------------------------------------");


            }
            discon();
        } catch (Exception e) {
            discon();

            e.printStackTrace();
        }


    }

    public void insert (String table ,String columns[],String values[]){

        try {

            StringBuilder builder = new StringBuilder();
            builder.append("insert into ");
            builder.append(table);
            builder.append("(");
            for (int i = 0; i < columns.length; i++) {
                if (i != columns.length - 1) {
                    builder.append(columns[i] + ",");
                } else {
                    builder.append(columns[i]);
                }
            }
            builder.append(")");
            builder.append(" values");
            builder.append("(");
            for (int i = 0; i < values.length; i++) {
                if (i != columns.length - 1) {
                    builder.append("'" + values[i] + "',");
                } else {
                    builder.append("'" + values[i] + "'");
                }
            }
            builder.append(")");
            System.out.println(builder.toString());
            con().execute(builder.toString());
            System.out.println("Record saved.");
            System.out.println("-----------------------------------------");
            discon();
        } catch (Exception e) {
            discon();

            e.printStackTrace();
        }
    }

    public void delete (String m,String query){

        try {

            con().execute(query);
            System.out.println(m+" has been deleted");
            discon();
        } catch (Exception e) {
            discon();

            e.printStackTrace();
        }

    }

    public boolean checkUserIfExist(String username){

        try {

            ResultSet rs = con().executeQuery("select * from users where username='" + username + "'");
            if (rs.next()) {
                return true;
            }
            discon();
            return false;
        } catch (Exception e) {
            discon();
            e.printStackTrace();
            return false;
        }
    }



}
