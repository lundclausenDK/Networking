package sockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Date;

public class ReceiveThread implements Runnable {

    Socket sock = null;
    BufferedReader recieve = null;
    Date date = new Date();

    public ReceiveThread(Socket sock) {
        this.sock = sock;
    }//end constructor

    public void run() {
        try {
            recieve = new BufferedReader(new InputStreamReader(this.sock.getInputStream()));//get inputstream
            String msgRecieved = null;
            while ((msgRecieved = recieve.readLine()) != null) {
                System.out.println("------------------------------------------");
                System.out.println(date);
                System.out.println("From Server: " + msgRecieved);
                System.out.println("------------------------------------------");
                System.out.println("Please enter something to send to server..");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
