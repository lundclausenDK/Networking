package turnstiles;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    public static void main(String[] args) throws IOException {
        System.out.println("FOOTBALL STADIUM - TURNSTILE COUNTING SYSTEM INITIATED");
        System.out.println("******************************************************");
        System.out.println("30.000 seats available - Please start TurnstileClient...");
        
        int count = 0;
        int clientTicket;
        
        //String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket(6666);
        
        while (count != 30000) {
            Socket connectionSocket = welcomeSocket.accept();
            
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            
            clientTicket = inFromClient.read();
            
            count += clientTicket;
            
            //System.out.println("Received: " + clientTicket);
            System.out.println("Stadium Count: " + count);
            //capitalizedSentence = clientSentence.toUpperCase() + "\n";
            //outToClient.writeBytes(capitalizedSentence);
            outToClient.write(count);
        }
        
        System.out.println("Alle seats are occupied. Stadium full.");
    }
}
