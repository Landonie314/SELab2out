package lab2out;


import javax.swing.*;

import lab2out.ClientGUI.EventHandler;

import java.awt.*;
import java.awt.event.*;


public class ServerGUI extends JFrame{
	private JLabel status; //Initialized to “Not Connected”
	private String[] labels = {"Port #", "Timeout"};
	private JTextField[] textFields = new JTextField[labels.length];
	private JTextArea log;
	private ChatServer server;
	private JLabel port, time;
	private boolean tserv = false;


   //Methods go here


public ServerGUI(String title) {
	
int i = 0;
    
    this.setTitle(title);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //ADD YOUR CODE HERE TO CREATE THE STATUS JLABEL AND THE JBUTTONS
    
    //Top JPanel
    JPanel north = new JPanel(new FlowLayout());
    getContentPane().add(north);
    
    JLabel stat = new JLabel("Status:");
    north.add(stat);
    JLabel status = new JLabel ("Not Connected");
    status.setForeground(Color.red);
    north.add(status);
    
    JPanel center = new JPanel();
    
    this.port = new JLabel(labels[0]);
    this.time = new JLabel(labels[1]);
    
    JTextField textField = new JTextField();
    textFields[0] = textField;
    JTextField textField_1 = new JTextField();
    textFields[1] = textField_1;
    
    
    JLabel logL = new JLabel("Server Log Below");
    this.log = new JTextArea();
    
    JScrollPane back = new JScrollPane();
    SpringLayout sl_center = new SpringLayout();
    sl_center.putConstraint(SpringLayout.SOUTH, back, -6, SpringLayout.NORTH, log);
    sl_center.putConstraint(SpringLayout.SOUTH, logL, -6, SpringLayout.NORTH, log);
    sl_center.putConstraint(SpringLayout.EAST, log, -10, SpringLayout.EAST, center);
    sl_center.putConstraint(SpringLayout.WEST, textField_1, 6, SpringLayout.EAST, time);
    sl_center.putConstraint(SpringLayout.EAST, textField_1, -10, SpringLayout.EAST, center);
    sl_center.putConstraint(SpringLayout.NORTH, time, 3, SpringLayout.NORTH, textField_1);
    sl_center.putConstraint(SpringLayout.EAST, time, 0, SpringLayout.EAST, port);
    sl_center.putConstraint(SpringLayout.NORTH, textField_1, 21, SpringLayout.SOUTH, textField);
    sl_center.putConstraint(SpringLayout.NORTH, log, 210, SpringLayout.NORTH, center);
    sl_center.putConstraint(SpringLayout.SOUTH, log, -24, SpringLayout.SOUTH, center);
    sl_center.putConstraint(SpringLayout.WEST, logL, 0, SpringLayout.WEST, port);
    sl_center.putConstraint(SpringLayout.WEST, back, 0, SpringLayout.WEST, port);
    sl_center.putConstraint(SpringLayout.WEST, log, -274, SpringLayout.EAST, center);
    sl_center.putConstraint(SpringLayout.WEST, textField, 140, SpringLayout.WEST, center);
    sl_center.putConstraint(SpringLayout.EAST, port, -6, SpringLayout.WEST, textField);
    sl_center.putConstraint(SpringLayout.EAST, textField, -10, SpringLayout.EAST, center);
    sl_center.putConstraint(SpringLayout.NORTH, port, 9, SpringLayout.NORTH, center);
    sl_center.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, port);
    center.setLayout(sl_center);
    
    center.add(port);
    center.add(time);
    center.add(textField);
    center.add(textField_1);
    center.add(logL);
    center.add(log);
    center.add(back);
    
    JPanel south = new JPanel(new FlowLayout());
    
  //Buttons
    JButton listen = new JButton("Listen");
    JButton close = new JButton("Close");
    JButton stop = new JButton("Stop");
    JButton quit = new JButton("Quit");
    
    //add buttons to the JPanel
    south.add(listen);
    south.add(close);
    south.add(stop);
    south.add(quit);
    
    //Listeners
    //Initialize EventHandler
    EventHandler eventHandler = new EventHandler();
    listen.addActionListener(eventHandler);
    close.addActionListener(eventHandler);
    stop.addActionListener(eventHandler);
    quit.addActionListener(eventHandler);
    
  //Window stuff
    getContentPane().add(north,BorderLayout.NORTH);
    getContentPane().add(center,BorderLayout.CENTER);
    getContentPane().add(south,BorderLayout.SOUTH);
    this.setSize(300,500);
    this.setVisible(true);
}



public static void main(String[] args) {
	
  new ServerGUI(args[0]); //args[0] represents the title of the GUI
  
}

//Button Actions
class EventHandler implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Detect which button was pressed
		String buttonText = e.getActionCommand();
		
		if(buttonText.toLowerCase().equals("listen")) {
			System.out.println("Listen Button Pressed");
			if(port.getText() == null || time.getText() == null) {
				
				//Add “Port Number/timeout not entered before pressing Listen” in the Server Log JTextArea.
				log.append("Port Number/timeout not entered before pressing Listen” in the Server Log JTextArea");
			}
			else {
				//Start server by calling serverStarted
				server.serverStarted();
				tserv = true;
			}
		}
		else if(buttonText.toLowerCase().equals("close")) {
			//from Lab1out
			//System.out.println("Close Button Pressed");
			
			// Invoke stop method
			server.serverStopped();
			// Invoke close method
			server.serverClose();
		}
		else if(buttonText.toLowerCase().equals("stop")) {
			System.out.println("Stop Button Pressed");
		
			//Create boolean for server being started. If false, add to log "Server not currently started"
			if(tserv == false) {
				log.append("Server not currently started");
			}
			//If server started, invoke stopListening method
			else if(tserv == true) {
				server.stopListening();
			}
			
		}
		else if(buttonText.toLowerCase().equals("quit")) {
			setVisible(false);
			dispose();
		
		}
	
	}
}

}