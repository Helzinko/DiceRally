package Game;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        ServerSocket serverSocket = null;

        serverSocket = new ServerSocket(2222);

        System.out.println(DateFormat.CurrentTime() + "Dice Rally server " + serverSocket.getLocalPort() + " started.");

        while (true){
            try {
                socket = serverSocket.accept();

                inputStreamReader = new InputStreamReader(socket.getInputStream());
                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

                bufferedReader = new BufferedReader(inputStreamReader);
                bufferedWriter = new BufferedWriter(outputStreamWriter);

                while (true){
                    String cmd = bufferedReader.readLine();

                    if(cmd.equals(String.valueOf(Command.CONNECT))){
                        String msg = bufferedReader.readLine();
                        System.out.println(DateFormat.CurrentTime() + msg + " connected!");
                    }
                    else if(cmd.equals(String.valueOf(Command.SEND))){
                        String name = bufferedReader.readLine();
                        String msg = bufferedReader.readLine();
                        System.out.println(DateFormat.CurrentTime() + name + ": " + msg);
                    }
                    else if(cmd.equals(String.valueOf(Command.ROLL))){
                        String name = bufferedReader.readLine();
                        String num = bufferedReader.readLine();
                        System.out.println(DateFormat.CurrentTime() + name + " rolled: " + num);
                    }
                    else{
                        System.out.println(cmd);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}