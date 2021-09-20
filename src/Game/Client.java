package Game;

import java.io.*;
import java.net.Socket;

public class Client{
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 4200;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);

        ServerConnection serverConn = new ServerConnection(socket);

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out  = new PrintWriter(socket.getOutputStream(), true);

        new Thread(serverConn).start();

        while(true){
            System.out.println(">");

            String command = keyboard.readLine();

            out.println(command);
        }
    }
}