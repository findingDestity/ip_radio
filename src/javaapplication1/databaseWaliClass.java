/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;

/**
 *
 * @author gun
 */
public class databaseWaliClass {
     Connection connection = null;
     Statement st;

     public Statement getResults()
    {
         return st;
     }

    databaseWaliClass()
    {

   
try {
// Load the JDBC driver
//String driverName = "org.gjt.mm.mysql.Driver"; // MySQL MM JDBC driver
String driverName = "com.mysql.jdbc.Driver"; // MySQL MM JDBC driver
    Class.forName(driverName);

// Create a connection to the database
String serverName = "localhost:3306";
String mydatabase = "masterdb";
String url = "jdbc:mysql://" + serverName + "/" + mydatabase; // a JDBC url
String username = "root";
String password = "abc";
connection = DriverManager.getConnection(url, username, "");
System.out.println("FYEAH");
} catch (ClassNotFoundException e) {
    System.out.println("WHAT THE FUCK" + e.toString());

// Could not find the database driver
} catch (SQLException e) {
     System.out.println("WHAT THE FUCK22" + e.toString());
// Could not connect to the database
}

    }

    public void query(String str) throws SQLException
    {
        
             st = connection.createStatement();
           st.execute(str);
       
/*
 *  } catch (SQLException ex) {
            Logger.getLogger(databaseWaliClass.class.getName()).log(Level.SEVERE, null, ex);
        }
 *
 *
 *
 *
 */
    }

public static void main(String args[])
    {
    Main.con = new databaseWaliClass();
        try {
            Main.con.query("Insert into userinfo values('sdsdfdfd','zczxzxzx','sdsfdgrs','sdsds','wdwdw','sdwasd');");
        } catch (SQLException ex) {
            Logger.getLogger(databaseWaliClass.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
