package tw.brad.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Brad59 {

	public static void main(String[] args) {
		String mesg = "票投謝新達, 台灣會發達";
		byte[] data = mesg.getBytes();
		try {
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket pocket = new DatagramPacket(data, data.length,
					InetAddress.getByName("10.0.101.255"), 8888);
			socket.send(pocket);
			socket.close();
			System.out.println("Send OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
