/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

/**
 *
 * @author gun
 */
public class session {

    private String username="null";


    public void createSession(String str)
    {
        username = str;
    }

    public void endSession()

    {
        username = "null";

    }

    public String checkSess()
    {
        return username;
    }




}
