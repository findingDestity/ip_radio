/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

/**
 *
 * @author Blade
 */
public class Main {

    public static NewJFrame x;
    public static databaseWaliClass con;
    public static session sess;
    public static void createMain()
    {
             java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              x = new NewJFrame();
                       x.setVisible(true);
            }
        });
        con = new databaseWaliClass();
        sess = new session();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     createMain();

        // TODO code application logic here
    }

}
