package tw.brad.tutor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Brad61 {

	public static void main(String[] args) {
		String mesg = "Hello, World";
		try {
			Socket socket = new Socket(InetAddress.getByName("10.0.101.65"), 9999);
			
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.append(mesg);
			pw.flush();
			pw.close();
			
			socket.close();
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
