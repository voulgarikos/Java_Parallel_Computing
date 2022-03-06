import java.net.*;
import java.io.*;


public class MyMultiPiServer {
    
    private static final int PORT = 1500;
	public static MyPiSharedList mnimi = new MyPiSharedList();

	public static void main(String args[]) throws IOException {

        //dimiourgei ypodoxes
		ServerSocket connectionSocket = connectionSocket = new ServerSocket(PORT);
		
		while (true) {	

			System.out.println("Server is listening to port: " + PORT);
            //dexetai ypodoxes
			Socket dataSocket = connectionSocket.accept();
			//System.out.println("Received request from " + dataSocket.getInetAddress());
            //dimiourgei kai anoigei nimata
			MyPiServerThread sthread = new MyPiServerThread(dataSocket, mnimi);
			sthread.start();
		}
	}
}

