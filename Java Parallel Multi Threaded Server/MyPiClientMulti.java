import java.net.*;
import java.io.*;

public class MyPiClientMulti {
    //onoma tou host
        private static final String HOST = "localhost";
        //arithmos thiras
	private static final int PORT = 1500;
	
	public static void main(String args[]) throws IOException {
        //dimiourgoume mia apli Berkeley thira typou Socket
		Socket dataSocket = new Socket(HOST, PORT);
		//Ginetai i syndesi
		InputStream is = dataSocket.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		OutputStream os = dataSocket.getOutputStream();
		PrintWriter out = new PrintWriter(os,true);
		       	
		String inmsg, outmsg;
        //kataskeyazoume to protokollo tou pelati
		MyPiClientProtocol app = new MyPiClientProtocol();
		//kathe pelatis 'zitaei' 10 fores eksipiretisi
		//int iters = 10;
		//for (int i = 0; i < iters; i++)  {
		        outmsg = app.prepareRequest();
                //kanei to write
			out.println(outmsg);
            //meta to read
			inmsg = in.readLine();
            //epeksergasia tou minimatos
			app.processReply(inmsg);
			
	//	}
		outmsg = app.prepareExit();
        //write tou apotelesmatos
		out.println(outmsg);
		//kleinoume ti thira
		dataSocket.close();
	}
}			

