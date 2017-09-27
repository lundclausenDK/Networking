package sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        final int port = 444;
        System.out.println("Server waiting for connection on port " + port);

        ServerSocket ss = new ServerSocket(port);
        Socket cs;

        while (true) {
            cs = ss.accept();
            System.out.println("Received connection from " + cs.getInetAddress() + " on port " + cs.getPort());

            ReceiveFromClientThread receive = new ReceiveFromClientThread(cs);
            new Thread(receive).start();

            SendToClientThread send = new SendToClientThread(cs);
            new Thread(send).start();
        }

    }

}
