package turnstiles;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Server {
    
    static boolean isAlive = true;
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        System.out.println("FOOTBALL STADIUM - TURNSTILE COUNTING SYSTEM INITIATED");
        System.out.println("******************************************************");
        System.out.println("30.000 seats available - Please start TurnstileClient...");
     
        
        ExecutorService es = Executors.newCachedThreadPool();
        
        //String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket(6666);
        welcomeSocket.setSoTimeout(3000);
        
        while (isAlive) {

            try {
                Socket connectionSocket = welcomeSocket.accept();
                
                if (connectionSocket.isConnected()) {
                    es.execute(new Turnstile(connectionSocket));
                }
                
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            
            
            
            
            
            
            
            /*
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            
            clientTicket = inFromClient.read();
            
            count += clientTicket;
            
            //System.out.println("Received: " + clientTicket);
            System.out.println("Stadium Count: " + count);
            //capitalizedSentence = clientSentence.toUpperCase() + "\n";
            //outToClient.writeBytes(capitalizedSentence);
            outToClient.write(count);
            */
        }
        
        System.out.println("Alle seats are occupied. Stadium full.");
        
        
        welcomeSocket.close();
        es.shutdownNow();
        es.awaitTermination(1, TimeUnit.SECONDS);
    }
}
