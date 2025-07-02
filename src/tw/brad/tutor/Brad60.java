package tw.brad.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Brad60 {

	public static void main(String[] args) {
		byte[] buf = new byte[4*1024];
		while (true) {
			try {
				DatagramSocket socket = new DatagramSocket(8888);
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				System.out.println("wait...");
				socket.receive(packet);
				socket.close();
				System.out.println("Receiver OK");
				
				String urip =  packet.getAddress().getHostAddress();
				int len = packet.getLength();
				byte[] data = packet.getData();
				String mesg = new String(data,0,len);
				System.out.printf("%s : %s\n", urip, mesg);
				if (mesg.equals("quit")) {
					break;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}

}
