package turnstiles;

public class TurnstileClient {

    public static void main(String[] args) throws Exception {
        
        Turnstile t1 = new Turnstile();
        Turnstile t2 = new Turnstile();
//        Turnstile t3 = new Turnstile();
//        Turnstile t4 = new Turnstile();
        
        t1.start();
        t2.start();
//        t3.start();
//        t4.start();

        //clientSocket.close();
    }

}
