package turnstiles;

import java.io.*;
import java.net.Socket;
import java.util.logging.*;

public class Turnstile extends Thread {

    private int ticket = 1;
    private Socket clientSocket;

    @Override
    public void run() {
        try {
            while (true) {
                clientSocket = new Socket("localhost", 6666);
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

                outToServer.write(this.ticket);

                clientSocket.close();
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(TurnstileClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //clientSocket.close();
    }

}
