package Game;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class Frame extends JFrame {

    private static JTextArea jTextArea;

    public static boolean rollPressed = false;

    public static int mainFrameWidth = 1920;
    public static int mainFrameHeight = 1080;

    public static void ShowFrame(){

        JFrame frame = new JFrame("Dice Rally");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel gameWindow = GameWindow.ShowWindow();
        frame.add(gameWindow);

        Panel chatPanel = new Panel(mainFrameWidth, mainFrameHeight - GameWindow.windowSize, true);
        Chat.ChatPanel(chatPanel);
        frame.add(chatPanel, BorderLayout.SOUTH);

        frame.add(new Panel((mainFrameWidth - GameWindow.windowSize) / 2, GameWindow.windowSize, true), BorderLayout.EAST);
        frame.add(new Panel((mainFrameWidth - GameWindow.windowSize) / 2, GameWindow.windowSize, true), BorderLayout.WEST);

        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
