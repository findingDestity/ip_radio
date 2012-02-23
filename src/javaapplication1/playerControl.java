/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.media.*;

/**
 *
 * @author Blade
 */
public class playerControl {
     private Player player;
   private File file;

    public void createPlayer()
   {
  

      removePreviousPlayer();

      try {
         // create a new player and add listener
          String ip = "192.168.1.33";
         player = Manager.createPlayer( new MediaLocator("rtp://" + ip + ":40002/audio"));
         player.addControllerListener( new EventHandler() );
         player.start();  // start player
      }
      catch ( Exception e ){
        // JOptionPane.showMessageDialog( this,
          //  "Invalid file or location", "Error loading file",
            //JOptionPane.ERROR_MESSAGE );
      }
   }

   public void removePreviousPlayer()
   {
 
    if(theStation.player.getComponentCount()==0)
        return;
      player.close();

      Component visual = player.getVisualComponent();
      Component control = player.getControlPanelComponent();

      Container c = theStation.player;

      if ( visual != null )
         c.remove( visual );

      if ( control != null )
         c.remove( control );
   }

   public static void main(String args[])
   {
     player app = new player();
app.setVisible(true);
      app.addWindowListener(
         new WindowAdapter() {
            public void windowClosing( WindowEvent e )
            {
               System.exit(0);
            }
         }
      );
   }

   // inner class to handler events from media player
   private class EventHandler implements ControllerListener {
      public void controllerUpdate( ControllerEvent e ) {
         if ( e instanceof RealizeCompleteEvent ) {
            Container c = theStation.player;

            // load Visual and Control components if they exist
            Component visualComponent =
               player.getVisualComponent();

            if ( visualComponent != null )
               c.add( visualComponent, GroupLayout.DEFAULT_SIZE);

            Component controlsComponent =
               player.getControlPanelComponent();
controlsComponent.setSize(theStation.player.getWidth(), theStation.player.getHeight());
            if ( controlsComponent != null )
               c.add( controlsComponent, GroupLayout.DEFAULT_SIZE );

            c.doLayout();
         }
      }
   }



}
