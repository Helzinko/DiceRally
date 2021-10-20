package Game;

import java.io.*;
import java.net.Socket;

public class Client extends Observer{
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 4200;
    public static int playerID;
    public static String playerName;
    public static String carType;
    public static PrintWriter out;
    public static Player player;
    public static Chat chat;

    public static void main(String[] args) throws IOException {
        chat = new Chat();

        Client client = new Client();
        client.subject = chat.instance;
        client.subject.attach(client);

        Socket socket = new Socket(SERVER_IP, SERVER_PORT);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String temp = reader.readLine();
        playerID = Integer.parseInt(temp);
        ServerConnection serverConn = new ServerConnection(socket, playerID);

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(socket.getOutputStream(), true);

        new Thread(serverConn).start();

        LoginWindow.CreateWindow();

        boolean canContinue = false;

        player = null;
        while (!canContinue) {
            Thread.yield();
            if (LoginWindow.pressed) {
                playerName = LoginWindow.loginInputField.getText();
                player = new Player(playerID, playerName);
                String text = " connected as ";
                Frame.ShowFrame();
                carType = LoginWindow.inputCarType.getSelectedItem().toString();
                String message = Wrapper.Encode(player, Command.CONNECT, text) + carType;
                out.println(message);
                canContinue = true;
            }
        }


        while (true) {
            //String text = keyboard.readLine();F
            Thread.yield();

            if (GameWindow.rollPressed) {
                GameWindow.rollPressed = false;
                String message = Wrapper.Encode(player, Command.ROLL, GameWindow.rolledMessage);
                out.println(message);
            }

            if (GameWindow.pausePressed) {
                GameWindow.pausePressed = false;
                //GameWindow.playPressed = true;
                String message = Wrapper.Encode(player, Command.PAUSE, "");
                out.println(message);
            }
        }
    }

    @Override
    public void update() {
            String text = subject.getState();
            String message = Wrapper.Encode(player, Command.SEND, text);
            out.println(message);
            chat.instance.sendField.setText("");
    }
}