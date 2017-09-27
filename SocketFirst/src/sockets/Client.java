package sockets;

import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            Socket sock = new Socket("localhost", 444);
            
            SendThread sendThread = new SendThread(sock);
            new Thread(sendThread).start();
            
            
            ReceiveThread receiveThread = new ReceiveThread(sock);
            new Thread(receiveThread).start();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
        
        
        


    

}
