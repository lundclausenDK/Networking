package turnstiles;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Turnstile extends Thread {

    static int ticket = 0;
    private Socket clientSocket;
    private BufferedReader br;

    public Turnstile(Socket s) {
        clientSocket = s;
    }

    @Override
    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            while (ticket != 30000) {
                if (br.readLine().equalsIgnoreCase("turn")) {
                    inc();
                    System.out.println(ticket);
                }
            }
            
            Server.isAlive = false;
            br.close();
            clientSocket.close();
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        

        //DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        //outToServer.write(this.ticket);
        //clientSocket.close();
        //clientSocket.close();
    }

    synchronized void inc() {
        ticket++;
    }

}
