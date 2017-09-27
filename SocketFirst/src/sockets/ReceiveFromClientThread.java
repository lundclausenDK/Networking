package sockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Date;

public class ReceiveFromClientThread implements Runnable {
    
    Socket cs = null;
    Date date = new Date();
    
    public ReceiveFromClientThread(Socket cs) {
        this.cs = cs;
    }
    
    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(this.cs.getInputStream()));
            String messageString;
            
            while (true) {
                while ((messageString = br.readLine()) != null ) {
                    if (messageString.equals("EXIT")) {
                        break;
                    }
                    System.out.println("------------------------------------------");
                    System.out.println(date);
                    System.out.println("From Client: " + messageString);
                    System.out.println("------------------------------------------");
                    System.out.println("Please enter new message back to client...");
                }
                this.cs.close();
                System.exit(0);
            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
