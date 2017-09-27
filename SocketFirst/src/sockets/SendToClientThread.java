package sockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SendToClientThread implements Runnable {
    
    PrintWriter pw;
    Socket cs = null;
    
    public SendToClientThread(Socket cs) {
        this.cs = cs;
    }
    
    @Override
    public void run() {
        
        try {
            pw = new PrintWriter(new OutputStreamWriter(this.cs.getOutputStream()));
            
            while (true) {
                String msg = null;
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                
                msg = input.readLine();
                pw.println(msg);
                pw.flush();
                System.out.println("Please enter new message back to client...");
            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }

}
