package lab2out;

import java.io.IOException;

public class TestChatServer {
	private ChatServer server;
	
	public TestChatServer(int port, int timeout)
	{
		//1. Instanciate the pdf server
		server = new ChatServer();
		
		//2. Set the port to 8300
		server.setPort(port);
		//3. Set the timeout to 500
		server.setTimeout(timeout);
		//4. Start the server listening (invoke the listen)
		try {
			server.listen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//5. Output to the console that the Constructor is finished (remove when steps 2-4 are complete)
		System.out.println("Constructor finished");
		
	}
	
	public static void main(String[] args)
	{
		//Convert args[0] to an int
		int port = Integer.parseInt(args[0]);
		int timeout = Integer.parseInt(args[1]);
		
		new TestChatServer(port,timeout);
		
	}
	
	
	
	
}
