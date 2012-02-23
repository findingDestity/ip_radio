package audioStream;

import java.awt.Component;
import java.awt.Container;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.rtp.*;
import javax.media.rtp.rtcp.*;
import javax.media.*;
import javax.media.protocol.*;
import javax.media.control.*;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.GroupLayout;



public class RTPServer implements  ControllerListener, Runnable {
    private boolean realized = false;
    private boolean configured = false;
    private String ipAddress;
    Processor p;
    MediaLocator src;
    private InputStream in;
    RTPManager rtpMgr;

    public static void main (String[] args) {
        RTPServer rtp;
        try {
            rtp = new RTPServer("192.168.1.33", "07_DIL CHEEZ KYA HAI.mp3");
             Thread t = new Thread(rtp);
                     t.start();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(RTPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    }

public void setSource(String str)
    {

}
    public RTPServer(String ip, String song) throws UnsupportedAudioFileException {

ContentDescriptor cd = new ContentDescriptor(ContentDescriptor.RAW_RTP);
        ipAddress = ip;
 String srcFile = song;

 AudioInputStream source;
        try {
            source = AudioSystem.getAudioInputStream(new File(srcFile));
            AudioInputStream pcm = AudioSystem.getAudioInputStream(AudioFormat.Encoding.PCM_SIGNED, source);
AudioInputStream ulaw = AudioSystem.getAudioInputStream(AudioFormat.Encoding.ULAW, pcm);
File tempFile = new File("d://temp.wav");
AudioSystem.write(ulaw, AudioFileFormat.Type.WAVE, tempFile);
        } catch (IOException ex) {
            Logger.getLogger(RTPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
       

   
     
       javaapplication1.playerControl x = new javaapplication1.playerControl();
       x.removePreviousPlayer();
     
      
 src = new MediaLocator("file:D://temp.wav");
        try {
            p = Manager.createProcessor(src);
          
        } catch (IOException ex) {
            Logger.getLogger(RTPServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoProcessorException ex) {
            Logger.getLogger(RTPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
           
       
           
    p.addControllerListener(this);
     p.configure();
   

    }

    private void setTrackFormat(Processor p) {
 // Get the tracks from the processor
 TrackControl [] tracks = p.getTrackControls();
 // Do we have atleast one track?
 if (tracks == null || tracks.length < 1) {
     System.out.println("Couldn't find tracks in processor");
     System.exit(1);
 }

 // Set the output content descriptor to RAW_RTP
 // This will limit the supported formats reported from
 // Track.getSupportedFormats to only valid RTP formats.
 ContentDescriptor cd = new ContentDescriptor(ContentDescriptor.RAW_RTP);
 p.setContentDescriptor(cd);

 Format supported[];
 Format chosen;
 boolean atLeastOneTrack = false;

 // Program the tracks.
 for (int i = 0; i < tracks.length; i++) {
     Format format = tracks[i].getFormat();
            System.out.println("Trenutni format je " +format.getEncoding());
     if (tracks[i].isEnabled()) {
  supported = tracks[i].getSupportedFormats();
  for (int n = 0; n < supported.length; n++)
      System.out.println("Supported format: " + supported[n]);

  // We've set the output content to the RAW_RTP.
  // So all the supported formats should work with RTP.
  // We'll just pick the first one.

  if (supported.length > 0) {
      chosen = supported[0]; // this is where I tried changing formats
      tracks[i].setFormat(chosen);
      System.err.println("Track " + i + " is set to transmit as: " +chosen);
      atLeastOneTrack = true;
  } else
      tracks[i].setEnabled(false);
     } else
  tracks[i].setEnabled(false);
 }
    }

 public void removePreviousPlayer()
   {
      if ( p == null )
         return;

      p.close();

      Component visual = p.getVisualComponent();
      Component control = p.getControlPanelComponent();

      Container c = javaapplication1.NewJFrame.playerpanel;

      if ( visual != null )
         c.remove( visual );

      if ( control != null )
         c.remove( control );
   }

    private class EventHandler implements ControllerListener {
      public void controllerUpdate( ControllerEvent e ) {
         if ( e instanceof RealizeCompleteEvent ) {
            Container c = javaapplication1.theStation.player;

            // load Visual and Control components if they exist
            Component visualComponent =
               p.getVisualComponent();

            if ( visualComponent != null )
               c.add( visualComponent, GroupLayout.PREFERRED_SIZE);

            Component controlsComponent =
               p.getControlPanelComponent();
controlsComponent.setSize(javaapplication1.theStation.player.getWidth(), javaapplication1.theStation.player.getHeight());
            if ( controlsComponent != null )
               c.add( controlsComponent, GroupLayout.PREFERRED_SIZE );

            c.doLayout();
         }
      }
   }
    private void transmit(Processor p) {
 try {
     DataSource output = p.getDataOutput();
     PushBufferDataSource pbds = (PushBufferDataSource) output;
      rtpMgr = RTPManager.newInstance();
     SessionAddress localAddr, destAddr;
     SendStream sendStream;
     int port = 40000;
     SourceDescription srcDesList[];
     localAddr = new SessionAddress( InetAddress.getLocalHost(), 40000);
     InetAddress ipAddr = InetAddress.getByName(ipAddress);
     destAddr = new SessionAddress( ipAddr, port);
     rtpMgr.initialize(localAddr);
     rtpMgr.addTarget(destAddr);
     sendStream = rtpMgr.createSendStream(output, 0);
     sendStream.start();
     System.err.println( "Created RTP session: " + ipAddress + " " + port);
     p.start();
 } catch(Exception e) {
     e.printStackTrace();
 }
    }

    public synchronized void controllerUpdate(ControllerEvent evt) {
 if (evt instanceof RealizeCompleteEvent) {
     realized = true;
       Container c = javaapplication1.theStation.player;

            // load Visual and Control components if they exist
            Component visualComponent =
               p.getVisualComponent();

            if ( visualComponent != null )
               c.add( visualComponent, GroupLayout.PREFERRED_SIZE);

            Component controlsComponent =
               p.getControlPanelComponent();
controlsComponent.setSize(javaapplication1.theStation.player.getWidth(), javaapplication1.theStation.player.getHeight());
            if ( controlsComponent != null )
               c.add( controlsComponent, GroupLayout.DEFAULT_SIZE );

            c.doLayout();
 } else  if (evt instanceof ConfigureCompleteEvent) {
     configured = true;
 } else if (evt instanceof EndOfMediaEvent) {
     //rtpMgr.dispose();
 } else {
     // System.out.println(evt.toString());
 }
    }

    public void run() {

 try {
    
     while (! configured) {
  try {
      Thread.currentThread().sleep(100L);;
  } catch (InterruptedException e) {
      // ignore
  }
     }

     //setTrackFormat(p);
     p.setContentDescriptor(new ContentDescriptor(ContentDescriptor.RAW_RTP));

     p.realize();

     while (! realized) {
  try {
      Thread.currentThread().sleep(100L);;
  } catch (InterruptedException e) {
      // ignore
  }
     }
     transmit(p);

 } catch(Exception e) {
     e.printStackTrace();
     System.exit(1);
 }
    }
}