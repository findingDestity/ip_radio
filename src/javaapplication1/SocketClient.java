package javaapplication1;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.net.*;

class SocketClient extends JFrame
		 implements ActionListener {

   JLabel text, clicked;
   JButton button;
   JPanel panel;
   JTextField textField;
   Socket socket = null;
   PrintWriter out = null;
   BufferedReader in = null;

   SocketClient(){ //Begin Constructor
     text = new JLabel("Text to send over socket:");
     textField = new JTextField(20);
     button = new JButton("Click Me");
     button.addActionListener(this);

     panel = new JPanel();
     panel.setLayout(new BorderLayout());
     panel.setBackground(Color.white);
     getContentPane().add(panel);
     panel.add("North", text);
     panel.add("Center", textField);
     panel.add("South", button);
   } //End Constructor

  public void actionPerformed(ActionEvent event){
     Object source = event.getSource();

     if(source == button){
//Send data over socket
          String text = textField.getText();
          out.println(text);
	  textField.setText(new String(""));
//Receive text from server
       try{
	  String line = in.readLine();
          System.out.println("Text received :" + line);
       } catch (IOException e){
	 System.out.println("Read failed");
       	 System.exit(1);
       }
     }
  }
  
  public void listenSocket(){
//Create socket connection
     try{
       socket = new Socket("localhost", 4444);
       out = new PrintWriter(socket.getOutputStream(), true);
       in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
     } catch (UnknownHostException e) {
       System.out.println("Unknown host: kq6py.eng");
       System.exit(1);
     } catch  (IOException e) {
       System.out.println("No I/O");
       System.exit(1);
     }
  }

   public static void main(String[] args){
        SocketClient frame = new SocketClient();
	frame.setTitle("Client Program");
        WindowListener l = new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                        System.exit(0);
                }
        };

        frame.addWindowListener(l);
        frame.pack();
        frame.setVisible(true);
	frame.listenSocket();
  }
}
