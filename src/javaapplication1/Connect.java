/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author gun
 */

    public class Connect
   {
       public static void main (String[] args)
       {
           Connection conn = null;

           try
           {
               String userName = "root";
               String password = "abc123";
               String url = "jdbc:mysql://localhost/masterdb";
               Class.forName ("com.mysql.jdbc.Driver").newInstance ();
               conn = DriverManager.getConnection (url, userName, "");
               System.out.println ("Database connection established");
           }
           catch (Exception e)
           {
               System.err.println ("Cannot connect to database server" + e.toString());
           }
           finally
           {
               if (conn != null)
               {
                   try
                   {
                       conn.close ();
                       System.out.println ("Database connection terminated");
                   }
                   catch (Exception e) { /* ignore close errors */ }
               }
           }
       }
   }

