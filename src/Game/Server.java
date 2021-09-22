package Game;

import java.net.*;
import java.util.ArrayList;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server
{
    public static boolean firstPlayerTimeToRoll = false;

    private static final int PORT = 4200;
    public static ArrayList<ClientHandler> clients = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(2);

    public static void main(String args[]) throws IOException
    {
        ServerSocket listener = new ServerSocket(PORT);

        while(true){
            System.out.println("[SERVER] started!");
            Socket client = listener.accept();
            System.out.println("Waiting for players...");
            ClientHandler clientThread = new ClientHandler(client, clients);
            clients.add(clientThread);
            pool.execute(clientThread);


        }
    }
}