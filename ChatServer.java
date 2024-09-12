package lab2out;

import ocsf.server.*;

import java.awt.Color;

import javax.swing.*;

public class ChatServer extends AbstractServer {
	private JTextArea log;
	private JLabel status;
	
	
	public ChatServer()
{
	super(12345);
	setTimeout(500);
	setLog(log);
	setStatus(status);
}
	
	public void setLog(JTextArea log) {
		this.log = log;
	}
	
	public void setStatus(JLabel status) {
		this.status = status;
	}
	
	public void handleMessageFromClient(Object arg0, ConnectionToClient arg1) {
		System.out.println("Message from Client Received");
	}
	public void listeningException(Throwable exception) {
		System.out.println("Listening Exception Occurred");
		System.out.println(exception.getMessage());
		exception.printStackTrace();
		//Display the message associated with the parameter exception in the log JTextArea of the ServerGUI whenever this method is invoked. 
		//log shows "Press Listen to Restart Server"
		log.append("Press Listen to Restart Server");
		//status shows "Exception Occurred when Listening" in red
		status.setText("Exception Occurred when Listening");
		status.setForeground(Color.red);
	}
	
public void serverStopped() {
	//Change label to Stopped in red
	status.setText("Stopped");
	status.setForeground(Color.red);
	//Print to server log “Server Stopped Accepting New Clients - Press Listen to Start Accepting New Clients” 
	log.append("Server Stopped Accepting New Clients - Press Listen to Start Accepting New Clients");
}

public void serverClose() {
	//Change label to Close in red
	status.setText("Close");
	status.setForeground(Color.red);
	// Display message to log “Server and all current clients are closed - Press Listen to Restart”
	log.append("Server and all current clients are closed - Press Listen to Restart");
	
}

public void serverStarted() {
	log.append("Server started"); //Needs to print to the server log
	//change status label to Listening in green
	status.setText("Listening");
	status.setForeground(Color.green);
	}

public void clientConnected(ConnectionToClient client) {
	//Display "Client connected" to log
	log.append("Client connected");
}

}