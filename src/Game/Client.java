package Game;

import Game.PlayerProfile.AbstractFactory;
import Game.PlayerProfile.FactoryProducer;
import Game.PlayerProfile.Person;

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
        int pausepressedCount = 1;
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

                String message = Wrapper.Encode(player, Command.CONNECT, text) + carType + " " + GameWindow.fuelTypes;
                out.println(message);

                boolean isMale = true;
                if(LoginWindow.inputSexType.getSelectedItem().toString().equals("Female")){
                    isMale = false;
                }
                String hairColor = LoginWindow.inputHairColor.getSelectedItem().toString();

                String profile = Wrapper.Encode(player, Command.PROFILE, hairColor+"-"+isMale+"-"+playerName);
                out.println(profile);

                canContinue = true;
            }
        }


        while (true) {
            //String text = keyboard.readLine();
            Thread.yield();

            if (GameWindow.rollPressed) {
                GameWindow.rollPressed = false;
                String message = Wrapper.Encode(player, Command.ROLL, GameWindow.rolledMessage);
                out.println(message);
            }

            if (GameWindow.needUpdate) {
                GameWindow.needUpdate = false;
                String message2 = Wrapper.Encode(player, Command.UPDATE_PROFILE, GameWindow.updateMessage);
                out.println(message2);
            }

            if (pausepressedCount==GameWindow.pausePressedCount) {
                String message;
                if(pausepressedCount%2==0)
                {
                    message = Wrapper.Encode(player, Command.PAUSE, "PLAY!");
                }
                else
                {
                    message = Wrapper.Encode(player, Command.PAUSE, "PAUSE!");
                }
                out.println(message);
                pausepressedCount++;
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