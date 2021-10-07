package Game;

import Game.singleton.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private ArrayList<ClientHandler> clients;
    private int id;

    public ClientHandler(Socket clientSocket, ArrayList<ClientHandler> clients, int id) throws IOException {
        this.client = clientSocket;
        this.clients = clients;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
        this.id = id;
    }

    @Override
    public void run() {
        try{
            out.println(id);
            while(true){
                String request = in.readLine();
                Logger logger = Logger.getInstance();
                logger.log(request);
                outToAll(request);
            }
        }catch (IOException e){
            System.err.println("IO exception in client handler");
        }
        finally {
            out.close();
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void outToAll(String msg){
        for(ClientHandler aClient : clients){
            aClient.out.println(msg);
        }
    }
}
