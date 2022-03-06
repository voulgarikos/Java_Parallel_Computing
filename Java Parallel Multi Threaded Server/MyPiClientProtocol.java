import java.net.*;
import java.io.*;
import java.util.Scanner;

public class MyPiClientProtocol {
    //etoimazoume to aitima sto Server
	public String prepareRequest() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Dwste plithos vimaton gia ypologismo tou Pi i -1 gia Exodo");
        int numSteps = scan.nextInt();
        String theOutput = Integer.toString(numSteps);
		return theOutput;
        }
        //etoimazoume tin eksodo apo to programma
        public String prepareExit() throws IOException {
	
     		String theOutput = "-1";
		return theOutput;
        }

	public void processReply(String theInput) throws IOException {
	//emfanizoume to apotelesma stin othoni
		System.out.println("Calculated Pi: " + theInput);
	}
}