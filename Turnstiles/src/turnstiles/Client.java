package turnstiles;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    
    public static void main(String[] args) throws IOException {
        
        Socket s = new Socket("localhost", 6666);
        
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        
        while (!s.isOutputShutdown()) {
            out.println("turn");
        }
        
        out.close();
        s.close();
        
    }
}
