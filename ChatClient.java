// Amirali Sanatinia amirali@ccs.neu.edu
// Network Security Java Socket Programming Demo

import java.net.*;

public class ChatClient {

	static final int MAX_UDP = 65507;
	static DatagramSocket socket = null;

	public static void main(String[] args) throws InterruptedException {
		while(true){
			Thread sndr = new Thread(new Sender());
			sndr.start();
			Thread.sleep(500);
		}
	}

	// Sending packets in separate threads
	static class Sender implements Runnable {

		public void run() {

			String srvIP = "127.0.0.1";
			int srvPort = 6666;
			InetAddress srvAddr = null;

			// setup upd scoket on remote
			try {
				socket = new DatagramSocket();
				srvAddr = InetAddress.getByName(srvIP);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// sending packets
			byte[] data = new byte[MAX_UDP];
			data = "Hello World!".getBytes();
			DatagramPacket sndPacket = new DatagramPacket(data, data.length,
					srvAddr, srvPort);
			try {
				socket.send(sndPacket);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
