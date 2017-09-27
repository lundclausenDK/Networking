package sockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SendThread implements Runnable {

    Socket sock = null;
    PrintWriter print = null;
    BufferedReader br = null;

    public SendThread(Socket sock) {
        this.sock = sock;
    }

    public void run() {
        try {
            if (sock.isConnected()) {
                System.out.println("Client connected to " + sock.getInetAddress() + " on port " + sock.getPort());
                this.print = new PrintWriter(sock.getOutputStream(), true);
                while (true) {
                    System.out.println("Type your message to send to server..type 'EXIT' to exit");
                    br = new BufferedReader(new InputStreamReader(System.in));
                    String msgtoServerString = null;
                    msgtoServerString = br.readLine();
                    this.print.println(msgtoServerString);
                    this.print.flush();

                    if (msgtoServerString.equals("EXIT")) {
                        break;
                    }
                }//end while
                sock.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
