/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * viewmy2.java
 *
 * Created on Apr 25, 2011, 12:01:34 AM
 */

package javaapplication1;

/**
 *
 * @author Jd
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class viewfollowers extends javax.swing.JPanel {

    /** Creates new form viewmy2 */
    public viewfollowers() {
        initComponents();
        try {
            Main.con.query("Select * from channels  where username = '" + Main.sess.checkSess() + "';");

            Statement st = Main.con.getResults();
            ResultSet res = st.getResultSet();
                int i=0;
                while(res.next())
                   {
                   jComboBox1.addItem(res.getObject("sname"));
                   s[i]=res.getString("sid");
                   i++;
                   }}
    catch



        (SQLException ex) {
            Logger.getLogger(viewfollowers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  /*  private void populate()
    {
        try {
            DefaultTableModel x = (DefaultTableModel) jTable1.getModel();
        

         while(x.getRowCount()>0) {
              x.removeRow(0);
           }
          //  System.out.println(Main.sess.checkSess());
            Main.con.query("Select * from subscriptions  where follower = '" + Main.sess.checkSess() + "';");
            Statement st = Main.con.getResults();
            ResultSet res1 = st.getResultSet();
            String status="Offline"; 
            int i=0;
            while(res1.next())
            {
                Main.con.query("Select * from channels where sid = '" + res1.getString("station_id") + "';" );
                Statement st2 = Main.con.getResults();
                ResultSet res = st2.getResultSet();
          
          //  Boolean in=true;
                res.next();
                if(res.getString("islive").equals("1"))
                {status="Online";
                }
                 else  status="Offline";

               
                    x.insertRow(i++, new Object[]{ res.getString("sid"),res.getString("sname"),res.getString("genre"),res.getString("sdesc"),status});
            

            }

        } catch (SQLException ex) {
            Logger.getLogger(theStation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Username", "Name", "Email", "IP Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setName("jTable1"); // NOI18N
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Your Followers :");
        jLabel1.setName("jLabel1"); // NOI18N

        jSeparator1.setName("jSeparator1"); // NOI18N

        jLabel2.setText("Select a station to view it's followers");
        jLabel2.setName("jLabel2"); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        jComboBox1.setName("jComboBox1"); // NOI18N

        jButton1.setText("View");
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(478, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jButton1)
                .addContainerGap(100, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            DefaultTableModel x = (DefaultTableModel) jTable1.getModel();


         while(x.getRowCount()>0) {
              x.removeRow(0);
           }
            String station =s[jComboBox1.getSelectedIndex()];
            System.out.println(station);
            Main.con.query("Select * from subscriptions  where station_id = '" + station + "';");
            Statement st = Main.con.getResults();
            ResultSet res1 = st.getResultSet();
           // String status="Offline";
            int i=0;
            while(res1.next())
            {
                Main.con.query("Select * from userinfo where username = '" + res1.getString("follower") + "';" );
                Statement st2 = Main.con.getResults();
                ResultSet res = st2.getResultSet();

          //  Boolean in=true;
                res.next();



                    x.insertRow(i++, new Object[]{ res.getString("username"),res.getString("fname")+" "+res.getString("lname"),res.getString("email"),res.getString("currentip")});


            }

        } catch (SQLException ex) {
            Logger.getLogger(theStation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
   private String s[]=new String[10];
}