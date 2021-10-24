package Game;

import Game.PlayerProfile.AbstractFactory;
import Game.PlayerProfile.FactoryProducer;
import Game.PlayerProfile.Person;

import javax.swing.*;

import java.awt.*;

import java.io.IOException;

public class Frame extends JFrame {

    private static JTextArea jTextArea;

    public static int mainFrameWidth = 1920;
    public static int mainFrameHeight = 1080;

    public static JFrame frame;

    private static boolean enemyAlreadyExist = false;

    public static Panel player1Panel;
    public static Panel player2Panel;

    private static ProfilePanel profilePanel;
    private static EnemyPanel enemyProfilePanel;

    private static Person person;

    public static void ShowFrame() throws IOException {

        frame = new JFrame("Dice Rally");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel gameWindow = GameWindow.ShowWindow();
        frame.add(gameWindow);

        Panel chatPanel = new Panel(mainFrameWidth, mainFrameHeight - GameWindow.windowSize, true);
        Chat.ChatPanel(chatPanel);

        DrawPlayersProfile();

        frame.add(chatPanel, BorderLayout.SOUTH);

        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void DrawPlayersProfile() throws IOException {
        boolean isMale = true;

        if(LoginWindow.inputSexType.getSelectedItem().toString().equals("Female")){
            isMale = false;
        }

        String hairColor = LoginWindow.inputHairColor.getSelectedItem().toString();

        AbstractFactory shapeFactory = FactoryProducer.getFactory(isMale);
        person = shapeFactory.getPerson(hairColor);

//        if(Client.playerID == 1){
//            player1Panel = new Panel((mainFrameWidth - GameWindow.windowSize) / 2, GameWindow.windowSize, true);
//            profilePanel = new ProfilePanel(player1Panel.pWidth, player1Panel.pHeight, true, 60, 100);
//            frame.add(profilePanel.PaintProfilePanel(player1Panel, person), BorderLayout.WEST);
//        }
//        else if(Client.playerID == 0){
            player1Panel = new Panel((mainFrameWidth - GameWindow.windowSize) / 2, GameWindow.windowSize, true);
            profilePanel = new ProfilePanel(player1Panel.pWidth, player1Panel.pHeight, true, 60, 100);
            profilePanel.PaintProfilePanel(player1Panel, person);
            frame.add(profilePanel, BorderLayout.WEST);
//        }
    }

    public static void DrawEnemyProfile(Person enemy, String enemyName) throws IOException {
        if(!enemyAlreadyExist){
            if(Client.playerID == 1){
                player2Panel = new Panel((mainFrameWidth - GameWindow.windowSize) / 2, GameWindow.windowSize, true);
                enemyProfilePanel = new EnemyPanel(player2Panel.pWidth, player2Panel.pHeight, true, 60, 100);
                enemyProfilePanel.PaintProfilePanel(player2Panel, enemy, enemyName);
                frame.add(enemyProfilePanel, BorderLayout.EAST);
            }
            else if(Client.playerID == 0){
                player2Panel = new Panel((mainFrameWidth - GameWindow.windowSize) / 2, GameWindow.windowSize, true);
                enemyProfilePanel = new EnemyPanel(player2Panel.pWidth, player2Panel.pHeight, true, 60, 100);
                enemyProfilePanel.PaintProfilePanel(player2Panel, enemy, enemyName);
                frame.add(enemyProfilePanel, BorderLayout.EAST);

                boolean isMale = true;
                if(LoginWindow.inputSexType.getSelectedItem().toString().equals("Female")){
                    isMale = false;
                }
                String hairColor = LoginWindow.inputHairColor.getSelectedItem().toString();

                String profile = Wrapper.Encode(Client.player, Command.PROFILE, hairColor+"-"+isMale+"-"+Client.playerName);
                Client.out.println(profile);
            }

            enemyAlreadyExist = true;
        }

    }

    public static void updatePlayerInfo(String playerName, double fuel, double health) throws IOException {
        if(Client.playerName.equals(playerName)){
            profilePanel.updadeInfo(fuel, health);
        }
        else {
            enemyProfilePanel.updadeInfo(fuel, health);
        }
    }

}
