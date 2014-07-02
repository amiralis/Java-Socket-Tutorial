// Amirali Sanatinia amirali@ccs.neu.edu
// Network Security Java Socket Programming Demo

import java.util.*;
import java.net.*;

public class ChatServer {

    public static void main(String[] args) {

        int serverPort = 6666;

        System.out.printf("Server Initialized on port %d \n", serverPort);
        final int  MAX_UDP = 65507;

        try{
        // open a new upd socket to listen to
        DatagramSocket serverSocket = new DatagramSocket(serverPort);

        while(true){

            DatagramPacket packetRcvd = new DatagramPacket(new byte[MAX_UDP], MAX_UDP);
            serverSocket.receive(packetRcvd);
            byte rcvdData[]= packetRcvd.getData();
            System.out.printf("Client %s sent %s \n",
              packetRcvd.getSocketAddress().toString(), new String (rcvdData));

        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
