package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow {

    private static JFrame jFrame;
    private static JPanel chatPanel;
    private static JPanel boardPanel;

    public static void PaintWindow(){
        jFrame = new JFrame();

        chatPanel = new JPanel();
        boardPanel = new JPanel();

        boardPanel.setBackground(Color.gray);
        jFrame.setLayout(new GridLayout(1, 2));
        ChatPanel();
        BoardPanel();
        jFrame.add(chatPanel);
        jFrame.add(boardPanel);

        jFrame.setSize(1920, 1080);
        jFrame.setVisible(true);
    }

    public static void ChatPanel(){

    }

    public static void BoardPanel(){

    }

    private static JTextArea jTextArea;

    public static void CreateWindow(){
        JPanel textPanel = new JPanel();
        textPanel.add(jTextArea);

    }

    public static void AddMessage(String message){
        if(jTextArea != null)
            jTextArea.append( message + "\n" );
    }


}
