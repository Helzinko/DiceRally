package Game;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        System.out.println(DateFormat.CurrentTime() + "Welcome to Dice Rally, to start playing input your name:");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        Player player = new Player(0, name);

        System.out.println(DateFormat.CurrentTime() + "Welcome " + name + ". If you want to write use SEND, if you want to roll dice use ROLL.");

        connectToServer(player);
    }

    private static void connectToServer(Player player) {
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            socket = new Socket("localhost", 2222);

            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            Scanner scanner = new Scanner(System.in);

            // Send connection name --
            bufferedWriter.write(String.valueOf(Command.CONNECT));
            bufferedWriter.newLine();
            bufferedWriter.write(player.GetName());
            bufferedWriter.newLine();
            bufferedWriter.flush();
            // -----------------------------------

            while(true){

                String cmd = scanner.nextLine();

                if(cmd.equals(String.valueOf(Command.SEND))){
                    System.out.println(DateFormat.CurrentTime() + "Write your message: ");

                    String msg = scanner.nextLine();
                    bufferedWriter.write(String.valueOf(Command.SEND));
                    bufferedWriter.newLine();
                    bufferedWriter.write(player.GetName());
                    bufferedWriter.newLine();
                    bufferedWriter.write(msg);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                    System.out.println(DateFormat.CurrentTime() + player.GetName() + ": " + msg);
                }
                else if(cmd.equals(String.valueOf(Command.ROLL))){
                    int number = Dice.Roll();

                    bufferedWriter.write(String.valueOf(Command.ROLL));
                    bufferedWriter.newLine();
                    bufferedWriter.write(player.GetName());
                    bufferedWriter.newLine();
                    bufferedWriter.write(String.valueOf(number));
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                    System.out.println(DateFormat.CurrentTime() + "You rolled " + number);
                }
                else{
                    System.out.println(DateFormat.CurrentTime() + "Unknown command. Commands: SEND, ROLL.");
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(socket != null){
                    socket.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
