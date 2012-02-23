/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 package audioStream;


import com.sun.media.protocol.rtp.DataSource;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.*;
import javax.media.format.AudioFormat;
//import jicyshout0_2_1.jicyshout1.src.net.sourceforge.jicyshout.jicylib1.SimpleMP3DataSource;

public class RTPClient implements ControllerListener, Runnable {

    Player p;
    MediaLocator src;

    public static void main(String[] args) {
        RTPClient rtp = new RTPClient("192.168.1.33");
        Thread t = new Thread(rtp);
        t.start();

    }

    public RTPClient(String ip) {

            String srcUrl = "rtp://" + ip + ":40002/audio";
            DataSink sink;
              Format input1 = new AudioFormat(AudioFormat.MPEGLAYER3); 
              Format input2 = new AudioFormat(AudioFormat.MPEG);
              Format output = new AudioFormat(AudioFormat.LINEAR);
             PlugInManager.addPlugIn( "com.sun.media.codec.audio.mp3.JavaDecoder",
                      new Format[]{input1, input2},
                      new Format[]{output},
                      PlugInManager.CODEC
                      );
            src = new MediaLocator(srcUrl);


    }
    public void run() {
        try {
            
     p = Manager.createPlayer(src);
 
     p.addControllerListener(this);
     p.start();
 } catch(Exception e) {
     e.printStackTrace();
     System.exit(1);
 }
    }

    public synchronized void controllerUpdate(ControllerEvent evt) {
 if (evt instanceof EndOfMediaEvent) {
     System.exit(0);
 } else {
     System.out.println(evt.toString());
 }
    }
}