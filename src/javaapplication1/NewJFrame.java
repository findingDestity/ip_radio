/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame.java
 *
 * Created on Dec 2, 2010, 11:23:25 PM
 */

package javaapplication1;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;
import org.jdesktop.swingx.*;
/**
 *
 * @author Blade
 */
public class NewJFrame extends javax.swing.JFrame {


    //My declarations

    
    private void addPanels()
    {
        
       // jPanel1.add(new welcome(),"welcome");
    //    jPanel1.add(naya,"newProperty");
        jPanel1.add(new login(),"login");
        jPanel1.add(new register(), "register");
        
        jPanel1.add(new createStation(), "create");
        jPanel1.add(new theStation(),"theStation");
        jPanel1.add(new viewmy2(),"view");
        jPanel1.add(new viewsubs(),"viewsub");
          
    }


    public void switchto(String str)
    {
        CardLayout c1 = (CardLayout)(jPanel1.getLayout());
        c1.show(jPanel1, str);
     
    }

    public void addlogin()
    {
           taskUser.add(new AbstractAction(){

        {
            putValue(Action.NAME,"Log In");
            putValue(Action.SHORT_DESCRIPTION,"jh");

        }

        public void actionPerformed(ActionEvent e){

            if(Main.sess.checkSess().equals("null"))
            {
              switchto("login");

            }
   }
 });

    }

   public void populateTaskItems()
    {
           //================================= Add Task Items================================
        //Properties Items====================

     

   /* taskUser.add(new AbstractAction(){
        {
            putValue(Action.NAME,"View Information");
            putValue(Action.SHORT_DESCRIPTION,"view Profile Information");
        }
          public void actionPerformed(ActionEvent e){
            switchto("profile");
            }
     });*/


    taskStream.add(new AbstractAction(){
        {
            putValue(Action.NAME,"Create a broadcast");
            putValue(Action.SHORT_DESCRIPTION,"Use this to add a new property unit");
        }
          public void actionPerformed(ActionEvent e){
           switchto("create");
            }
     });

    taskStream.add(new AbstractAction(){
        {
            putValue(Action.NAME,"View My broadcasts");
            putValue(Action.SHORT_DESCRIPTION,"Use this to add a new property unit");
        }
          public void actionPerformed(ActionEvent e){
            switchto("view");
            }
     });
       taskStream.add(new AbstractAction(){
        {
            putValue(Action.NAME,"Channel");
            putValue(Action.SHORT_DESCRIPTION,"Use this to add a new property unit");
        }
          public void actionPerformed(ActionEvent e){
            switchto("theStation");
            }
     });

     

    taskStream.add(new AbstractAction(){
        {
            putValue(Action.NAME,"Go Live!");
            putValue(Action.SHORT_DESCRIPTION,"Use this to add a new property unit");
        }
          public void actionPerformed(ActionEvent e){
              String[] ss = new String[3];
           audioStream.RTPServer.main(ss);

          }

     });

     taskListen.add(new AbstractAction(){
        {
            putValue(Action.NAME,"Search Stations");
            putValue(Action.SHORT_DESCRIPTION,"Use this to add a new property unit");
        }
          public void actionPerformed(ActionEvent e){
            jLabel1.setText("sdsdsdsd");
            }
     });
        taskListen.add(new AbstractAction(){
        {
            putValue(Action.NAME,"Listen");
            putValue(Action.SHORT_DESCRIPTION,"Use this to add a new property unit");
        }
          public void actionPerformed(ActionEvent e){
         playerControl x = new playerControl();

         x.createPlayer();
            }
     });

     taskNetwork.add(new AbstractAction(){
        {
            putValue(Action.NAME,"Subscribed Stations");
            putValue(Action.SHORT_DESCRIPTION,"Use this to add a new property unit");
        }
          public void actionPerformed(ActionEvent e){
            switchto("viewsub");
            }
     });

     taskNetwork.add(new AbstractAction(){
        {
            putValue(Action.NAME,"Followers");
            putValue(Action.SHORT_DESCRIPTION,"Use this to add a new property unit");
        }
          public void actionPerformed(ActionEvent e){
            switchto("viewfol");
            }
     });

        //END TASKSS
    }

    //=------------

    /** Creates new form NewJFrame */
    public NewJFrame() {
             try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
              
               //this.setLocationRelativeTo(null);
        initComponents();
 
        CardLayout cc = new CardLayout();
        jPanel1.setLayout(cc);
        addPanels();
        addlogin();
        //populateTaskItems();




    
     

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXTaskPaneContainer1 = new org.jdesktop.swingx.JXTaskPaneContainer();
        jLabel1 = new javax.swing.JLabel();
        taskUser = new org.jdesktop.swingx.JXTaskPane();
        taskStream = new org.jdesktop.swingx.JXTaskPane();
        taskListen = new org.jdesktop.swingx.JXTaskPane();
        taskNetwork = new org.jdesktop.swingx.JXTaskPane();
        taskMisc = new org.jdesktop.swingx.JXTaskPane();
        taskSettings = new org.jdesktop.swingx.JXTaskPane();
        taskextra = new org.jdesktop.swingx.JXTaskPane();
        jPanel1 = new javax.swing.JPanel();
        playerpanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IP Radio");
        setBackground(new java.awt.Color(0, 102, 102));

        jXTaskPaneContainer1.setBackground(new java.awt.Color(0, 102, 102));
        jXTaskPaneContainer1.setFocusable(false);

        jLabel1.setText("jLabel1");

        taskUser.setTitle("User");

        taskStream.setCollapsed(true);
        taskStream.setTitle("Broadcast");
        taskStream.setEnabled(false);
        taskStream.setOpaque(false);

        taskListen.setCollapsed(true);
        taskListen.setTitle("Listen");

        taskNetwork.setCollapsed(true);
        taskNetwork.setTitle("Your Network");

        taskMisc.setCollapsed(true);
        taskMisc.setTitle("Misc");

        taskSettings.setCollapsed(true);
        taskSettings.setTitle("Settings");

        taskextra.setCollapsed(true);

        javax.swing.GroupLayout jXTaskPaneContainer1Layout = new javax.swing.GroupLayout(jXTaskPaneContainer1);
        jXTaskPaneContainer1.setLayout(jXTaskPaneContainer1Layout);
        jXTaskPaneContainer1Layout.setHorizontalGroup(
            jXTaskPaneContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXTaskPaneContainer1Layout.createSequentialGroup()
                .addGroup(jXTaskPaneContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(taskextra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(taskSettings, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(taskStream, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(taskListen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(taskNetwork, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(taskMisc, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jXTaskPaneContainer1Layout.createSequentialGroup()
                .addComponent(taskUser, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jXTaskPaneContainer1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jXTaskPaneContainer1Layout.setVerticalGroup(
            jXTaskPaneContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTaskPaneContainer1Layout.createSequentialGroup()
                .addComponent(taskUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(taskStream, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(taskListen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(taskNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(taskMisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(taskSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(taskextra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 3, true));
        jPanel1.setPreferredSize(new java.awt.Dimension(260, 687));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        playerpanel.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout playerpanelLayout = new javax.swing.GroupLayout(playerpanel);
        playerpanel.setLayout(playerpanelLayout);
        playerpanelLayout.setHorizontalGroup(
            playerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1045, Short.MAX_VALUE)
        );
        playerpanelLayout.setVerticalGroup(
            playerpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(playerpanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jXTaskPaneContainer1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playerpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXTaskPaneContainer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1081)/2, (screenSize.height-644)/2, 1081, 644);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:3
        
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXTaskPaneContainer jXTaskPaneContainer1;
    public static javax.swing.JPanel playerpanel;
    public static org.jdesktop.swingx.JXTaskPane taskListen;
    public static org.jdesktop.swingx.JXTaskPane taskMisc;
    public static org.jdesktop.swingx.JXTaskPane taskNetwork;
    public static org.jdesktop.swingx.JXTaskPane taskSettings;
    public static org.jdesktop.swingx.JXTaskPane taskStream;
    public org.jdesktop.swingx.JXTaskPane taskUser;
    private org.jdesktop.swingx.JXTaskPane taskextra;
    // End of variables declaration//GEN-END:variables

}
