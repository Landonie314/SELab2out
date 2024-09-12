package lab2out;


import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.*;
import java.awt.event.*;


public class ClientGUI extends JFrame
{
  
  private JLabel status;
  private JButton connect;
  private JButton submit;
  private JButton stop;
  private String[] labels = {"Client ID", "Server URL", "Server Port"};
  private JTextField[] textFields = new JTextField[labels.length];
  private JTextArea clientArea;
  private JTextArea serverArea;
  private JPanel center;
  private JPanel north;
  private JPanel south;
 
  public ClientGUI(String title)
  {
    int i = 0;
    
    this.setTitle(title);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //ADD YOUR CODE HERE TO CREATE THE STATUS JLABEL AND THE JBUTTONS
    
    //Top JPanel
    JPanel north = new JPanel(new FlowLayout());
    getContentPane().add(north);
    
    //JLabel
    JLabel stat = new JLabel("Status:");
    north.add(stat);
    JLabel status = new JLabel ("Not Connected");
    status.setForeground(Color.red);
    north.add(status);
    
    //Center JPanel
    JPanel center = new JPanel();
//    getContentPane().add(center);
    //center = new JPanel();
    
    //labels
    JLabel id = new JLabel(labels[0]);
    id.setVerticalAlignment(SwingConstants.TOP);
    JLabel url = new JLabel(labels[1]);
    JLabel port = new JLabel(labels[2]);
    //TextFields
    JTextField textField = new JTextField();
    textField.setEditable(false);
    textFields[0] = textField;
    JTextField textField_1 = new JTextField();
    textFields[1] = textField_1;
    JTextField textField_2 = new JTextField();
    textFields[2] = textField_2;
    //Not editable
    textFields[0].setEditable(false);
    SpringLayout sl_center = new SpringLayout();
    sl_center.putConstraint(SpringLayout.NORTH, url, 15, SpringLayout.SOUTH, id);
    sl_center.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.NORTH, center);
    sl_center.putConstraint(SpringLayout.WEST, textField, 16, SpringLayout.EAST, id);
    sl_center.putConstraint(SpringLayout.EAST, textField, -34, SpringLayout.EAST, center);
    sl_center.putConstraint(SpringLayout.NORTH, textField_2, 11, SpringLayout.SOUTH, textField_1);
    sl_center.putConstraint(SpringLayout.WEST, textField_2, 25, SpringLayout.EAST, port);
    sl_center.putConstraint(SpringLayout.EAST, textField_2, -44, SpringLayout.EAST, center);
    sl_center.putConstraint(SpringLayout.NORTH, port, 17, SpringLayout.SOUTH, url);
    sl_center.putConstraint(SpringLayout.NORTH, textField_1, 9, SpringLayout.SOUTH, textField);
    sl_center.putConstraint(SpringLayout.WEST, textField_1, 16, SpringLayout.EAST, url);
    sl_center.putConstraint(SpringLayout.EAST, textField_1, -34, SpringLayout.EAST, center);
    sl_center.putConstraint(SpringLayout.EAST, port, 130, SpringLayout.WEST, center);
    sl_center.putConstraint(SpringLayout.EAST, url, 129, SpringLayout.WEST, center);
    sl_center.putConstraint(SpringLayout.EAST, id, 129, SpringLayout.WEST, center);
    sl_center.putConstraint(SpringLayout.NORTH, id, 9, SpringLayout.NORTH, center);
    center.setLayout(sl_center);
   
    
    
    center.add(id);
    center.add(textFields[0]);
    center.add(url);
    center.add(textFields[1]);
    center.add(port);
    center.add(textFields[2]);
  //TextArea and Labels
    JLabel cData = new JLabel("Enter Client Data Below");
    sl_center.putConstraint(SpringLayout.SOUTH, cData, -254, SpringLayout.SOUTH, center);
    sl_center.putConstraint(SpringLayout.EAST, cData, -83, SpringLayout.EAST, center);
    
    //add components to center panel
    center.add(cData);
    
    this.clientArea = new JTextArea();
    center.add(clientArea);
    
    JLabel sData = new JLabel("Recieved Server Data");
    center.add(sData);
    
    this.serverArea = new JTextArea();
    center.add(serverArea);
    
    //Put in ScrollPanes
    JScrollPane uno = new JScrollPane();
    sl_center.putConstraint(SpringLayout.NORTH, uno, 6, SpringLayout.SOUTH, cData);
    sl_center.putConstraint(SpringLayout.WEST, uno, 41, SpringLayout.WEST, center);
    sl_center.putConstraint(SpringLayout.SOUTH, uno, -152, SpringLayout.SOUTH, center);
    sl_center.putConstraint(SpringLayout.EAST, uno, -29, SpringLayout.EAST, center);
    JScrollPane dos = new JScrollPane();
    sl_center.putConstraint(SpringLayout.NORTH, dos, 6, SpringLayout.SOUTH, sData);
    sl_center.putConstraint(SpringLayout.WEST, dos, 41, SpringLayout.WEST, center);
    sl_center.putConstraint(SpringLayout.SOUTH, dos, -10, SpringLayout.SOUTH, center);
    sl_center.putConstraint(SpringLayout.EAST, dos, -29, SpringLayout.EAST, center);
    

    sl_center.putConstraint(SpringLayout.NORTH, clientArea, 6, SpringLayout.SOUTH, cData);
    sl_center.putConstraint(SpringLayout.WEST, clientArea, 41, SpringLayout.WEST, center);
    sl_center.putConstraint(SpringLayout.SOUTH, clientArea, -152, SpringLayout.SOUTH, center);
    sl_center.putConstraint(SpringLayout.EAST, clientArea, -29, SpringLayout.EAST, center);
    sl_center.putConstraint(SpringLayout.NORTH, sData, 21, SpringLayout.SOUTH, clientArea);
    sl_center.putConstraint(SpringLayout.EAST, sData, 0, SpringLayout.EAST, cData);
    
    sl_center.putConstraint(SpringLayout.WEST, dos, 6, SpringLayout.EAST, serverArea);
    sl_center.putConstraint(SpringLayout.NORTH, serverArea, 6, SpringLayout.SOUTH, sData);
    sl_center.putConstraint(SpringLayout.WEST, serverArea, 41, SpringLayout.WEST, center);
    sl_center.putConstraint(SpringLayout.SOUTH, serverArea, -10, SpringLayout.SOUTH, center);
    sl_center.putConstraint(SpringLayout.EAST, serverArea, -29, SpringLayout.EAST, center);
       
       //Not editable
       serverArea.setEditable(false);
    center.add(uno);
    center.add(dos);

    //Bottom JPanel
    JPanel south = new JPanel(new FlowLayout());
    getContentPane().add(south);
    
    //Buttons
    JButton submit = new JButton("Submit");
    JButton connect = new JButton("Connect");
    JButton stop = new JButton("Stop");
    
    //add buttons to the JPanel
    south.add(connect);
    south.add(submit);
    south.add(stop);
    
    //Listeners
    //Initialize EventHandler
    EventHandler eventHandler = new EventHandler();
    submit.addActionListener(eventHandler);
    connect.addActionListener(eventHandler);
    stop.addActionListener(eventHandler);
    
    
    //Window stuff
    getContentPane().add(north,BorderLayout.NORTH);
    getContentPane().add(center,BorderLayout.CENTER);
    getContentPane().add(south,BorderLayout.SOUTH);
    this.setSize(300,500);
    this.setVisible(true);
  }
  
  public static void main(String[] args)
  {
    new ClientGUI(args[0]); //args[0] represents the title of the GUI
  }
  
  //Button Actions
  class EventHandler implements ActionListener
  {
	  
	public void actionPerformed(ActionEvent e) {
		
		//Detect which button was pressed
		String buttonText = e.getActionCommand();
		
		if(buttonText.toLowerCase().equals("connect")) {
			System.out.println("Connect Button Pressed");
		}
		else if(buttonText.toLowerCase().equals("submit")) {
		    
			System.out.println("Client Data: " + clientArea.getText());
			
		}
		else if(buttonText.toLowerCase().equals("stop")) {
			System.out.println("Stop Button Pressed");
		
		}
	
	}
	  
  
  }
}
